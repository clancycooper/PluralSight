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

    @Override
    public List<Vehicle> getByMinYear(int minYear) {
        List<Vehicle> lowestYear = new ArrayList<>();
        String query = "SELECT VIN, dealership_id, price, make, model, color, year, odometer, sold, type " +
                "FROM vehicles " +
                "WHERE year <= ? " +
                "ORDER BY year";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement prepStatement = connection.prepareStatement(query)) {
            prepStatement.setInt(1, minYear);

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
                    lowestYear.add(vehicle);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lowestYear;
    }

    @Override
    public List<Vehicle> getByMaxYear(int maxYear) {
        List<Vehicle> highestYear = new ArrayList<>();
        String query = "SELECT VIN, dealership_id, price, make, model, color, year, odometer, sold, type " +
                "FROM vehicles " +
                "WHERE year >= ? " +
                "ORDER BY year";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement prepStatement = connection.prepareStatement(query)) {
            prepStatement.setInt(1, maxYear);

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
                    highestYear.add(vehicle);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return highestYear;
    }

    @Override
    public List<Vehicle> getByColor(String color) {
        List<Vehicle> byColor = new ArrayList<>();
        String query = "SELECT VIN, dealership_id, price, make, model, color, year, odometer, sold, type " +
                "FROM vehicles " +
                "WHERE color = ? " +
                "ORDER BY dealership_id";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement prepStatement = connection.prepareStatement(query)) {
            prepStatement.setString(1, color);

            try (ResultSet result = prepStatement.executeQuery()) {
                while (result.next()) {
                    int VIN = result.getInt("VIN");
                    double price = result.getDouble("price");
                    int odometer = result.getInt("odometer");
                    String make = result.getString("make");
                    String model = result.getString("model");
                    int year = result.getInt("year");
                    String vehicleType = result.getString("type");
                    boolean sold = result.getBoolean("sold");
                    Vehicle vehicle = new Vehicle(VIN, year, odometer, make, model, vehicleType, color, price, sold);
                    byColor.add(vehicle);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return byColor;
    }

    @Override
    public List<Vehicle> getByMinMile(int minMile) {
        List<Vehicle> lowestMile = new ArrayList<>();
        String query = "SELECT VIN, dealership_id, price, make, model, color, year, odometer, sold, type " +
                "FROM vehicles " +
                "WHERE odometer <= ? " +
                "ORDER BY odometer";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement prepStatement = connection.prepareStatement(query)) {
            prepStatement.setInt(1, minMile);

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
                    lowestMile.add(vehicle);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lowestMile;
    }

    @Override
    public List<Vehicle> getByMaxMile(int maxMile) {
        List<Vehicle> highestMile = new ArrayList<>();
        String query = "SELECT VIN, dealership_id, price, make, model, color, year, odometer, sold, type " +
                "FROM vehicles " +
                "WHERE odometer >= ? " +
                "ORDER BY odometer";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement prepStatement = connection.prepareStatement(query)) {
            prepStatement.setInt(1, maxMile);

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
                    highestMile.add(vehicle);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return highestMile;
    }

    @Override
    public List<Vehicle> getByType(String type) {
        List<Vehicle> byType = new ArrayList<>();
        String query = "SELECT VIN, dealership_id, price, make, model, color, year, odometer, sold, type " +
                "FROM vehicles " +
                "WHERE type = ? " +
                "ORDER BY VIN";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement prepStatement = connection.prepareStatement(query)) {
            prepStatement.setString(1, type);

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
                    byType.add(vehicle);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return byType;
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