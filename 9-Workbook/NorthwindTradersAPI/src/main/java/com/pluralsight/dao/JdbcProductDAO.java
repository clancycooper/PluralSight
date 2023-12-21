package com.pluralsight.dao;

import com.pluralsight.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcProductDAO implements ProductDAO {
    private DataSource dataSource;

    @Autowired
    public JdbcProductDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Product> getAll() {
        List<Product> allProducts = new ArrayList<>();
        String query = "SELECT * FROM Products;";
        try(Connection connection = dataSource.getConnection();
        PreparedStatement prepStatement = connection.prepareStatement(query);
        ResultSet resultSet = prepStatement.executeQuery()) {
        while(resultSet.next()) {
            int productID = resultSet.getInt("ProductID");
            int categoryID = resultSet.getInt("CategoryID");
            String productName = resultSet.getString("ProductName");
            double unitPrice = resultSet.getDouble("UnitPrice");
            Product product = new Product(productID, categoryID, productName, unitPrice);
            allProducts.add(product);
        }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return allProducts;
    }

    @Override
    public Product getById(int id) {
        String query = "SELECT * FROM Products WHERE ProductID = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement prepStatement = connection.prepareStatement(query)) {
            prepStatement.setInt(1, id);

            try (ResultSet resultSet = prepStatement.executeQuery()) {
                if (resultSet.next()) {
                    int productID = resultSet.getInt("ProductID");
                    int categoryID = resultSet.getInt("CategoryID");
                    String productName = resultSet.getString("ProductName");
                    double unitPrice = resultSet.getDouble("UnitPrice");

                    return new Product(productID, categoryID, productName, unitPrice);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Product insert(Product product) {
        String query = "INSERT INTO Products (CategoryID, ProductName, UnitPrice) VALUES (?, ?, ?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement prepStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            prepStatement.setInt(1, product.getCategoryID());
            prepStatement.setString(2, product.getProductName());
            prepStatement.setDouble(3, product.getUnitPrice());
            int rows = prepStatement.executeUpdate();

            if (rows == 0) {
                throw new SQLException("Insertion failed, no rows affected.");
            }

            try (ResultSet generatedKeys = prepStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int generatedID = generatedKeys.getInt(1);
                    product.setProductID(generatedID);
                    return product;
                } else {
                    throw new SQLException("Insertion failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error occurred while inserting product", e);
        }
    }

    @Override
    public void update(int id, Product product) {
        String query = "UPDATE Products SET CategoryID = ?, ProductName = ?, UnitPrice = ? WHERE ProductID = ?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement prepStatement = conn.prepareStatement(query)) {

            prepStatement.setInt(1, product.getCategoryID());
            prepStatement.setString(2, product.getProductName());
            prepStatement.setDouble(3, product.getUnitPrice());
            prepStatement.setInt(4, id);

            int rows = prepStatement.executeUpdate();

            if (rows > 0) {
                System.out.println("Product with ID: " + id + " updated successfully.");
            } else {
                System.out.println("No product found with ID: " + id);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error occurred while updating product", e);
        }
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM Products WHERE ProductID = ?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement prepStatement = conn.prepareStatement(query)) {
            prepStatement.setInt(1, id);

            int rows = prepStatement.executeUpdate();

            if (rows > 0) {
                System.out.println("Product with ID: " + id + " deleted successfully.");
            } else {
                System.out.println("No product found with ID: " + id);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error occurred while deleting product", e);
        }
    }
}
