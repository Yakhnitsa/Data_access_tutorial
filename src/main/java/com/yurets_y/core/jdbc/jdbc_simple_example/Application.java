package com.yurets_y.core.jdbc.jdbc_simple_example;

import com.yurets_y.core.jdbc.jdbc_simple_example.connectors.JDBCConnector;
import com.yurets_y.core.jdbc.jdbc_simple_example.connectors.JDBCconnectorMySQL;
import com.yurets_y.core.jdbc.jdbc_simple_example.connection_providers.ConnectionProvider;
import com.yurets_y.core.jdbc.jdbc_simple_example.connection_providers.SQLiteConnectionProvider;
import com.yurets_y.core.jdbc.jdbc_simple_example.dao.ProductDao;
import com.yurets_y.core.jdbc.jdbc_simple_example.entity.Product;

import java.sql.*;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {
        testSQLite();
    }

    public static void testMySQL() throws SQLException {
        JDBCConnector connector = new JDBCconnectorMySQL();
//        String SQLQuery = "CREATE TABLE test_table(" +
//                "id integer primary key auto_increment, " +
//                "name varchar(100));";
//
//
//        boolean result = connector.execute(SQLQuery);
//        System.out.println(result);
//        String insertQuery = "insert into test_table(name) values('borya'),('petya')";

//        connector.execute(insertQuery);
        String selectQuery = "select * from railroad_station";
        ResultSet resultSet = connector.executeQuery(selectQuery);


        while (resultSet.next()) {
            String row = String.format("%d | %s | %s",
                    resultSet.getInt("code"),
                    resultSet.getString("rus_name"),
                    resultSet.getString("ukr_name"));

            System.out.println(row);
        }
//        new Application().testH2();
        connector.close();
    }

    public void testH2() throws SQLException, ClassNotFoundException {
        Class.forName("org.h2.Driver");
        Connection connection = DriverManager.getConnection("jdbc:h2:mem:test");

        Statement statement = connection.createStatement();
//        statement.execute("create table user(" +
//                "id integer primary key auto_increment, " +
//                "name varchar(100));");
//
//        statement.execute("insert into user(name) values('borya'),('petya')");
//
//        PreparedStatement preparedStatement = connection
//                .prepareStatement("insert into user(id,name) values(?,?)");
//        preparedStatement.setInt(1, 4);
//        preparedStatement.setString(2, "misha");
//        preparedStatement.addBatch();
//        preparedStatement.setInt(1, 5);
//        preparedStatement.setString(2, "grisha");
//        preparedStatement.addBatch();
//        preparedStatement.executeBatch();


        ResultSet rs = statement.executeQuery("select * from user");

        while (rs.next()) {
            System.out.println(rs.getInt("id") + " : " + rs.getString("name"));
        }
//        ResultSet rs = statement.executeQuery("show databases");
//        while (rs.next()) {
//            System.out.println(rs.getString("SCHEMA_NAME"));
//        }
    }

    public static void testSQLite() {

        ConnectionProvider connectionProvider = new SQLiteConnectionProvider();
        ProductDao dao = ProductDao.getInstance();
        String connectionURL = "jdbc:sqlite:D:/myfin.db";
        Connection SQLConnection = connectionProvider.getConnection(connectionURL, "user", "pass");

        dao.setConnection(SQLConnection);


//        Product product = dao.getProduct(2);
//        product.setGood("Бородинский хлеб");
//        product.setPrice(23);
//        dao.updateProduct(product,product.getId());
//        dao.addProduct(product);
//        System.out.println(product);
        dao.testMethod();
        List<Product> products = dao.getAllProducts();
        for (Product prod : products) {
            System.out.println(prod.toString());
        }

    }
}
