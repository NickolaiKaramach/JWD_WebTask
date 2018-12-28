package by.etc.karamach.dao.sql.impl;

import by.etc.karamach.bean.Question;
import by.etc.karamach.dao.DAOException;
import by.etc.karamach.dao.QuestionDAO;
import by.etc.karamach.dao.pool.ConnectionPool;
import by.etc.karamach.dao.pool.ConnectionPoolException;
import by.etc.karamach.dao.sql.query.FindQuestionByTestId;
import by.etc.karamach.utils.sql.ResourceDestroyer;
import org.apache.commons.lang3.exception.ExceptionUtils;
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
    private static final Logger logger = LogManager.getLogger();

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

            logger.error(ExceptionUtils.getStackTrace(e));


            throw new DAOException("Couldn't take connection from connection pool", e);

        } catch (SQLException e) {

            logger.error(ExceptionUtils.getStackTrace(e));


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
