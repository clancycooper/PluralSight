package com.pluralsight;
import java.sql.*;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String query = "";
        Connection conn = null;
        PreparedStatement prepStatement = null;
        ResultSet result = null;

        System.out.println("What do you want to do?");
        System.out.println("    Hint: Type 1, 2 or 0");
        System.out.println("1) Show all NorthWind Products\n" +
                            "2) Show all NorthWind Customers\n" +
                            "0) Exit Program");
        String userInput = scanner.nextLine();
        switch (userInput) {
            case "1":
                query = "SELECT * FROM products;";
                break;
            case "2":
                query = "SELECT * FROM customers ORDER BY country;";
                break;
            case "0":
                System.exit(0);
                break;
            default:
                System.out.println("Sorry, that was not a valid option");
                System.exit(0);
        }

        String url = "jdbc:mysql://127.0.0.1:3306/northwind";
        String username = System.getenv("mysql_user");
        String password = System.getenv("-redacted-");

        try {
            conn = DriverManager.getConnection(url, username, password);
            prepStatement = conn.prepareStatement(query);
            result = prepStatement.executeQuery();

            // Processing the result set
            while (result.next()) {
                if (userInput.equals("1")) {
                    // Replace column index with the appropriate ones
                    System.out.println("ID:       " + result.getInt(1));
                    System.out.println("Name:     " + result.getString(2));
                    System.out.println("Price:    " + result.getDouble(3));
                    System.out.println("Stock:    " + result.getInt(4));
                    System.out.println(" -------- ");
                }
                if (userInput.equals("2")) {
                    System.out.println("Name:       " + result.getString(3));
                    System.out.println("Company:    " + result.getString(2));
                    System.out.println("City:       " + result.getString(6));
                    System.out.println("Country:    " + result.getString(9));
                    System.out.println("Phone:      " + result.getString(10));
                    System.out.println(" -------- ");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // close the resources
            try {
                if (result != null) {
                    result.close();
                }
                if (prepStatement != null) {
                    prepStatement.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}