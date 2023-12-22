package com.pluralsight.ui;

import com.pluralsight.dao.JdbcVehiclesDAO;

import java.util.Scanner;

public class UserInterface {
    static Scanner scanner = new Scanner(System.in);

    public static void processVehiclesByPrice() {
        System.out.println("Please enter the minimum price for your vehicle search:");
        double minPrice = scanner.nextDouble();
        System.out.println("Please enter the maximum price for your vehicle search:");
        double maxPrice = scanner.nextDouble();

        JdbcVehiclesDAO.getVehiclesByPrice(minPrice, maxPrice);
        //MainApp.homeScreen();
    }

}
//    public static void init() throws IOException {
//        //getDealership();
//    }

//    public static void display() throws IOException {
//        init();
//        menu();
//        int menuSwap = scanner.nextInt();
//        switch(menuSwap) {
//            case 1:
//                processGetAllVehicleRequest();
//                break;
//            case 2:
//                processAddVehicleRequest();
//                break;
//            case 3:
//                processRemoveVehicleRequest();
//                break;
//            case 4:
//                processGetByPriceRequest();
//                break;
//            case 5:
//                processGetByMakeModelRequest();
//                break;
//            case 6:
//                processGetByYearRequest();
//                break;
//            case 7:
//                processGetByColorRequest();
//                break;
//            case 8:
//                processGetByMileageRequest();
//                break;
//            case 9:
//                processGetByVehicleTypeRequest();
//                break;
//            case 0:
//                System.exit(0);
//            default:
//                System.out.println("Sorry, please try again using a number between 0 - 9!");
//                menu();
//                break;
//        }
//    }

//    public static void processGetByPriceRequest() throws IOException {
//        getVehiclesByPrice();
//    }
//
//    public static void processGetByMakeModelRequest() throws IOException {
//        getVehiclesByMakeModel();
//    }
//
//    public static void processGetByYearRequest() throws IOException {
//        getVehiclesByYear();
//    }
//
//    public static void processGetByColorRequest() throws IOException {
//        getVehiclesByColor();
//    }
//
//    public static void processGetByMileageRequest() throws IOException {
//        getVehiclesByMileage();
//    }
//
//    public static void processGetByVehicleTypeRequest() throws IOException {
//        getVehiclesByType();
//    }
//
//    public static void processGetAllVehicleRequest() throws IOException {
//        getAllVehicles();
//    }
//
//    public static void processAddVehicleRequest() throws IOException {
//        addVehicle();
//    }
//
//    public static void processRemoveVehicleRequest() throws IOException {
//        removeVehicle();
//    }

//    public static void displayVehicles(ArrayList<Vehicle> allVehicles) throws IOException {
//        for (Vehicle vehicle : allVehicles) {
//            System.out.println(" VIN: " + vehicle.getVin() +
//                    " | Year: " + vehicle.getYear() +
//                    " | Make: " + vehicle.getMake() +
//                    " | Model: " + vehicle.getModel() +
//                    " | Type: " + vehicle.getVehicleType() +
//                    " | Color: " + vehicle.getColor() +
//                    " | Mileage: " + vehicle.getOdometer() +
//                    " | Price: " + vehicle.getPrice());
//        }
//    }