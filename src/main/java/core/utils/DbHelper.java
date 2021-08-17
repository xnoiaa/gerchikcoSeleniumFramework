package core.utils;

import core.fe.utils.UrlBuilder;

import java.sql.*;

public class DbHelper {

    private static Connection connection;

    private static final String USERNAME = UrlBuilder.getPropertyValue("database.username");
    private static final String PASSWORD = UrlBuilder.getPropertyValue("database.password");
    private static final String CONNECTION_STRING = UrlBuilder.getPropertyValue("database.connection.string");

    private DbHelper() {
    }

    private static void connectToDb() throws SQLException {
        connection = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD);
    }
}
