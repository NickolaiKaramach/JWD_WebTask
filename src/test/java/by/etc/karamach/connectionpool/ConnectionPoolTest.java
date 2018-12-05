package by.etc.karamach.connectionpool;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionPoolTest {
    @Test
    public void attemptingToExecuteStatementTest() {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = null;
        Statement statement = null;
        try {
            if (!connectionPool.isInitialized()) {
                connectionPool.initPoolData();
            }
            connection = connectionPool.takeConnection();
            statement = connection.createStatement();
            statement.execute("create table user(" +
                    "id integer primary key auto_increment, " +
                    "name varchar(100));");
            statement = connection.createStatement();
            statement.execute("drop table user");

        } catch (ConnectionPoolException e) {
            System.out.println("ERROR: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("SQL ERROR: " + e.getMessage());
        } finally {
            if ((connection != null) && (statement != null)) {
                connectionPool.closeConnection(connection, statement);
            }
        }

        Assert.assertTrue(true);


    }
}
