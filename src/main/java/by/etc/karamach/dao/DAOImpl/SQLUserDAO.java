package by.etc.karamach.dao.DAOImpl;

import by.etc.karamach.bean.User;
import by.etc.karamach.connectionpool.ConnectionPool;
import by.etc.karamach.connectionpool.ConnectionPoolException;
import by.etc.karamach.dao.DAOException;
import by.etc.karamach.dao.UserDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLUserDAO implements UserDao {

    private static final int LOGIN_PARAMETER_INDEX = 1;
    private static final int PASSWORD_PARAMETER_INDEX = 2;

    @Override
    public User findUserByEmail(String email) throws DAOException {

        ConnectionPool connectionPool = ConnectionPool.getInstance();

        Connection connection = null;

        PreparedStatement preparedStatement = null;

        User user = null;
        ResultSet resultSet;

        try {
            //TODO:QUESTION: Where could we initPool?

            if (!connectionPool.isInitialized()) {
                connectionPool.initPoolData();
            }

            connection = connectionPool.takeConnection();
            preparedStatement = connection.prepareStatement(SQLQuery.FIND_USER_BY_LOGIN);

            preparedStatement.setString(LOGIN_PARAMETER_INDEX, email);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                user = new User();

                fillUserWithResultSet(user, resultSet);
            }

        } catch (ConnectionPoolException e) {
            //TODO: LOG !
            throw new DAOException("Couldn't take connection from connection pool", e);
        } catch (SQLException e) {
            throw new DAOException("Couldn't execute query to data source", e);
        } finally {

            if ((connection != null) && (preparedStatement != null)) {
                connectionPool.closeConnection(connection, preparedStatement);
            }
        }

        return user;
    }

    private void fillUserWithResultSet(User user, ResultSet resultSet) throws SQLException {
        user.setId(resultSet.getInt(SQLUserTableColumn.ID));
        user.setAccessLevel(resultSet.getInt(SQLUserTableColumn.ACCESS_LEVEL));
        user.setEmail(resultSet.getString(SQLUserTableColumn.EMAIL));
        user.setPassword(resultSet.getString(SQLUserTableColumn.PASSWORD));
    }

    @Override
    public User signIn(String email, String password) throws DAOException {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = null;

        PreparedStatement preparedStatement = null;

        User user = null;
        ResultSet resultSet;

        try {

            if (!connectionPool.isInitialized()) {
                connectionPool.initPoolData();
            }

            connection = connectionPool.takeConnection();
            preparedStatement = connection.prepareStatement(SQLQuery.FIND_USER_BY_LOGIN_AND_PASSWORD);

            preparedStatement.setString(LOGIN_PARAMETER_INDEX, email);
            preparedStatement.setString(PASSWORD_PARAMETER_INDEX, password);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                user = new User();

                fillUserWithResultSet(user, resultSet);
            }

        } catch (ConnectionPoolException e) {
            //TODO: LOG !
            throw new DAOException("Couldn't take connection from connection pool", e);
        } catch (SQLException e) {
            throw new DAOException("Couldn't execute query to data source", e);
        } finally {

            if ((connection != null) && (preparedStatement != null)) {
                connectionPool.closeConnection(connection, preparedStatement);
            }
        }

        return user;
    }

    @Override
    public void register(User user) throws DAOException {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            if (!connectionPool.isInitialized()) {
                connectionPool.initPoolData();
            }

            connection = connectionPool.takeConnection();
            preparedStatement = connection.prepareStatement(SQLQuery.SAVE_USER_AS_REGISTERED);

            int id = user.getId();
            int accessLevel = user.getAccessLevel();

            String email = user.getEmail();
            String password = user.getPassword();
            String name = user.getName();

            preparedStatement.setInt(SQLUserTableColumn.ID, id);
            preparedStatement.setInt(SQLUserTableColumn.ACCESS_LEVEL, accessLevel);

            preparedStatement.setString(SQLUserTableColumn.EMAIL, email);
            preparedStatement.setString(SQLUserTableColumn.PASSWORD, password);
            preparedStatement.setString(SQLUserTableColumn.NAME, name);

            preparedStatement.executeUpdate();
        } catch (ConnectionPoolException e) {
            throw new DAOException("Couldn't take connection from connection pool", e);
        } catch (SQLException e) {
            throw new DAOException("Couldn't execute query to data source", e);
        } finally {
            //TODO: QUESTION: Chanege close condition?
            if ((connection != null) && (preparedStatement != null)) {
                connectionPool.closeConnection(connection, preparedStatement);
            }


        }
    }
}
