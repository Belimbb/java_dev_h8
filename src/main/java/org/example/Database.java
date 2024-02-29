package org.example;

import org.example.serviceClasses.PropertiesReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static PropertiesReader pr = new PropertiesReader("src/main/resources/app.properties");
    private static String dbUrl = pr.getPostgresUrlConnection();
    private static String dbUser = pr.getPostgresUsername();
    private static String dbPass = pr.getPostgresPassword();

    private Database() {
    }
    public static String getUrlConnection(){
        return dbUrl;
    }

    public static String getDbUser() {
        return dbUser;
    }

    public static String getDbPass() {
        return dbPass;
    }

    public static Connection getConnection() {
        Connection connection;
        try {
            connection = DriverManager.getConnection(dbUrl, dbUser, dbPass);
        } catch (SQLException e) {
            throw new RuntimeException("some problems with connection to db");
        }
        return connection;
    }
}
