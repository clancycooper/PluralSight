package com.pluralsight.dealership.DAOs;

import org.apache.commons.dbcp2.BasicDataSource;
import com.pluralsight.dealership.Dealership;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DealershipDAO {
    private static BasicDataSource dataSource;

    public DealershipDAO(BasicDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static void getAllDealerships() {
            String query = "SELECT * FROM dealerships;";

            try (Connection conn = dataSource.getConnection();
                 PreparedStatement prepStatement = conn.prepareStatement(query);
                 ResultSet result = prepStatement.executeQuery()) {

                // Processing the result set
                while (result.next()) {
                    // Replace column index with the appropriate ones
                    System.out.println("ID:                 " + result.getInt("dealership_id"));
                    System.out.println("Dealership Name:    " + result.getString("name"));
                    System.out.println("Address:            " + result.getString("address"));
                    System.out.println("Phone:              " + result.getString("phone"));
                    System.out.println(" -------- ");
                }

            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }

    public static void saveDealership(String name, String phone, String address) {

    }
}


