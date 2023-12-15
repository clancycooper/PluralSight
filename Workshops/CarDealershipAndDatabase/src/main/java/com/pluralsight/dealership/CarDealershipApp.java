package com.pluralsight.dealership;

import com.pluralsight.dealership.DAOs.DealershipDAO;
import com.pluralsight.dealership.DAOs.LeaseContractDAO;
import com.pluralsight.dealership.DAOs.SalesContractDAO;
import com.pluralsight.dealership.DAOs.VehiclesDAO;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.SQLException;
import java.util.Scanner;

public class CarDealershipApp {
    static BasicDataSource dataSource = new BasicDataSource();
    static Scanner scanner = new Scanner(System.in);
    static String userInput;

    public static void main(String[] args) throws SQLException {

        System.out.println("Welcome to Clancy and Andi's Car Dealership App!");
        VehiclesDAO.getAllVehicles();
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
    }
}
