package com.pluralsight.dao;

import com.pluralsight.models.SalesContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcSalesContractDAO implements SalesDAO {
    private DataSource dataSource;

    @Autowired
    public JdbcSalesContractDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<SalesContract> getAllSales() {
        List<SalesContract> allSales = new ArrayList<>();
        String query = "SELECT * FROM sales_contracts;";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement prepStatement = conn.prepareStatement(query);
             ResultSet result = prepStatement.executeQuery()) {

            while (result.next()) {
                int saleID = result.getInt("sale_id");
                int VIN = result.getInt("VIN");
                int dealershipID = result.getInt("dealership_id");
                String firstName = result.getString("first_name");
                String lastName = result.getString("last_name");
                String address = result.getString("address");
                String saleDate = result.getString("sale_date");
                SalesContract salesContract = new SalesContract(saleID, VIN, dealershipID, firstName, lastName, address, saleDate);
                allSales.add(salesContract);
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return allSales;
    }

    @Override
    public List<SalesContract> getById(int saleID) {
        List<SalesContract> salesByID = new ArrayList<>();
        String query = "SELECT * FROM sales_contracts WHERE sale_id = ?;";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement prepStatement = connection.prepareStatement(query)) {
            prepStatement.setInt(1, saleID);

            try (ResultSet result = prepStatement.executeQuery()) {
                while (result.next()) {
                    int VIN = result.getInt("VIN");
                    int dealershipID = result.getInt("dealership_id");
                    String firstName = result.getString("first_name");
                    String lastName = result.getString("last_name");
                    String address = result.getString("address");
                    String saleDate = result.getString("sale_date");
                    SalesContract salesContract = new SalesContract(saleID, VIN, dealershipID, firstName, lastName, address, saleDate);
                    salesByID.add(salesContract);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return salesByID;
    }

    @Override
    public SalesContract insertSale(SalesContract sale) {
        String query = "INSERT INTO sales_contracts (first_name, last_name, address, sale_date) VALUES (?, ?, ?, ?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement prepStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            prepStatement.setString(1, sale.getFirstName());
            prepStatement.setString(2, sale.getLastName());
            prepStatement.setString(3, sale.getAddress());
            prepStatement.setString(4, sale.getSaleDate());

            int rows = prepStatement.executeUpdate();
            if (rows == 0) {
                throw new SQLException("Insertion failed, no rows affected.");
            } else {
                System.out.println("New Sale has been successfully added!");
            }

            return sale;

        } catch (SQLException e) {
                throw new RuntimeException("Error occurred while inserting sale", e);
            }
    }

}
