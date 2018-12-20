package by.etc.karamach.dao.impl;

import by.etc.karamach.bean.Test;
import by.etc.karamach.dao.DAOException;
import by.etc.karamach.dao.TestDAO;
import by.etc.karamach.dao.pool.ConnectionPool;
import by.etc.karamach.dao.pool.ConnectionPoolException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLTestDAO implements TestDAO {
    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private static final int OWNER_ID_PARAMETER_INDEX = 1;


    @Override
    public List<Test> getAllTests() throws DAOException {

        List<Test> tests;

        Connection connection = null;

        PreparedStatement preparedStatement = null;

        ResultSet resultSet = null;

        try {
            connection = connectionPool.takeConnection();
            preparedStatement = connection.prepareStatement(SQLQuery.FIND_ALL_TESTS);

            resultSet = preparedStatement.executeQuery();

            tests = new ArrayList<>();
            while (resultSet.next()) {
                Test test = new Test();

                fillTestDataFromResultSet(resultSet, test);

                tests.add(test);
            }

        } catch (ConnectionPoolException e) {
            //TODO: LOG !
            throw new DAOException("Couldn't take connection from connection pool", e);
        } catch (SQLException e) {
            throw new DAOException("Couldn't execute query to data source", e);
        } finally {

            closeAll(connection, preparedStatement, resultSet);
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
            preparedStatement = connection.prepareStatement(SQLQuery.FIND_TESTS_BY_OWNER_ID);

            preparedStatement.setInt(OWNER_ID_PARAMETER_INDEX, userId);

            resultSet = preparedStatement.executeQuery();

            tests = new ArrayList<>();
            while (resultSet.next()) {
                Test test = new Test();

                fillTestDataFromResultSet(resultSet, test);

                tests.add(test);
            }

        } catch (ConnectionPoolException e) {
            //TODO: LOG !
            throw new DAOException("Couldn't take connection from connection pool", e);
        } catch (SQLException e) {
            throw new DAOException("Couldn't execute query to data source", e);
        } finally {

            closeAll(connection, preparedStatement, resultSet);
        }


        return tests;
    }


    private void fillTestDataFromResultSet(ResultSet resultSet, Test test) throws SQLException {
        int id = resultSet.getInt(SQLTestTableColumn.ID);
        String name = resultSet.getString(SQLTestTableColumn.NAME);
        int owner_id = resultSet.getInt(SQLTestTableColumn.OWNER_ID);

        test.setId(id);
        test.setName(name);
        test.setOwnerId(owner_id);

    }

    //TODO:Extract to method object
    private void closeAll(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        if ((connection != null) && ((preparedStatement != null) && (resultSet != null))) {
            connectionPool.closeConnection(connection, preparedStatement, resultSet);
        } else {

            if ((connection != null) && (preparedStatement != null)) {
                connectionPool.closeConnection(connection, preparedStatement);
            } else {
                connectionPool.closeConnection(connection);
            }
        }
    }
}

