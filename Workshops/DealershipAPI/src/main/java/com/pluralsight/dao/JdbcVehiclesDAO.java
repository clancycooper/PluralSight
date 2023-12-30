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
        String query = "INSERT INTO vehicles (VIN, year, odometer, make, model, type, color, price, sold) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement prepStatement = connection.prepareStatement(query)) {
            prepStatement.setInt(1, vehicle.getVIN());
            prepStatement.setInt(2, vehicle.getYear());
            prepStatement.setInt(3, vehicle.getOdometer());
            prepStatement.setString(4, vehicle.getMake());
            prepStatement.setString(5, vehicle.getModel());
            prepStatement.setString(6, vehicle.getVehicleType());
            prepStatement.setString(7, vehicle.getColor());
            prepStatement.setDouble(8, vehicle.getPrice());
            prepStatement.setBoolean(9, vehicle.isSold());
            int rows = prepStatement.executeUpdate();

            if (rows == 0) {
                throw new SQLException("Insertion failed, no rows affected.");
            } else {
                System.out.println("New Vehicle has been successfully added!");
            }

            return vehicle;

        } catch (SQLException e) {
            if (e.getErrorCode() == 1062) {
                throw new RuntimeException("Error: VIN must be unique.", e);
            } else {
                throw new RuntimeException("Error occurred while inserting vehicle", e);
            }
        }
    }


    @Override
    public void update(int vin, Vehicle vehicle) {
        String query = "UPDATE vehicles SET odometer = ?, make = ?, model = ?, type = ?, color = ?, price = ?, sold = ?, dealership_id = ? WHERE VIN = ?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement prepStatement = conn.prepareStatement(query)) {
            prepStatement.setInt(1, vehicle.getOdometer());
            prepStatement.setString(2, vehicle.getMake());
            prepStatement.setString(3, vehicle.getModel());
            prepStatement.setString(4, vehicle.getVehicleType());
            prepStatement.setString(5, vehicle.getColor());
            prepStatement.setDouble(6, vehicle.getPrice());
            prepStatement.setBoolean(7, vehicle.isSold());
            prepStatement.setInt(8, vehicle.getDealershipID());
            prepStatement.setInt(9, vin);

            int rows = prepStatement.executeUpdate();

            if (rows > 0) {
                System.out.println("Vehicle with VIN: " + vin + " updated successfully.");
            } else {
                System.out.println("No vehicle found with VIN: " + vin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int vin) {
        String query = "DELETE FROM vehicles WHERE VIN = ? ";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement prepStatement = conn.prepareStatement(query)) {
            prepStatement.setInt(1, vin);

            int rows = prepStatement.executeUpdate();

            if (rows > 0) {
                System.out.println("Vehicle with VIN: " + vin + " deleted successfully.");
            } else {
                System.out.println("No vehicle found with VIN: " + vin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}