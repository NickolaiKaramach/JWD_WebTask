package by.etc.karamach.dao.sql.impl;

import by.etc.karamach.bean.User;
import by.etc.karamach.dao.DAOException;
import by.etc.karamach.dao.UserDAO;
import by.etc.karamach.dao.pool.ConnectionPool;
import by.etc.karamach.dao.pool.ConnectionPoolException;
import by.etc.karamach.dao.sql.query.FindUserByEmail;
import by.etc.karamach.dao.sql.query.FindUserByLoginAndPassword;
import by.etc.karamach.dao.sql.query.SaveUser;
import by.etc.karamach.dao.sql.util.ResourceDestroyer;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLUserDAO implements UserDAO {


    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();

    private static final Logger logger = LogManager.getLogger();

    @Override
    public User findUserByEmail(String email) throws DAOException {
        Connection connection = null;

        PreparedStatement preparedStatement = null;

        User user = null;
        ResultSet resultSet = null;

        try {
            connection = connectionPool.takeConnection();
            preparedStatement = connection.prepareStatement(FindUserByEmail.STATEMENT);

            preparedStatement.setString(FindUserByEmail.LOGIN_INPUT_INDEX, email);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                user = new User();

                fillUserWithResultSet(user, resultSet);
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

        return user;
    }

    @Override
    public User signIn(String email, String password) throws DAOException {
        Connection connection = null;

        PreparedStatement preparedStatement = null;

        User user = null;
        ResultSet resultSet = null;

        try {

            connection = connectionPool.takeConnection();
            preparedStatement = connection.prepareStatement(FindUserByLoginAndPassword.STATEMENT);

            preparedStatement.setString(FindUserByLoginAndPassword.LOGIN_INPUT_INDEX, email);
            preparedStatement.setString(FindUserByLoginAndPassword.PASSWORD_INPUT_INDEX, password);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                user = new User();

                fillUserWithResultSet(user, resultSet);
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

        return user;
    }

    @Override
    public void register(User user) throws DAOException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = connectionPool.takeConnection();
            preparedStatement = connection.prepareStatement(SaveUser.STATEMENT);

            int id = user.getId();
            int accessLevel = user.getAccessLevel();

            String email = user.getEmail();
            String password = user.getPassword();
            String name = user.getName();

            preparedStatement.setInt(SaveUser.ID_INPUT_INDEX, id);
            preparedStatement.setInt(SaveUser.ACCESS_LEVEL_INPUT_INDEX, accessLevel);

            preparedStatement.setString(SaveUser.EMAIL_INPUT_INDEX, email);
            preparedStatement.setString(SaveUser.PASSWORD_INPUT_INDEX, password);
            preparedStatement.setString(SaveUser.NAME_INPUT_INDEX, name);

            preparedStatement.executeUpdate();

        } catch (ConnectionPoolException e) {

            throw new DAOException("Couldn't take connection from connection pool", e);

        } catch (SQLException e) {

            throw new DAOException("Couldn't execute query to data source", e);

        } finally {

            ResourceDestroyer.closeAll(connection, preparedStatement);
        }
    }

    private void fillUserWithResultSet(User user, ResultSet resultSet) throws SQLException {

        //TODO: Use different INDEXES, from different classes
        int idIndex = FindUserByLoginAndPassword.ID_RESULT_INDEX;
        int accessLevelIndex = FindUserByLoginAndPassword.ACCESS_LEVEL_RESULT_INDEX;
        int emailIndex = FindUserByLoginAndPassword.EMAIL_RESULT_INDEX;
        int passwordIndex = FindUserByLoginAndPassword.PASSWORD_RESULT_INDEX;
        int nameIndex = FindUserByLoginAndPassword.NAME_RESULT_INDEX;

        int id = resultSet.getInt(idIndex);
        int accessLevel = resultSet.getInt(accessLevelIndex);
        String email = resultSet.getString(emailIndex);
        String password = resultSet.getString(passwordIndex);
        String name = resultSet.getString(nameIndex);

        user.setId(id);
        user.setAccessLevel(accessLevel);
        user.setEmail(email);
        user.setPassword(password);
        user.setName(name);
    }
}

