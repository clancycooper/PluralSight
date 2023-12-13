package com.pluralsight;
import java.sql.*;
import java.util.Scanner;
import org.apache.commons.dbcp2.BasicDataSource;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String query = "";

        System.out.println("What do you want to do?");
        System.out.println("    Hint: Type 1, 2, 3 or 0");
        System.out.println("""
                1) Show all NorthWind Products
                2) Show all NorthWind Customers
                3) Show all NorthWind Categories
                0) Exit Program""");
        String userInput = scanner.nextLine();
        switch (userInput) {
            case "1" -> query = "SELECT * FROM products;";
            case "2" -> query = "SELECT * FROM customers ORDER BY country;";
            case "3" -> query = "SELECT * FROM categories ORDER BY categoryID";
            case "0" -> System.exit(0);
            default -> {
                System.out.println("Sorry, that was not a valid option");
                System.exit(0);
            }
        }

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/northwind");
        dataSource.setUsername(args[0]);
        dataSource.setPassword(args[1]);

        try (Connection conn = dataSource.getConnection();
             PreparedStatement prepStatement = conn.prepareStatement(query);
             ResultSet result = prepStatement.executeQuery()) {


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
                if (userInput.equals("3")) {
                    System.out.println("Category ID:       " + result.getInt(1));
                    System.out.println("Category Name:     " + result.getString(2));
                    System.out.println(" -------- ");
                }
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
}