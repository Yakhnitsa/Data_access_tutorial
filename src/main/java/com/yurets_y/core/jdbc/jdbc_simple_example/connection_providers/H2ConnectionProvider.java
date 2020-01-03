package com.yurets_y.core.jdbc.jdbc_simple_example.connection_providers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2ConnectionProvider implements ConnectionProvider {
    private final String DEF_CONNECTION_REF = "jdbc:h2:mem:test";
    private final String CONNECTION_DRIVER = "org.h2.Driver";

    public Connection getConnection() {
        return getConnection(DEF_CONNECTION_REF, "", "");
    }

    public Connection getConnection(String connectionRef, String user, String pass) {
        Connection connection = null;
        try {
            Class.forName(CONNECTION_DRIVER);
            connection = DriverManager.getConnection(connectionRef, user, pass);
        } catch (ClassNotFoundException e) {
            System.out.println("Connection driver class wasn't found");
            e.printStackTrace();

        } catch (SQLException e) {
            System.out.println("Error while getting a connection");
            e.printStackTrace();
        }

        return connection;
    }
}
