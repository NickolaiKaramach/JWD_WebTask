package by.etc.karamach.dao.sql.impl;

import by.etc.karamach.bean.Question;
import by.etc.karamach.dao.DAOException;
import by.etc.karamach.dao.QuestionDAO;
import by.etc.karamach.dao.pool.ConnectionPool;
import by.etc.karamach.dao.pool.ConnectionPoolException;
import by.etc.karamach.dao.sql.query.FindQuestionByIdAndOwnerId;
import by.etc.karamach.dao.sql.query.FindQuestionByTestId;
import by.etc.karamach.dao.sql.util.ResourceDestroyer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLQuestionDAO implements QuestionDAO {
    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    public Question getQuestionByQuestionsIdAndUserId(int questionId, int userId) throws DAOException {
        Connection connection = null;

        PreparedStatement preparedStatement = null;

        ResultSet resultSet = null;

        Question question = null;

        try {

            connection = connectionPool.takeConnection();
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

        question.setId(questionId);
        question.setDescription(questionDescription);
        return question;
    }
}
