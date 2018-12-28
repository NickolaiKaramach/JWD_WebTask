package by.etc.karamach.dao.sql.util;

import by.etc.karamach.dao.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public final class ResourceDestroyer {

    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();

    private ResourceDestroyer() {
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
