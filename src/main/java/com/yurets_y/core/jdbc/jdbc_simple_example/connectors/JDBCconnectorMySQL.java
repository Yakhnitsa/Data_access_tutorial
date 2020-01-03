package com.yurets_y.core.jdbc.jdbc_simple_example.connectors;

import java.sql.*;

public class JDBCconnectorMySQL implements JDBCConnector {
    private final String SLQ_JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/db_example";
    private final String USER_NAME = "springuser";
    private final String USER_PASSWORD = "ThePassword";

    private Connection connection;

    public JDBCconnectorMySQL() {
    }

    public ResultSet executeQuery(String query) {
        try {
            Class.forName(SLQ_JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(CONNECTION_STRING, USER_NAME, USER_PASSWORD);

            Statement connectionStatement = connection.createStatement();
            resultSet = connectionStatement.executeQuery(query);

        } catch (SQLException e) {
            System.out.println("Can't get connection. Incorrect URL");
            e.printStackTrace();
        }
        return resultSet;
    }

    public Boolean execute(String query) {
        try {
            Class.forName(SLQ_JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        Boolean result = null;
        try {
            connection = DriverManager.getConnection(CONNECTION_STRING, USER_NAME, USER_PASSWORD);
            Statement connectionStatement = connection.createStatement();
            result = connectionStatement.execute(query);

        } catch (SQLException e) {
            System.out.println("Can't get connection. Incorrect URL");
            e.printStackTrace();
        }

        return result;
    }

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
}
