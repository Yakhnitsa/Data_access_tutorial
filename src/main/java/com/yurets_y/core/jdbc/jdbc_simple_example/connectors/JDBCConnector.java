package com.yurets_y.core.jdbc.jdbc_simple_example.connectors;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface JDBCConnector {

    ResultSet executeQuery(String query) throws SQLException;

    Boolean execute(String query) throws SQLException;

    void close();


}
