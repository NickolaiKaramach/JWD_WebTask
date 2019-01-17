package by.etc.karamach.dao.sql.impl;

import by.etc.karamach.bean.Grade;
import by.etc.karamach.bean.Test;
import by.etc.karamach.dao.DAOException;
import by.etc.karamach.dao.GradeDAO;
import by.etc.karamach.dao.pool.ConnectionPool;
import by.etc.karamach.dao.pool.ConnectionPoolException;
import by.etc.karamach.dao.sql.query.*;
import by.etc.karamach.dao.sql.util.ResourceDestroyer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLGradeDAO implements GradeDAO {

    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();

    private static final boolean AUTO_COMMIT_FALSE = false;
    private static final boolean AUTO_COMMIT_TRUE = true;

    @Override
    public void deleteUnusedGrades() throws DAOException {
        Connection connection = null;

        PreparedStatement preparedStatement = null;

        try {
            connection = connectionPool.takeConnection();
            connection.setAutoCommit(AUTO_COMMIT_TRUE);


            preparedStatement = connection.prepareStatement(DeleteUnusedGrades.STATEMENT);

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
    public List<Grade> takeUserGrades(Integer userId) throws DAOException {

        List<Grade> grades;

        Connection connection = null;

        PreparedStatement preparedStatement = null;

        ResultSet resultSet = null;

        try {
            connection = connectionPool.takeConnection();
            connection.setAutoCommit(AUTO_COMMIT_TRUE);


            preparedStatement = connection.prepareStatement(TakeGradesByUserId.STATEMENT);

            preparedStatement.setInt(TakeGradesByUserId.GRADE_USER_ID_INPUT_INDEX, userId);

            resultSet = preparedStatement.executeQuery();

            grades = new ArrayList<>();
            while (resultSet.next()) {
                Grade grade = new Grade();

                fillGradeFromResultSet(resultSet, grade);

                grades.add(grade);
            }

        } catch (ConnectionPoolException e) {

            throw new DAOException("Couldn't take connection from connection pool", e);

        } catch (SQLException e) {

            throw new DAOException("Couldn't execute query to data source", e);

        } finally {

            ResourceDestroyer.closeAll(connection, preparedStatement, resultSet);
        }


        return grades;
    }

    private void fillGradeFromResultSet(ResultSet resultSet, Grade grade) throws SQLException {
        int mark = resultSet.getInt(TakeGradesByUserId.GRADE_DEGREE_RESULT_INDEX);
        Timestamp finishTime = resultSet.getTimestamp(TakeGradesByUserId.GRADE_FINISH_TIME_RESULT_INDEX);
        String testName = resultSet.getString(TakeGradesByUserId.TEST_NAME_RESULT_INDEX);

        Test test = new Test();
        test.setName(testName);

        grade.setMark(mark);
        grade.setFinishTime(finishTime);
        grade.setTest(test);
    }

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
