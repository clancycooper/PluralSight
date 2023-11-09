package com.pluralsight;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static com.pluralsight.Dealership.*;


public class UserInterface {
    static Scanner scanner = new Scanner(System.in);

    private static void init() throws IOException {
        DealershipFileManager newDealership = new DealershipFileManager();
        newDealership.getDealership();
    }

    public static void display() throws IOException {
        init();
        menu();
        int menuSwap = scanner.nextInt();
        switch(menuSwap) {
            case 1:
                processGetAllVehicleRequest();
                break;
            case 2:
                processAddVehicleRequest();
                break;
            case 3:
                processRemoveVehicleRequest();
                break;
            case 4:
                processGetByPriceRequest();
                break;
            case 5:
                processGetByMakeModelRequest();
                break;
            case 6:
                processGetByYearRequest();
                break;
            case 7:
                processGetByColorRequest();
                break;
            case 8:
                processGetByMileageRequest();
                break;
            case 9:
                processGetByVehicleTypeRequest();
                break;
            case 0:
                System.exit(0);
            default:
                System.out.println("Sorry, please try again using a number between 0 - 9!");
                menu();
                break;
        }
    }

    public static void processGetByPriceRequest() throws IOException {
        getVehiclesByPrice();
    }

    public static void processGetByMakeModelRequest() throws IOException {
        getVehiclesByMakeModel();
    }

    public static void processGetByYearRequest() {

    }

    public static void processGetByColorRequest() {

    }

    public static void processGetByMileageRequest() {

    }

    public static void processGetByVehicleTypeRequest() {

    }

    public static void processGetAllVehicleRequest() throws IOException {
        getAllVehicles();
    }

    public static void processAddVehicleRequest() {
    //saveDealership
    }

    public static void processRemoveVehicleRequest() {
    //saveDealership
    }

    public static void displayVehicles(ArrayList<Vehicle> allVehicles) throws IOException {
        for(Vehicle vehicle: inventory) {
            System.out.println(" VIN: " + vehicle.getVin() +
                    " | Year: " + vehicle.getYear() +
                    " | Make: " + vehicle.getMake() +
                    " | Model: " + vehicle.getModel() +
                    " | Type: " + vehicle.getVehicleType() +
                    " | Color: " + vehicle.getColor() +
                    " | Mileage: " + vehicle.getOdometer() +
                    " | Price: " + vehicle.getPrice());
        }
    }

    public static void menu() {
        String welcome = """
                Welcome to ClancysList, the one stop shop for all things used vehicles.
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
                0) Exit""";
        System.out.println(welcome);
    }
}