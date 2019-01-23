package by.etc.karamach.dao.sql.impl;

import by.etc.karamach.bean.Question;
import by.etc.karamach.dao.DAOException;
import by.etc.karamach.dao.QuestionDAO;
import by.etc.karamach.dao.pool.ConnectionPool;
import by.etc.karamach.dao.pool.ConnectionPoolException;
import by.etc.karamach.dao.sql.query.*;
import by.etc.karamach.dao.sql.util.ResourceDestroyer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLQuestionDAO implements QuestionDAO {
    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private static final boolean AUTO_COMMIT_FALSE = false;
    private static final boolean AUTO_COMMIT_TRUE = true;

    private static final Logger logger = LogManager.getLogger();

    @Override
    public void createQuestion(int testId, String description, int userId) throws DAOException {
        Connection connection = null;

        PreparedStatement preparedStatement = null;

        try {
            connection = connectionPool.takeConnection();
            connection.setAutoCommit(AUTO_COMMIT_FALSE);


            preparedStatement = connection.prepareStatement(CreateQuestion.STATEMENT);

            preparedStatement.setString(CreateQuestion.QUESTION_DESCRIPTION_INPUT_INDEX, description);
            preparedStatement.setInt(CreateQuestion.QUESTION_OWNER_ID_INPUT_INDEX, userId);

            preparedStatement.execute();


            preparedStatement = connection.prepareStatement(CreateQuestion.GET_LAST_ID_STATEMENT);

            ResultSet resultSet = preparedStatement.executeQuery();


            if (!resultSet.next()) {
                throw new DAOException("Something goes wrong, try again!");
            }

            int lastId = resultSet.getInt(CreateQuestion.LAST_ID_RESULT_INDEX);

            preparedStatement = connection.prepareStatement(CreateQuestion.CREATE_RELATION_STATEMENT);

            preparedStatement.setInt(CreateQuestion.QUESTION_ID_INPUT_INDEX, lastId);
            preparedStatement.setInt(CreateQuestion.TEST_ID_INPUT_INDEX, testId);

            preparedStatement.execute();
            connection.commit();
        } catch (ConnectionPoolException e) {

            throw new DAOException("Couldn't take connection from connection pool", e);

        } catch (SQLException e) {

            throw new DAOException("Couldn't execute query to data source", e);

        } finally {
            try {
                ResourceDestroyer.closeAllWithRollBack(connection, preparedStatement);
            } catch (SQLException e) {
                throw new DAOException(e);
            }
        }
    }

    @Override
    public void updateQuestionName(int questionId, String newName) throws DAOException {
        Connection connection = null;

        PreparedStatement preparedStatement = null;

        try {
            connection = connectionPool.takeConnection();
            connection.setAutoCommit(AUTO_COMMIT_TRUE);


            preparedStatement = connection.prepareStatement(UpdateQuestionName.STATEMENT);

            preparedStatement.setString(UpdateQuestionName.QUESTION_DESCRIPTION_INPUT_INDEX, newName);
            preparedStatement.setInt(UpdateQuestionName.QUESTION_ID_INPUT_INDEX, questionId);

            preparedStatement.execute();


        } catch (ConnectionPoolException e) {

            throw new DAOException("Couldn't take connection from connection pool", e);

        } catch (SQLException e) {

            throw new DAOException("Couldn't execute query to data source", e);

        } finally {

            ResourceDestroyer.closeAll(connection, preparedStatement);
        }
    }

    @Override
    public void deleteTest(int questionId) throws DAOException {
        Connection connection = null;

        PreparedStatement preparedStatement = null;
        PreparedStatement secondStatement;

        try {
            connection = connectionPool.takeConnection();

            connection.setAutoCommit(AUTO_COMMIT_FALSE);


            preparedStatement = connection.prepareStatement(DeleteQuestionByQuestionId.STATEMENT);

            preparedStatement.setInt(DeleteQuestionByQuestionId.QUESTION_ID_INPUT_INDEX, questionId);

            preparedStatement.execute();


            secondStatement = connection.prepareStatement(DeleteQuestionByQuestionId.SECOND_STATEMENT);

            secondStatement.setInt(DeleteQuestionByQuestionId.QUESTION_ID_SECOND_INPUT_INDEX, questionId);

            secondStatement.execute();


            connection.commit();

        } catch (ConnectionPoolException e) {

            throw new DAOException("Couldn't take connection from connection pool", e);

        } catch (SQLException e) {

            throw new DAOException("Couldn't execute query to data source", e);

        } finally {


            try {

                ResourceDestroyer.closeAllWithRollBack(connection, preparedStatement);

            } catch (SQLException e) {

                logger.error(e);
                throw new RuntimeException(e);

            }

        }
    }

    @Override
    public Question getQuestionByQuestionsIdAndUserId(int questionId, int userId) throws DAOException {
        Connection connection = null;

        PreparedStatement preparedStatement = null;

        ResultSet resultSet = null;

        Question question = null;

        try {

            connection = connectionPool.takeConnection();
            connection.setAutoCommit(AUTO_COMMIT_TRUE);


            preparedStatement = connection.prepareStatement(FindQuestionByIdAndOwnerId.STATEMENT);

            preparedStatement.setInt(FindQuestionByIdAndOwnerId.QUESTION_ID_INPUT_INDEX, questionId);
            preparedStatement.setInt(FindQuestionByIdAndOwnerId.QUESTION_OWNER_ID_INPUT_INDEX, userId);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                question = new Question();

                String description =
                        resultSet.getString(FindQuestionByIdAndOwnerId.QUESTION_DESCRIPTION_RESULT_INDEX);
                question.setDescription(description);

                question.setId(questionId);
                question.setOwnerId(userId);

            }

        } catch (ConnectionPoolException e) {

            throw new DAOException("Couldn't take connection from connection pool", e);

        } catch (SQLException e) {

            throw new DAOException("Couldn't execute query to data source", e);

        } finally {

            ResourceDestroyer.closeAll(connection, preparedStatement, resultSet);
        }

        return question;
    }

    @Override
    public List<Question> getQuestionsByTestId(int testId) throws DAOException {
        Connection connection = null;

        PreparedStatement preparedStatement = null;

        ResultSet resultSet = null;

        List<Question> questions;

        try {

            connection = connectionPool.takeConnection();
            connection.setAutoCommit(AUTO_COMMIT_TRUE);


            preparedStatement = connection.prepareStatement(FindQuestionByTestId.STATEMENT);

            preparedStatement.setInt(FindQuestionByTestId.TEST_ID_INPUT_INDEX, testId);

            resultSet = preparedStatement.executeQuery();

            questions = new ArrayList<>();

            while (resultSet.next()) {
                Question question = extractQuestion(resultSet);

                questions.add(question);
            }

        } catch (ConnectionPoolException e) {

            throw new DAOException("Couldn't take connection from connection pool", e);

        } catch (SQLException e) {

            throw new DAOException("Couldn't execute query to data source", e);

        } finally {

            ResourceDestroyer.closeAll(connection, preparedStatement, resultSet);
        }

        return questions;
    }

    private Question extractQuestion(ResultSet resultSet) throws SQLException {
        Question question = new Question();

        int questionId = resultSet.getInt(FindQuestionByTestId.ID_RESULT_INDEX);
        String questionDescription = resultSet.getString(FindQuestionByTestId.DESCRIPTION_RESULT_INDEX);
        int ownerId = resultSet.getInt(FindQuestionByTestId.OWNER_ID_RESULT_INDEX);

        question.setOwnerId(ownerId);
        question.setId(questionId);
        question.setDescription(questionDescription);
        return question;
    }
}
