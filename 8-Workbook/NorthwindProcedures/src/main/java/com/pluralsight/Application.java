package com.pluralsight;

import org.apache.commons.dbcp2.BasicDataSource;
import java.util.Scanner;

public class Application {
    static BasicDataSource dataSource = new BasicDataSource();
    static Scanner scanner = new Scanner(System.in);
    static String userInput;

    public static void main(String[] args) {
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/northwind");
        dataSource.setUsername(args[0]);
        dataSource.setPassword(args[1]);
        DAOProcedures dataManager = new DAOProcedures(dataSource);

        System.out.println("Welcome to the Northwind's Stored Procedures!");
        homeScreen();
    }

    public static void homeScreen() {
        System.out.println("""
                How can Northwind serve you?
                    Hint: Enter the # of your selection
                1) Search Customer Order History
                2) See Sales By Year
                3) See Sales By Category
                0) Logout
                """);
        userInput = scanner.nextLine();
        switch (userInput) {
            case "1" -> orderHistory();
            case "2" -> salesByYear();
            case "3" -> salesByCategory();
            case "0" -> {
                System.out.println("Thank you for visiting Northwind Procedures, you are now logged out.");
                System.exit(0);
            }
            default -> System.out.println("Invalid input. Please enter a valid option.");
        }
    }

    public static void orderHistory() {
        System.out.println("Please enter the ID of the Northwind Customer whose Order History you wish to view.");
        String customerID = scanner.nextLine();

        DAOProcedures.getOrderHistory(customerID);
        homeScreen();
    }

    public static void salesByYear() {
        System.out.println("Please enter the Start Date for your search.\n     Hint: Format your query as YYYY-MM-DD");
        String startDate = scanner.nextLine();
        System.out.println("Please enter the End Date for your search.\n     Hint: Format your query as YYYY-MM-DD");
        String endDate = scanner.nextLine();

        DAOProcedures.getSalesByYear(startDate, endDate);
        homeScreen();
    }

    public static void salesByCategory() {
        System.out.println("Please enter the Category Name you wish to view.");
        String category = scanner.nextLine();
        System.out.println("Please enter the Year you wish to view these Category sales for.\n      Hint: Enter your query as YYYY");
        String year = scanner.nextLine();

        DAOProcedures.getSalesByCategory(category, year);
        homeScreen();
    }
}