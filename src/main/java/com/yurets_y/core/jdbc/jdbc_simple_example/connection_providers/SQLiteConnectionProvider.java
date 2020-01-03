package com.yurets_y.core.jdbc.jdbc_simple_example.connection_providers;

import org.sqlite.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteConnectionProvider implements ConnectionProvider {
    private final String DEF_CONNECTION_REF = "jdbc:sqlite:D:/myfin.db";
    private final String CONNECTION_DRIVER = "org.h2.Driver";

    @Override
    public Connection getConnection() {
        return getConnection(DEF_CONNECTION_REF, "", "");
    }

    @Override
    public Connection getConnection(String connectionRef, String user, String pass) {
        Connection connection = null;
        try {
            DriverManager.registerDriver(new JDBC());
            connection = DriverManager.getConnection(connectionRef);

        } catch (SQLException e) {
            System.out.println("Error while getting a connection");
            e.printStackTrace();
        }

        return connection;
    }
}
