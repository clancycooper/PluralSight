package com.pluralsight;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.*;

public class DAOProcedures {
    private static BasicDataSource dataSource;

    public DAOProcedures(DataSource dataSource) {
        this.dataSource = (BasicDataSource) dataSource;
    }

    public static void getOrderHistory(String customerID) {

        String query = "{CALL CustOrderHist(?)}";

        try (Connection conn = dataSource.getConnection();
             CallableStatement callStatement = conn.prepareCall(query)) {
            callStatement.setString(1, customerID);
            ResultSet resultSet = callStatement.executeQuery();

            while(resultSet.next()) {
                System.out.println("Product Name: " + resultSet.getString("ProductName"));
                System.out.println("Total:        " + resultSet.getInt("Total"));
                System.out.println("--------");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void getSalesByYear(String startDate, String endDate) {

        String query = "{CALL `Sales By Year`(?,?)}";

        try (Connection conn = dataSource.getConnection();
             CallableStatement callStatement = conn.prepareCall(query)) {
            callStatement.setString(1, startDate);
            callStatement.setString(2, endDate);
            ResultSet resultSet = callStatement.executeQuery();

            while(resultSet.next()) {
                System.out.println("Shipped Date:    " + resultSet.getString("ShippedDate"));
                System.out.println("Order ID:        " + resultSet.getInt("OrderID"));
                System.out.println("Subtotal:        " + resultSet.getDouble("Subtotal"));
                System.out.println("Year:            " + resultSet.getString("Year"));
                System.out.println("--------");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void getSalesByCategory(String category, String year) {

        String query = "{CALL SalesByCategory(?,?)}";

        try (Connection conn = dataSource.getConnection();
             CallableStatement callStatement = conn.prepareCall(query)) {
            callStatement.setString(1, category);
            callStatement.setString(2, year);
            ResultSet resultSet = callStatement.executeQuery();

            while(resultSet.next()) {
                System.out.println("Product Name:    " + resultSet.getString("ProductName"));
                System.out.println("Total Purchase:  " + resultSet.getInt("TotalPurchase"));
                System.out.println("--------");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}