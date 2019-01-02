package by.etc.karamach.dao.sql.impl;

import by.etc.karamach.bean.Answer;
import by.etc.karamach.dao.AnswerDAO;
import by.etc.karamach.dao.DAOException;
import by.etc.karamach.dao.pool.ConnectionPool;
import by.etc.karamach.dao.pool.ConnectionPoolException;
import by.etc.karamach.dao.sql.query.FindAnswersByQuestionIdAndUserId;
import by.etc.karamach.dao.sql.util.ResourceDestroyer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLAnswerDAO implements AnswerDAO {
    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    public List<Answer> getAnswersByQuestionIdAndUserId(int questionId, int userId) throws DAOException {
        Connection connection = null;

        PreparedStatement preparedStatement = null;

        ResultSet resultSet = null;

        List<Answer> answers;

        try {

            connection = connectionPool.takeConnection();
            preparedStatement = connection.prepareStatement(FindAnswersByQuestionIdAndUserId.STATEMENT);

            preparedStatement.setInt(FindAnswersByQuestionIdAndUserId.QUESTION_ID_INPUT_INDEX, questionId);
            preparedStatement.setInt(FindAnswersByQuestionIdAndUserId.QUESTION_OWNER_ID_INPUT_INDEX, userId);

            resultSet = preparedStatement.executeQuery();

            answers = new ArrayList<>();

            while (resultSet.next()) {
                Answer answer = new Answer();

                boolean isRight = resultSet.getBoolean(FindAnswersByQuestionIdAndUserId.IS_RIGHT_RESULT_INDEX);
                String description = resultSet.getString(FindAnswersByQuestionIdAndUserId.DESCRIPTION_RESULT_INDEX);

                answer.setRight(isRight);
                answer.setDescription(description);

                answers.add(answer);
            }

        } catch (ConnectionPoolException e) {

            throw new DAOException("Couldn't take connection from connection pool", e);

        } catch (SQLException e) {

            throw new DAOException("Couldn't execute query to data source", e);

        } finally {

            ResourceDestroyer.closeAll(connection, preparedStatement, resultSet);
        }

        return answers;
    }
}
