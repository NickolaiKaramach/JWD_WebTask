package by.etc.karamach.dao.sql.impl;

import by.etc.karamach.bean.Grade;
import by.etc.karamach.dao.DAOException;
import by.etc.karamach.dao.GradeDAO;
import by.etc.karamach.dao.pool.ConnectionPool;
import by.etc.karamach.dao.pool.ConnectionPoolException;
import by.etc.karamach.dao.sql.query.CreateQuestion;
import by.etc.karamach.dao.sql.query.SaveNewGrade;
import by.etc.karamach.dao.sql.query.UpdateGradeOnFinish;
import by.etc.karamach.dao.sql.util.ResourceDestroyer;

import java.sql.*;

public class SQLGradeDAO implements GradeDAO {

    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();

    private static final boolean AUTO_COMMIT_FALSE = false;
    private static final boolean AUTO_COMMIT_TRUE = true;

    @Override
    public void finishGrade(int finishingGrade, Timestamp currentTimestamp, int gradeId) throws DAOException {
        Connection connection = null;

        PreparedStatement preparedStatement = null;

        try {
            connection = connectionPool.takeConnection();
            connection.setAutoCommit(AUTO_COMMIT_TRUE);


            preparedStatement = connection.prepareStatement(UpdateGradeOnFinish.STATEMENT);

            preparedStatement.setInt(UpdateGradeOnFinish.GRADE_ID_INPUT_INDEX, gradeId);
            preparedStatement.setInt(UpdateGradeOnFinish.GRADE_DEGREE_INPUT_INDEX, finishingGrade);
            preparedStatement.setTimestamp(UpdateGradeOnFinish.GRADE_FINISH_TIME_INPUT_INDEX, currentTimestamp);

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
    public void saveNewGrade(Grade grade) throws DAOException {
        Connection connection = null;

        PreparedStatement preparedStatement = null;

        try {
            connection = connectionPool.takeConnection();
            connection.setAutoCommit(AUTO_COMMIT_FALSE);


            preparedStatement = connection.prepareStatement(SaveNewGrade.STATEMENT);

            preparedStatement.setInt(SaveNewGrade.GRADE_USER_ID_INPUT_INDEX, grade.getUserId());
            preparedStatement.setInt(SaveNewGrade.GRADE_TEST_ID_INPUT_INDEX, grade.getTestId());
            preparedStatement.setTimestamp(SaveNewGrade.GRADE_FINISH_TIME_INPUT_INDEX, grade.getFinishTime());

            preparedStatement.execute();


            preparedStatement = connection.prepareStatement(SaveNewGrade.GET_LAST_ID_STATEMENT);

            ResultSet resultSet = preparedStatement.executeQuery();


            if (!resultSet.next()) {
                throw new DAOException("Something goes wrong, try again!");
            }

            int lastId = resultSet.getInt(CreateQuestion.LAST_ID_RESULT_INDEX);
            grade.setId(lastId);

            connection.commit();

        } catch (ConnectionPoolException e) {

            throw new DAOException("Couldn't take connection from connection pool", e);

        } catch (SQLException e) {

            throw new DAOException("Couldn't execute query to data source", e);

        } finally {
            try {

                ResourceDestroyer.closeAllWithRollBack(connection, preparedStatement);

            } catch (SQLException e) {

                //Todo: move to catch block!

                throw new RuntimeException(e);

            }
        }
    }
}
