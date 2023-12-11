package com.pluralsight;
import java.sql.*;
import javax.sql.DataSource;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:mysql://127.0.0.1:3306/northwind";
        String user = "root";
        String password = "-redacted-";

        String query = "SELECT * FROM Products";
        try {
            // Establishing connection
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();

            // Executing query
            ResultSet rs = stmt.executeQuery(query);

            // Processing the result set
            while (rs.next()) {
                // Replace with your column names and types
                System.out.println(rs.getString(2));
            }

            // Closing resources
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}