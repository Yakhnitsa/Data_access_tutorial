package com.yurets_y.core.jdbc.jdbc_simple_example.connectors;

import java.sql.*;

public class JDBCConnectorH2 implements JDBCConnector {
    private Connection connection;

    @Override
    public ResultSet executeQuery(String query) throws SQLException {

        Statement statement = getStatement();
        return statement.executeQuery(query);

    }

    @Override
    public Boolean execute(String query) throws SQLException {
        Statement statement = getStatement();
        return statement.execute(query);
    }

    @Override
    public void close() {
        try {
            if (connection != null) {
                connection.close();
            }

        } catch (SQLException e) {
            System.out.println("Can't close connection");
            e.printStackTrace();
        }
    }

    private Statement getStatement() throws SQLException {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        connection = DriverManager.getConnection("jdbc:h2:mem:test");

        return connection.createStatement();
    }
}
