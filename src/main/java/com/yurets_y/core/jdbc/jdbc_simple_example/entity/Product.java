package com.yurets_y.core.jdbc.jdbc_simple_example.entity;

public class Product {
    // Поля класса
    public int id;

    public String good;

    public double price;

    public String category_name;

    public Product(String good, double price, String category_name) {
        this.good = good;
        this.price = price;
        this.category_name = category_name;
    }

    // Конструктор
    public Product(int id, String good, double price, String category_name) {
        this.id = id;
        this.good = good;
        this.price = price;
        this.category_name = category_name;
    }

    // Выводим информацию по продукту
    @Override
    public String toString() {
        return String.format("ID: %s | Товар: %s | Цена: %s | Категория: %s",
                this.id, this.good, this.price, this.category_name);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGood() {
        return good;
    }

    public void setGood(String good) {
        this.good = good;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }
}
