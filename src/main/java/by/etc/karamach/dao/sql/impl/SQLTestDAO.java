package by.etc.karamach.dao.sql.impl;

import by.etc.karamach.bean.Test;
import by.etc.karamach.bean.TestStatus;
import by.etc.karamach.dao.DAOException;
import by.etc.karamach.dao.TestDAO;
import by.etc.karamach.dao.pool.ConnectionPool;
import by.etc.karamach.dao.pool.ConnectionPoolException;
import by.etc.karamach.dao.sql.query.*;
import by.etc.karamach.dao.sql.util.ResourceDestroyer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLTestDAO implements TestDAO {
    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private static final boolean AUTO_COMMIT_TRUE = true;

    @Override
    public List<Test> getAllTests() throws DAOException {

        List<Test> tests;

        Connection connection = null;

        PreparedStatement preparedStatement = null;

        ResultSet resultSet = null;

        try {
            connection = connectionPool.takeConnection();
            connection.setAutoCommit(AUTO_COMMIT_TRUE);


            preparedStatement = connection.prepareStatement(FindAllTests.STATEMENT);

            resultSet = preparedStatement.executeQuery();

            tests = new ArrayList<>();
            while (resultSet.next()) {
                Test test = new Test();

                fillTestDataFromResultSet(resultSet, test);

                tests.add(test);
            }

        } catch (ConnectionPoolException e) {

            throw new DAOException("Couldn't take connection from connection pool", e);

        } catch (SQLException e) {

            throw new DAOException("Couldn't execute query to data source", e);

        } finally {

            ResourceDestroyer.closeAll(connection, preparedStatement, resultSet);
        }


        return tests;
    }

    @Override
    public List<Test> getMyTests(int userId) throws DAOException {
        List<Test> tests;

        Connection connection = null;

        PreparedStatement preparedStatement = null;

        ResultSet resultSet = null;

        try {
            connection = connectionPool.takeConnection();
            connection.setAutoCommit(AUTO_COMMIT_TRUE);


            preparedStatement = connection.prepareStatement(FindTestsByOwnerId.STATEMENT);

            preparedStatement.setInt(FindTestsByOwnerId.OWNER_ID_INPUT_INDEX, userId);

            resultSet = preparedStatement.executeQuery();

            tests = new ArrayList<>();
            while (resultSet.next()) {
                Test test = new Test();

                fillTestDataFromResultSet(resultSet, test);

                tests.add(test);
            }

        } catch (ConnectionPoolException e) {

            throw new DAOException("Couldn't take connection from connection pool", e);

        } catch (SQLException e) {

            throw new DAOException("Couldn't execute query to data source", e);

        } finally {

            ResourceDestroyer.closeAll(connection, preparedStatement, resultSet);
        }

        return tests;
    }

    @Override
    public void saveNewTest(Test test) throws DAOException {
        Connection connection = null;

        PreparedStatement preparedStatement = null;

        try {
            connection = connectionPool.takeConnection();
            connection.setAutoCommit(AUTO_COMMIT_TRUE);

            preparedStatement = connection.prepareStatement(SaveNewTest.STATEMENT);

            preparedStatement.setInt(SaveNewTest.OWNER_ID_INPUT_INDEX, test.getOwnerId());
            preparedStatement.setString(SaveNewTest.NAME_INPUT_INDEX, test.getName());

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
    public Test getTest(int testId) throws DAOException {
        Test test = null;

        Connection connection = null;


        PreparedStatement preparedStatement = null;

        ResultSet resultSet = null;

        try {
            connection = connectionPool.takeConnection();
            connection.setAutoCommit(AUTO_COMMIT_TRUE);


            preparedStatement = connection.prepareStatement(FindTestByTestId.STATEMENT);

            preparedStatement.setInt(FindTestByTestId.TEST_ID_INPUT_INDEX, testId);

            resultSet = preparedStatement.executeQuery();


            if (resultSet.next()) {
                test = new Test();

                fillTestDataFromResultSet(resultSet, test);
            }

        } catch (ConnectionPoolException e) {

            throw new DAOException("Couldn't take connection from connection pool", e);

        } catch (SQLException e) {

            throw new DAOException("Couldn't execute query to data source", e);

        } finally {

            ResourceDestroyer.closeAll(connection, preparedStatement, resultSet);
        }

        return test;
    }

    @Override
    public void changeTestStatus(int testId, TestStatus published) throws DAOException {
        Connection connection = null;

        PreparedStatement preparedStatement = null;

        try {

            connection = connectionPool.takeConnection();
            connection.setAutoCommit(AUTO_COMMIT_TRUE);

            preparedStatement = connection.prepareStatement(ChangeTestStatus.STATEMENT);

            preparedStatement.setInt(ChangeTestStatus.TEST_ID_INPUT_INDEX, testId);
            preparedStatement.setString(ChangeTestStatus.TEST_STAUS_INPUT_INDEX, published.toString());

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
    public void updateTestName(int testId, String newName) throws DAOException {
        Connection connection = null;

        PreparedStatement preparedStatement = null;

        try {
            connection = connectionPool.takeConnection();
            connection.setAutoCommit(AUTO_COMMIT_TRUE);

            preparedStatement = connection.prepareStatement(UpdateTestName.STATEMENT);

            preparedStatement.setInt(UpdateTestName.TEST_ID_INPUT_INDEX, testId);
            preparedStatement.setString(UpdateTestName.TEST_NAME_INPUT_INDEX, newName);

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
    public void deleteTest(int testId) throws DAOException {
        Connection connection = null;

        PreparedStatement preparedStatement = null;

        try {
            connection = connectionPool.takeConnection();
            connection.setAutoCommit(AUTO_COMMIT_TRUE);


            preparedStatement = connection.prepareStatement(DeleteTestByTestId.STATEMENT);

            preparedStatement.setInt(DeleteTestByTestId.TEST_ID_INPUT_INDEX, testId);

            preparedStatement.execute();


        } catch (ConnectionPoolException e) {

            throw new DAOException("Couldn't take connection from connection pool", e);

        } catch (SQLException e) {

            throw new DAOException("Couldn't execute query to data source", e);

        } finally {

            ResourceDestroyer.closeAll(connection, preparedStatement);
        }
    }


    private void fillTestDataFromResultSet(ResultSet resultSet, Test test) throws SQLException {
        int id = resultSet.getInt(FindAllTests.ID_RESULT_INDEX);
        String name = resultSet.getString(FindAllTests.NAME_RESULT_INDEX);
        int ownerId = resultSet.getInt(FindAllTests.OWNER_ID_RESULT_INDEX);

        test.setId(id);
        test.setName(name);
        test.setOwnerId(ownerId);

    }
}

