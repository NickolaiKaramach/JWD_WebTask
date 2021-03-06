package by.etc.karamach.dao.sql.util;

import by.etc.karamach.dao.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class ResourceDestroyer {

    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();

    private ResourceDestroyer() {
    }

    public static void closeAllWithRollBack(Connection connection, PreparedStatement preparedStatement) throws SQLException {
        if (connection != null) {
            connection.rollback();
        }

        closeAll(connection, preparedStatement);
    }

    public static void closeAll(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
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

    public static void closeAll(Connection connection, PreparedStatement preparedStatement) {
        if ((connection != null) && (preparedStatement != null)) {
            connectionPool.closeConnection(connection, preparedStatement);
        } else {
            connectionPool.closeConnection(connection);
        }
    }
}
