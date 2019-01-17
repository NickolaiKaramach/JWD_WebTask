package by.etc.karamach.dao.sql.impl;

import by.etc.karamach.bean.Grade;
import by.etc.karamach.dao.ChoiceDAO;
import by.etc.karamach.dao.DAOException;
import by.etc.karamach.dao.pool.ConnectionPool;
import by.etc.karamach.dao.pool.ConnectionPoolException;
import by.etc.karamach.dao.sql.query.DeleteUnusedChoices;
import by.etc.karamach.dao.sql.query.GetCountAllChoicesByGrade;
import by.etc.karamach.dao.sql.query.GetCountRightChoicesByGrade;
import by.etc.karamach.dao.sql.query.SaveNewChoice;
import by.etc.karamach.dao.sql.util.ResourceDestroyer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLChoiceDAO implements ChoiceDAO {
    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();

    private static final boolean AUTO_COMMIT_FALSE = false;
    private static final boolean AUTO_COMMIT_TRUE = true;

    @Override
    public void deleteUnusedChoices() throws DAOException {
        Connection connection = null;

        PreparedStatement preparedStatement = null;

        try {
            connection = connectionPool.takeConnection();
            connection.setAutoCommit(AUTO_COMMIT_TRUE);


            preparedStatement = connection.prepareStatement(DeleteUnusedChoices.STATEMENT);

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
    public int getCountRightChoicesByGrade(Grade grade) throws DAOException {
        Connection connection = null;

        PreparedStatement preparedStatement = null;

        ResultSet resultSet = null;

        int rightChoicesCount = -1;

        try {

            connection = connectionPool.takeConnection();
            connection.setAutoCommit(AUTO_COMMIT_TRUE);


            preparedStatement = connection.prepareStatement(GetCountRightChoicesByGrade.STATEMENT);

            preparedStatement.setInt(GetCountRightChoicesByGrade.GRADE_ID_INPUT_INDEX, grade.getId());

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                rightChoicesCount = resultSet.getInt(GetCountRightChoicesByGrade.CHOICES_COUNT_RESULT_INDEX);
            }

        } catch (ConnectionPoolException e) {

            throw new DAOException("Couldn't take connection from connection pool", e);

        } catch (SQLException e) {

            throw new DAOException("Couldn't execute query to data source", e);

        } finally {

            ResourceDestroyer.closeAll(connection, preparedStatement, resultSet);
        }

        return rightChoicesCount;
    }

    @Override
    public int getCountAllChoicesByGrade(Grade grade) throws DAOException {
        Connection connection = null;

        PreparedStatement preparedStatement = null;

        ResultSet resultSet = null;

        int choicesCount = -1;

        try {

            connection = connectionPool.takeConnection();
            connection.setAutoCommit(AUTO_COMMIT_TRUE);


            preparedStatement = connection.prepareStatement(GetCountAllChoicesByGrade.STATEMENT);

            preparedStatement.setInt(GetCountAllChoicesByGrade.GRADE_ID_INPUT_INDEX, grade.getId());

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                choicesCount = resultSet.getInt(GetCountAllChoicesByGrade.COUNT_CHOICES_RESULT_INDEX);
            }

        } catch (ConnectionPoolException e) {

            throw new DAOException("Couldn't take connection from connection pool", e);

        } catch (SQLException e) {

            throw new DAOException("Couldn't execute query to data source", e);

        } finally {

            ResourceDestroyer.closeAll(connection, preparedStatement, resultSet);
        }

        return choicesCount;
    }

    @Override
    public void saveNewChoice(int questionId, int answerId, int gradeId) throws DAOException {
        Connection connection = null;

        PreparedStatement preparedStatement = null;

        try {
            connection = connectionPool.takeConnection();
            connection.setAutoCommit(AUTO_COMMIT_TRUE);


            preparedStatement = connection.prepareStatement(SaveNewChoice.STATEMENT);

            preparedStatement.setInt(SaveNewChoice.QUESTION_ID_INPUT_INDEX, questionId);
            preparedStatement.setInt(SaveNewChoice.ANSWER_ID_INPUT_INDEX, answerId);
            preparedStatement.setInt(SaveNewChoice.GRADE_ID_INPUT_INDEX, gradeId);

            preparedStatement.execute();


        } catch (ConnectionPoolException e) {

            throw new DAOException("Couldn't take connection from connection pool", e);

        } catch (SQLException e) {

            throw new DAOException("Couldn't execute query to data source", e);

        } finally {

            ResourceDestroyer.closeAll(connection, preparedStatement);
        }
    }
}
