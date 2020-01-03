package com.yurets_y.core.jdbc.jdbc_simple_example.dao;

import com.yurets_y.core.jdbc.jdbc_simple_example.connectors.JDBCConnectorH2;
import com.yurets_y.core.jdbc.jdbc_simple_example.connection_providers.H2ConnectionProvider;
import com.yurets_y.core.jdbc.jdbc_simple_example.entity.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductDao {
    private static ProductDao instance = null;
    // Объект, в котором будет храниться соединение с БД
    private Connection connection = null;

    public static synchronized ProductDao getInstance() {
        if (instance == null)
            instance = new ProductDao();
        return instance;
    }

    private ProductDao() {
        this.connection = new H2ConnectionProvider().getConnection();
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public List<Product> getAllProducts() {

        try (Statement statement = this.connection.createStatement()) {
            List<Product> products = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery("SELECT id, good, price, category_name FROM products");

            while (resultSet.next()) {
                products.add(new Product(resultSet.getInt("id"),
                        resultSet.getString("good"),
                        resultSet.getDouble("price"),
                        resultSet.getString("category_name")));
            }

            return products;

        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public void addProduct(Product product) {
        try (PreparedStatement statement = this.connection.prepareStatement(
                "INSERT INTO Products('good', 'price', 'category_name') VALUES(?, ?, ?)")) {
            statement.setObject(1, product.good);
            statement.setObject(2, product.price);
            statement.setObject(3, product.category_name);
            // Выполняем запрос
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteProduct(int id) {
        try (PreparedStatement statement = this.connection.prepareStatement(
                "DELETE FROM Products WHERE id = ?")) {
            statement.setObject(1, id);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateProduct(Product product, int id) {
        try (PreparedStatement statement = this.connection.prepareStatement(
                "UPDATE Products" +
                        "SET good = ?, price = ?, category_name = ?" +
                        "WHERE id = ?"
        )) {
            statement.setObject(1, product.good);
            statement.setObject(2, product.price);
            statement.setObject(3, product.category_name);
            statement.setObject(4, id);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Product getProduct(int id) {
        Product product = null;
        try (PreparedStatement statement = this.connection.prepareStatement(
                "SELECT id, good, price, category_name FROM products WHERE id = ?"
        )) {
            statement.setObject(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                product = new Product(resultSet.getInt("id"),
                        resultSet.getString("good"),
                        resultSet.getDouble("price"),
                        resultSet.getString("category_name"));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;

    }

    public void testMethod() {
        try
                (PreparedStatement statement = connection.prepareStatement(
                        "UPDATE Products set good=? WHERE id=2"
                );) {
            statement.setObject(1, "Черный хлеб");
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


}
