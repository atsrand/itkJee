package ex2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;

public class ConnectionManager {

    public static String DB_URL =
            "jdbc:hsqldb:file:${user.home}/i377/mkalmo/db;shutdown=true";

    static {
        try {
            Class.forName("org.hsqldb.jdbcDriver");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static Connection getNewConnection() {
        try {
            return DriverManager.getConnection(DB_URL, "sa", "");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static Connection connection;

    public static synchronized Connection getConnection() {
        DbUtils.closeQuietly(connection);
        connection = getNewConnection();

        return connection;
    }

    public static synchronized void closeConnection() {
        DbUtils.closeQuietly(connection);
    }

}
