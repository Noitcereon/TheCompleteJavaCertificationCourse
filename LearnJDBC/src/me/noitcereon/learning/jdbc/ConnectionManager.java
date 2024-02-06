package me.noitcereon.learning.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private ConnectionManager(){}

    /**
     * Retrieves a connection to the local database using hardcoded values (This is bad security)
     * @return A {@link Connection} to my local instance of MySQL.
     */
    @SuppressWarnings("java:S6437")
    public static Connection getConnection(){
        String databaseConnectionString = "jdbc:mysql://127.0.0.1:3306/employees_database";
        String username = "root";
        String password = "admin";
        try {
            return DriverManager.getConnection(databaseConnectionString, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalStateException("Couldn't get connection to database.");
    }
}
