package com.yurets_y.core.jdbc.jdbc_simple_example.connection_providers;

import java.sql.Connection;

public interface ConnectionProvider {
    Connection getConnection();

    Connection getConnection(String connectionRef, String user, String pass);
}
