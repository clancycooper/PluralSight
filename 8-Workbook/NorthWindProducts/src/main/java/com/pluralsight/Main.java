package com.pluralsight;
import java.sql.*;
import javax.sql.DataSource;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:mysql://127.0.0.1:3306/northwind";
        String username = System.getenv("mysql_user");
        String password = System.getenv("-redacted-");

        String query = "SELECT * FROM Products";
        try {
            // Establishing connection
            Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement prepStatement = conn.prepareStatement("SELECT * FROM products;");

            // Executing query
            ResultSet result = prepStatement.executeQuery(query);

            // Processing the result set
            while (result.next()) {
                // Replace with your column names and types
                System.out.println("ID:       " + result.getInt(1));
                System.out.println("Name:     " + result.getString(2));
                System.out.println("Price:    " + result.getDouble(6));
                System.out.println("Stock:    " + result.getInt(7));
                System.out.println(" -------- ");
            }

            // Closing resources
            result.close();
            prepStatement.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}