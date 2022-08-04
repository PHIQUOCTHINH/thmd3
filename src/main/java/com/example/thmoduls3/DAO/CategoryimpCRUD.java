package com.example.thmoduls3.DAO;

import com.example.thmoduls3.model.Category;

import java.sql.*;
import java.util.ArrayList;

public class CategoryimpCRUD implements CRUD<Category> {

    Category category = new Category();
    private String jdbcURL = "jdbc:mysql://localhost:3306/thmoduls3?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";
    private static final String INSERT_CATEGORY_SQL = "INSERT INTO category (Category) VALUES (?);";
    private static final String SELECT_CATEGORY_BY_ID = "select id_category,category from category where id_category =?";
    private static final String SELECT_ALL_CATEGORY = "select * from category";
    private static final String DELETE_CATEGORY_SQL = "delete from category where id_category = ?;";
    private static final String UPDATE_CATEGORY_SQL = "update category set category= ? where id_category = ?;";

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
    public ArrayList<Category> findAll() {
        ArrayList<Category> categories = new ArrayList<>();
        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CATEGORY);) {
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            //

            while (rs.next()) {

                int id = rs.getInt("id_category");
                String category = rs.getString("category");
                categories.add(new Category( id, category));
            }
        } catch (SQLException e) {
            System.out.println();
        }
        return categories;
    }


    @Override
    public void insert(Category category) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CATEGORY_SQL)) {
            preparedStatement.setString(1, category.getCategory());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println();
        }
    }

    @Override
    public Category findById(int id) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CATEGORY_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String Category = rs.getString("category");

                category = new Category( id, Category);
            }
        } catch (SQLException e) {
            System.out.println();
        }
        return category;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_CATEGORY_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean update(Category category) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_CATEGORY_SQL);) {
            statement.setInt(1, category.getId_category());
            statement.setString(2, category.getCategory());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
}

