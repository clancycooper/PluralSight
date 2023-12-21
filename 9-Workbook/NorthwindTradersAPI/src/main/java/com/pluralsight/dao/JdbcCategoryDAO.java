package com.pluralsight.dao;

import com.pluralsight.models.Category;
import com.pluralsight.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcCategoryDAO implements CategoryDAO {
    private DataSource dataSource;

    @Autowired
    public JdbcCategoryDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Category> getAll() {
        List<Category> allCategories = new ArrayList<>();
        String query = "SELECT * FROM Categories;";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement prepStatement = connection.prepareStatement(query);
             ResultSet resultSet = prepStatement.executeQuery()) {
            while (resultSet.next()) {
                int categoryID = resultSet.getInt("CategoryID");
                String categoryName = resultSet.getString("CategoryName");
                Category category = new Category(categoryID, categoryName);
                allCategories.add(category);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return allCategories;
    }


    @Override
    public Category getById(int id) {
        String query = "SELECT * FROM Categories WHERE CategoryID = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement prepStatement = connection.prepareStatement(query)) {
            prepStatement.setInt(1, id);

            try (ResultSet resultSet = prepStatement.executeQuery()) {
                if (resultSet.next()) {
                    int categoryID = resultSet.getInt("CategoryID");
                    String categoryName = resultSet.getString("CategoryName");

                    return new Category(categoryID, categoryName);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Category insert(Category category) {
        String query = "INSERT INTO Categories (CategoryName) VALUES (?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement prepStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            prepStatement.setString(1, category.getCategoryName());
            int rows = prepStatement.executeUpdate();

            if (rows == 0) {
                throw new SQLException("Insertion failed, no rows affected.");
            }

            try (ResultSet generatedKeys = prepStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int generatedID = generatedKeys.getInt(1);
                    category.setCategoryID(generatedID);
                    return category;
                } else {
                    throw new SQLException("Insertion failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error occurred while inserting category.", e);
        }
    }

    @Override
    public void update(int id, Category category) {
        String query = "UPDATE Categories SET CategoryName = ? WHERE CategoryID = ?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement prepStatement = conn.prepareStatement(query)) {

            prepStatement.setString(1, category.getCategoryName());
            prepStatement.setInt(2, id);

            int rows = prepStatement.executeUpdate();

            if (rows > 0) {
                System.out.println("Category with ID: " + id + " updated successfully.");
            } else {
                System.out.println("No category found with ID: " + id);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error occurred while updating category", e);
        }
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM Categories WHERE CategoryID = ?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement prepStatement = conn.prepareStatement(query)) {
            prepStatement.setInt(1, id);

            int rows = prepStatement.executeUpdate();

            if (rows > 0) {
                System.out.println("Category with ID: " + id + " deleted successfully.");
            } else {
                System.out.println("No category found with ID: " + id);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error occurred while deleting category", e);
        }
    }
}
