package com.pluralsight;

import org.apache.commons.dbcp2.BasicDataSource;

import java.util.List;
import java.util.Scanner;

public class Application {
    static Scanner scanner = new Scanner(System.in);
    static String userInput;
    static DAOShippers shipDAO;
    static BasicDataSource dataSource = new BasicDataSource();


    public static void main(String[] args) {
        //Connecting to the Northwind Database using args
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/northwind");
        dataSource.setUsername(args[0]);
        dataSource.setPassword(args[1]);
        shipDAO = new DAOShippers(dataSource);

        System.out.println("Welcome to the Northwind Shippers App!");
        homeScreen();
    }

    public static void homeScreen() {
        //User Interface
        System.out.println("""
                \n
                How can Northwind serve you?
                    Hint: Enter the # of your selection
                \n
                1) Add a new Northwind Shipper
                2) Edit a Northwind Shipper's Contact Information
                3) Remove a Northwind Shipper
                4) Display all Northwind Shippers
                0) Logout
                """);
        userInput = scanner.nextLine();

        switch (userInput) {
            case "1" -> insertNewShipper();
            case "2" -> updateShipperInfo();
            case "3" -> removeShipper();
            case "4" -> displayAllShippers();
            case "0" -> {
                System.out.println("Thank you for visiting Northwind Shippers, you are now logged out.");
                System.exit(0);
            }
            default -> System.out.println("Invalid input. Please enter a valid option.");
        }

    }

    public static void displayAllShippers() {
        //Displays all Current Shippers to the User
        List<Shipper> shippers = DAOShippers.getAllShippers();
        System.out.println("Current Northwind Shippers List:");

        for (Shipper shipper : shippers) {
            System.out.println("Shipper ID: " + shipper.getShipperID());
            System.out.println("Company Name: " + shipper.getCompanyName());
            System.out.println("Phone Number: " + shipper.getPhone());
            System.out.println("--------");
        }

        homeScreen();
    }

    public static void insertNewShipper() {
        //Allows user to add New Shipper, incremented ID is added automatically
        System.out.println("Enter the new Northwind Shipper's company name:");
        String companyName = scanner.nextLine();

        System.out.println("Enter the new Northwind Shipper's phone number:");
        String phone = scanner.nextLine();

        shipDAO.insertNewShipper(companyName, phone);
        displayAllShippers();
    }

    public static void updateShipperInfo() {
        //Allows user to updates Shipper's Contact Phone Number
        System.out.println("Enter the Shipper's ID:");
        int shipperId = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter the Shipper's updated phone number:");
        String phone = scanner.nextLine();

        shipDAO.updateShipperPhone(shipperId, phone);
        System.out.println("New Northwind Shipper successfully updated!");
        displayAllShippers();
    }

    public static void removeShipper() {
        //Allows user to delete a Shipper as long as they are not a "Legacy" Shipper (IDs 1-3)
        System.out.println("""
                Enter the Shipper's ID:
                    Hint: ID's 1-3 will not be removed
                    """);
        int shipperID = scanner.nextInt();
        scanner.nextLine();

        if (shipperID <= 3) {
            System.out.println("This Northwind Legacy Shipper cannot be removed from our list!");
            removeShipper();
        } else {
            shipDAO.deleteNewShipper(shipperID);
            System.out.println("New Northwind Shipper successfully removed!");
            displayAllShippers();
        }
    }
}
