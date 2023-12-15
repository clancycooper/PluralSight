package com.pluralsight.dealership;

import com.pluralsight.dealership.DAOs.DealershipDAO;
import com.pluralsight.dealership.DAOs.LeaseContractDAO;
import com.pluralsight.dealership.DAOs.SalesContractDAO;
import com.pluralsight.dealership.DAOs.VehiclesDAO;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.SQLException;
import java.util.Scanner;

public class CarDealershipApp {
    static Scanner scanner = new Scanner(System.in);
    static String userInput;

    public static void main(String[] args) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/cardealership");
        dataSource.setUsername(args[0]);
        dataSource.setPassword(args[1]);
        DealershipDAO dealershipManager = new DealershipDAO(dataSource);
        VehiclesDAO vehiclesManager = new VehiclesDAO(dataSource);
        LeaseContractDAO leaseManager = new LeaseContractDAO(dataSource);
        SalesContractDAO saleManager = new SalesContractDAO(dataSource);


        System.out.println("Welcome to Clancy and Andi's Car Dealership App!");
        homeScreen();
    }

    public static void homeScreen(){
        System.out.println("""
                Enter the number of the menu option you wish to view:\s
                1) View All Vehicles
                2) Add A Vehicle
                3) Remove A Vehicle
                4) Filter Vehicles By Price
                5) Filter Vehicles By Make/Model
                6) Filter Vehicles By Year
                7) Filter Vehicles By Color
                8) Filter Vehicles By Mileage
                9) Filter Vehicles By Type
                0) Exit""");
        userInput = scanner.nextLine();

        switch(userInput) {
            case "1": VehiclesDAO.getAllVehicles();
            case "4": UserInterface.processVehiclesByPrice();
        }
    }

}
