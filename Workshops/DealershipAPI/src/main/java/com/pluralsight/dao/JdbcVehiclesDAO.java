package com.pluralsight.dao;

import com.pluralsight.models.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcVehiclesDAO implements VehiclesDAO {
    private DataSource dataSource;

    @Autowired
    public JdbcVehiclesDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Vehicle> getAll() {
        List<Vehicle> allVehicles = new ArrayList<>();
        String query = "SELECT * FROM vehicles;";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement prepStatement = conn.prepareStatement(query);
             ResultSet result = prepStatement.executeQuery()) {

            while (result.next()) {
                int VIN = result.getInt("VIN");
                double price = result.getDouble("price");
                int odometer = result.getInt("odometer");
                String make = result.getString("make");
                String model = result.getString("model");
                String vehicleType = result.getString("type");
                int year = result.getInt("year");
                String color = result.getString("color");
                boolean sold = result.getBoolean("sold");
                Vehicle vehicle = new Vehicle(VIN, year, odometer, make, model, vehicleType, color, price, sold);
                allVehicles.add(vehicle);
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return allVehicles;
    }

    @Override
    public List<Vehicle> getByMinPrice(double minPrice) {
        List<Vehicle> lowestPrice = new ArrayList<>();
        String query = "SELECT VIN, dealership_id, price, make, model, color, year, odometer, sold, type " +
                "FROM vehicles " +
                "WHERE price <= ? " +
                "ORDER BY price";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement prepStatement = connection.prepareStatement(query)) {
            prepStatement.setDouble(1, minPrice);

            try (ResultSet result = prepStatement.executeQuery()) {
                while (result.next()) {
                    int VIN = result.getInt("VIN");
                    double price = result.getDouble("price");
                    int odometer = result.getInt("odometer");
                    String make = result.getString("make");
                    String model = result.getString("model");
                    String color = result.getString("color");
                    int year = result.getInt("year");
                    String vehicleType = result.getString("type");
                    boolean sold = result.getBoolean("sold");
                    Vehicle vehicle = new Vehicle(VIN, year, odometer, make, model, vehicleType, color, price, sold);
                    lowestPrice.add(vehicle);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lowestPrice;
    }

    @Override
    public List<Vehicle> getByMaxPrice(double maxPrice) {
        List<Vehicle> highestPrice = new ArrayList<>();
        String query = "SELECT VIN, dealership_id, price, make, model, color, year, odometer, sold, type " +
                "FROM vehicles " +
                "WHERE price >= ? " +
                "ORDER BY price";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement prepStatement = connection.prepareStatement(query)) {
            prepStatement.setDouble(1, maxPrice);

            try (ResultSet result = prepStatement.executeQuery()) {
                while (result.next()) {
                    int VIN = result.getInt("VIN");
                    double price = result.getDouble("price");
                    int odometer = result.getInt("odometer");
                    String make = result.getString("make");
                    String model = result.getString("model");
                    String color = result.getString("color");
                    int year = result.getInt("year");
                    String vehicleType = result.getString("type");
                    boolean sold = result.getBoolean("sold");
                    Vehicle vehicle = new Vehicle(VIN, year, odometer, make, model, vehicleType, color, price, sold);
                    highestPrice.add(vehicle);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return highestPrice;
    }

    @Override
    public List<Vehicle> getByMake(String makeID) {
            List<Vehicle> byMake = new ArrayList<>();
            String query = "SELECT VIN, dealership_id, price, make, model, color, year, odometer, sold, type " +
                    "FROM vehicles " +
                    "WHERE make = ? " +
                    "ORDER BY price";

            try (Connection connection = dataSource.getConnection();
                 PreparedStatement prepStatement = connection.prepareStatement(query)) {
                prepStatement.setString(1, makeID);

                try (ResultSet result = prepStatement.executeQuery()) {
                    while (result.next()) {
                        int VIN = result.getInt("VIN");
                        double price = result.getDouble("price");
                        int odometer = result.getInt("odometer");
                        String make = result.getString("make");
                        String model = result.getString("model");
                        String color = result.getString("color");
                        int year = result.getInt("year");
                        String vehicleType = result.getString("type");
                        boolean sold = result.getBoolean("sold");
                        Vehicle vehicle = new Vehicle(VIN, year, odometer, make, model, vehicleType, color, price, sold);
                        byMake.add(vehicle);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return byMake;
    }

    @Override
    public List<Vehicle> getByModel(String modelID) {
            List<Vehicle> byModel = new ArrayList<>();
            String query = "SELECT VIN, dealership_id, price, make, model, color, year, odometer, sold, type " +
                    "FROM vehicles " +
                    "WHERE model = ? " +
                    "ORDER BY price";

            try (Connection connection = dataSource.getConnection();
                 PreparedStatement prepStatement = connection.prepareStatement(query)) {
                prepStatement.setString(1, modelID);

                try (ResultSet result = prepStatement.executeQuery()) {
                    while (result.next()) {
                        int VIN = result.getInt("VIN");
                        double price = result.getDouble("price");
                        int odometer = result.getInt("odometer");
                        String make = result.getString("make");
                        String model = result.getString("model");
                        String color = result.getString("color");
                        int year = result.getInt("year");
                        String vehicleType = result.getString("type");
                        boolean sold = result.getBoolean("sold");
                        Vehicle vehicle = new Vehicle(VIN, year, odometer, make, model, vehicleType, color, price, sold);
                        byModel.add(vehicle);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return byModel;
    }



//    public static void getVehiclesByPrice(double minPrice, double maxPrice) {
//        String query = "SELECT d.name, v.make, v.model, v.color, v.year, v.price " +
//                "FROM vehicles v " +
//                "JOIN dealerships d " +
//                "ON v.dealership_id = d.dealership_id " +
//                "WHERE v.price BETWEEN ? AND ? " +
//                "ORDER BY v.price";
//
//        try (Connection conn = dataSource.getConnection();
//             PreparedStatement prepStatement = conn.prepareStatement(query)) {
//
//            prepStatement.setDouble(1, minPrice);
//            prepStatement.setDouble(2, maxPrice);
//            ResultSet result = prepStatement.executeQuery();
//
//            while (result.next()) {
//                System.out.println("Dealership:  " + result.getString("name"));
//                System.out.println("Make:        " + result.getString("make"));
//                System.out.println("Model:       " + result.getString("model"));
//                System.out.println("Color:       " + result.getString("color"));
//                System.out.println("Year:        " + result.getInt("year"));
//                System.out.println("Price:       " + result.getDouble("price"));
//                System.out.println(" -------- ");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

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

    @Override
    public Vehicle getByMinYear(int id) {
        return null;
    }

    @Override
    public Vehicle getByMaxYear(int id) {
        return null;
    }

    @Override
    public Vehicle getByColor(int id) {
        return null;
    }

    @Override
    public Vehicle getByType(int id) {
        return null;
    }

    @Override
    public Vehicle getByMinMile(int id) {
        return null;
    }

    @Override
    public Vehicle getByMaxMile(int id) {
        return null;
    }

    @Override
    public Vehicle insert(Vehicle vehicle) {
        return null;
    }

    @Override
    public void update(int id, Vehicle vehicle) {

    }

    @Override
    public void delete(int id) {

    }
}