package com.pluralsight.dealership.DAOs;

import org.apache.commons.dbcp2.BasicDataSource;
import com.pluralsight.dealership.Vehicle;
import java.util.List;
import java.sql.*;
import javax.sql.DataSource;
import java.util.ArrayList;

public class VehiclesDAO {
    private static BasicDataSource dataSource;
    private double minPrice, maxPrice;
    private int minMile, maxMile;

    public VehiclesDAO(BasicDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static void getAllVehicles() {
        String query = "SELECT * FROM vehicles;";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement prepStatement = conn.prepareStatement(query);
             ResultSet result = prepStatement.executeQuery()) {

            while (result.next()) {
                System.out.println("VIN:       " + result.getInt("VIN"));
                System.out.println("ID:        " + result.getInt("dealership_id"));
                System.out.println("Price:     " + result.getDouble("price"));
                System.out.println("Make:      " + result.getString("make"));
                System.out.println("Model:     " + result.getString("model"));
                System.out.println("Color:     " + result.getString("color"));
                System.out.println("Sold:      " + result.getBoolean("sold"));
                System.out.println(" -------- ");
            }

            }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getVehiclesByPrice(double minPrice, double maxPrice) {
        String query = "SELECT d.name, v.make, v.model, v.color, v.year, v.price " +
                "FROM vehicles v " +
                "JOIN dealerships d " +
                "ON v.dealership_id = d.dealership_id " +
                "WHERE v.price BETWEEN ? AND ? " +
                "ORDER BY v.price";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement prepStatement = conn.prepareStatement(query)) {

            prepStatement.setDouble(1, minPrice);
            prepStatement.setDouble(2, maxPrice);
            ResultSet result = prepStatement.executeQuery();

            while (result.next()) {
                System.out.println("Dealership:  " + result.getString("name"));
                System.out.println("Make:        " + result.getString("make"));
                System.out.println("Model:       " + result.getString("model"));
                System.out.println("Color:       " + result.getString("color"));
                System.out.println("Year:        " + result.getInt("year"));
                System.out.println("Price:       " + result.getDouble("price"));
                System.out.println(" -------- ");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getVehiclesByMakeModel(String make, String model) {

    }

    public static void getVehiclesByYear(String startYear, String endYear) {

    }

    public static void getVehiclesByColor(String color) {

    }

    public static void getVehiclesByType(String startYear, String endYear) {
        // Reminder to put Type into SQL DB

    }

    public static void getVehiclesByMileage(String minMile, String maxMile) {

    }

    public static void insertNewVehicle(double price, int year, String make, String model, String color) {

    }

    public static void removeVehicle() {

    }

    public double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }

    public double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public static BasicDataSource getDataSource() {
        return dataSource;
    }

    public static void setDataSource(BasicDataSource dataSource) {
        VehiclesDAO.dataSource = dataSource;
    }

    public int getMinMile() {
        return minMile;
    }

    public void setMinMile(int minMile) {
        this.minMile = minMile;
    }

    public int getMaxMile() {
        return maxMile;
    }

    public void setMaxMile(int maxMile) {
        this.maxMile = maxMile;
    }
}
