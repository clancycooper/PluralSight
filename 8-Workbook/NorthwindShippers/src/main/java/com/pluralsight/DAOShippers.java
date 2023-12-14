package com.pluralsight;

import java.sql.*;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class DAOShippers {
    private static DataSource dataSource;

    public DAOShippers(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static List<Shipper> getAllShippers() {
        //Reads and adds all current Shippers in the Northwind DB to an ArrayList of allShippers
        List<Shipper> allShippers = new ArrayList<>();
        String query = "SELECT * FROM shippers;";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement prepStatement = conn.prepareStatement(query);
             ResultSet resultSet = prepStatement.executeQuery()) {

            //While returning a result, add new Shipper object to the NorthwindDB
            while (resultSet.next()) {
                int shipperID = resultSet.getInt("ShipperID");
                String shipperName = resultSet.getString("CompanyName");
                String phoneNumber = resultSet.getString("Phone");
                Shipper shipper = new Shipper(shipperID, shipperName, phoneNumber);
                allShippers.add(shipper);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return allShippers;
    }

    public List<Shipper> insertNewShipper(String companyName, String phone) {
        //Inserts New Shipper into Northwind Database, auto-generates Primary Key ShipperID
        List<Shipper> insertedShippers = new ArrayList<>();
        String query = "INSERT INTO shippers (CompanyName, Phone) VALUES (?, ?)";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement prepStatement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            prepStatement.setString(1, companyName);
            prepStatement.setString(2, phone);
            int rows = prepStatement.executeUpdate();

            //Checks for successful insertion
            if (rows > 0) {
                ResultSet generatedKeys = prepStatement.getGeneratedKeys();
                while (generatedKeys.next()) {
                    int shipperID = generatedKeys.getInt(1);
                    Shipper newShipper = new Shipper(shipperID, companyName, phone);
                    insertedShippers.add(newShipper);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return insertedShippers;
    }




    public List<Shipper> updateShipperPhone(int shipperId, String phone) {
        //Queries Northwind DB for ID then sets phone to user entered value
        List<Shipper> updatedShipPhone = new ArrayList<>();
        String query = "UPDATE shippers SET Phone = ? WHERE ShipperID = ?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement prepStatement = conn.prepareStatement(query)) {
            prepStatement.setString(1, phone);
            prepStatement.setInt(2, shipperId);
            int rows = prepStatement.executeUpdate();

            //Check for successful update
            if (rows > 0) {
                Shipper updatedShipper = new Shipper(shipperId, "", phone);
                updatedShipPhone.add(updatedShipper);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return updatedShipPhone;
    }

    public List<Shipper> deleteNewShipper(int shipperID) {
        //Queries Northwind DB based on ShipperID, allows user to remove Shipper IF ShipperID > 3
        List<Shipper> deletedShippers = new ArrayList<>();
        String query = "DELETE FROM shippers WHERE ShipperID = ? AND ShipperID > 3";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement prepStatement = conn.prepareStatement(query)) {
            prepStatement.setInt(1, shipperID);
            int rows = prepStatement.executeUpdate();

            //Check to see if deletion was successful
            if (rows > 0) {
                Shipper deletedShipper = new Shipper(shipperID, "", "");
                deletedShippers.add(deletedShipper);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return deletedShippers;
    }

}
