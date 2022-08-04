package com.example.thmoduls3.DAO;

import com.example.thmoduls3.model.Category;
import com.example.thmoduls3.model.Product;

import java.sql.*;
import java.util.ArrayList;

public class ProductimpCRUD implements CRUD<Product>{

    Product product = new Product();
    private String jdbcURL = "jdbc:mysql://localhost:3306/thmoduls3?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";
    private static final String INSERT_PRODUCT_SQL = "INSERT INTO product (name_product,price,amount,color,describe_product,category) VALUES (?,?,?,?,?,?);";
    private static final String SELECT_PRODUCT_BY_ID = "select * from product where id_product = ?";
    private static final String SELECT_ALL_PRODUCT = "select * from product";

    private static final String DELETE_PRODUCT_SQL = "delete from product where id_product = ?;";
    private static final String UPDATE_PRODUCT_SQL = "update product set name_product = ?, price = ?, amount = ?,color = ?, describe_product = ?,category = ? where id_product = ?;";
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            System.out.println();
        }
        return connection;
    }
    @Override
    public ArrayList<Product> findAll() {
        ArrayList<Product> products = new ArrayList<>();
        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT);) {
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            //

            while (rs.next()) {

                CategoryimpCRUD categoryimpCRUD = new CategoryimpCRUD();
                int id_product = Integer.parseInt(rs.getString("id_product"));
                String name_product = rs.getString("name_product");
                double price = rs.getDouble("price");
                int amount = rs.getInt("amount");
                String color = rs.getString("color");
                String describe_product = rs.getString("describe_product");
                int id_Category = rs.getInt("category");
                Category category = categoryimpCRUD.findById(id_Category);

                products.add(new Product( id_product, name_product,price,amount,color,describe_product,category));
            }
        } catch (SQLException e) {
            System.out.println();
        }
        return products;
    }

    @Override
    public void insert(Product product) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT_SQL)) {

            preparedStatement.setString(1, product.getName_product());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getAmount());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setString(5,product.getDescribe_product());
            preparedStatement.setInt(6, product.getCategory().getId_category());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
        }
    }

    @Override
    public Product findById(int id) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id_product = Integer.parseInt(rs.getString("id_product"));
                String name_product = rs.getString("name_product");
                double price = rs.getDouble("price");
                int amount = rs.getInt("amount");
                String color = rs.getString("color");
                String describe_product = rs.getString("describe_product");
                int id_Category = rs.getInt("category");
                CategoryimpCRUD categoryimpCRUD = new CategoryimpCRUD();
                Category category1 =categoryimpCRUD.findById(id_Category);

                product = new Product( id_product, name_product,price,amount,color,describe_product,category1);
            }
        } catch (SQLException e) {
            System.out.println();
        }
        return product;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_PRODUCT_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean update(Product product) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_PRODUCT_SQL);) {

            statement.setInt(1, product.getId_product());
            statement.setString(2, product.getName_product());
            statement.setDouble(3, product.getPrice());
            statement.setInt(4, product.getAmount());
            statement.setString(5, product.getColor());
            statement.setString(6, product.getDescribe_product());
            statement.setInt(7, product.getCategory().getId_category());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
}
