package com.example.thmoduls3.model;

public class Product {
    private  int id_product;
    private String name_product;
    private double price;
    private int amount;
    private String color;
    private String describe_product;
    private Category category;

    public Product() {
    }

    public Product(String name_product, double price, int amount, String color, String describe_product, Category category) {
        this.name_product = name_product;
        this.price = price;
        this.amount = amount;
        this.color = color;
        this.describe_product = describe_product;
        this.category = category;
    }

    public Product(int id_product, String name_product, double price, int amount, String color, String describe_product, Category category) {
        this.id_product = id_product;
        this.name_product = name_product;
        this.price = price;
        this.amount = amount;
        this.color = color;
        this.describe_product = describe_product;
        this.category = category;
    }

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public String getName_product() {
        return name_product;
    }

    public void setName_product(String name_product) {
        this.name_product = name_product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescribe_product() {
        return describe_product;
    }

    public void setDescribe_product(String describe_product) {
        this.describe_product = describe_product;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id_product=" + id_product +
                ", name_product='" + name_product + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                ", color='" + color + '\'' +
                ", describe_product='" + describe_product + '\'' +
                ", category=" + category +
                '}';
    }
}
