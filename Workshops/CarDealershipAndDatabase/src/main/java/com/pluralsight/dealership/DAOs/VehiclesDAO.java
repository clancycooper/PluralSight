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
    static String username = System.getenv("MY_SQL_USERNAME");
    static String password  = System.getenv("MY_SQL_PASSWORD");

    static {
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/cardealership");
        dataSource.setUsername(username);
        dataSource.setPassword(password);
    }

    public VehiclesDAO(DataSource dataSource) throws SQLException {
        this.dataSource = (BasicDataSource) dataSource;
    }

    VehiclesDAO vehicleManager = new VehiclesDAO(dataSource);

    public static void getAllVehicles() throws SQLException {
        String query = "SELECT * FROM vehicles;";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement prepStatement = conn.prepareStatement(query);
             ResultSet result = prepStatement.executeQuery()) {

            // Processing the result set
            while (result.next()) {
                // Replace column index with the appropriate ones
                System.out.println("VIN:       " + result.getInt("VIN"));
                System.out.println("ID:        " + result.getInt("dealership_id"));
                System.out.println("Price:    " + result.getDouble("price"));
                System.out.println("Make:    " + result.getString("make"));
                System.out.println("Model:    " + result.getString("model"));
                System.out.println("Color:    " + result.getString("color"));
                System.out.println("Sold:    " + result.getBoolean("sold"));
                System.out.println(" -------- ");
            }

            }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Vehicle> getVehiclesByPrice(double minPrice, double maxPrice) {
    return null;
    }

    public static List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        return null;
    }

    public static List<Vehicle> getVehiclesByYear(String startYear, String endYear) {
        return null;
    }

    public static List<Vehicle> getVehiclesByColor(String color) {
        return null;
    }

    public static List<Vehicle> getVehiclesByType(String startYear, String endYear) {
        // Reminder to put Type into SQL DB
        return null;
    }

    public static List<Vehicle> getVehiclesByMileage(String minMile, String maxMile) {
        return null;
    }

    public List<Vehicle> insertNewVehicle(double price, int year, String make, String model, String color) {
        return null;
    }

    public List<Vehicle> removeVehicle() {
       return null;
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
