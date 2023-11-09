package com.pluralsight;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static com.pluralsight.UserInterface.displayVehicles;


public class Dealership {
    public static Scanner scanner = new Scanner(System.in);
    private String name;
    private String address;
    private String phone;
    public static ArrayList<Vehicle> inventory = new ArrayList<Vehicle>();


    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public static void getVehiclesByPrice() throws IOException {
        ArrayList<Vehicle> byPrice = new ArrayList<>();
        System.out.println("Filter Vehicles by Price:\n" +
                "Please enter the minimum dollar amount: ");
        double minPrice = scanner.nextDouble();
        System.out.println("Please enter the maximum dollar amount: ");
        double maxPrice = scanner.nextDouble();
        for (Vehicle vehicle : inventory) {
            if ((vehicle.getPrice() >= minPrice) && (vehicle.getPrice() <= maxPrice)) {
                byPrice.add(vehicle);
                displayVehicles(byPrice);
            }
        }
    }

    public static void getVehiclesByMakeModel() throws IOException {
        ArrayList<Vehicle> byMakeModel = new ArrayList<>();
        System.out.println("Filter Vehicles by Make/Model:\n" +
                "Please enter the Make: ");
        String make = scanner.nextLine();
        System.out.println("Please enter the Model: ");
        String model = scanner.nextLine();
        for (Vehicle vehicles : inventory) {
            if ((vehicles.getMake().equalsIgnoreCase(make)) || (vehicles.getModel().equalsIgnoreCase(model))) {
                displayVehicles(byMakeModel);
            }
        }
    }

    public static int getVehiclesByYear(int min, int max) {
        return 0;
    }

    public static String getVehiclesByColor(String color) {
        return null;
    }

    public static int getVehiclesByMileage(int min, int max) {
        return 0;
    }

    public static String getVehiclesByType(String vehicleType) {
        return null;
    }

    public static void getAllVehicles() throws IOException {
       displayVehicles(inventory);
    }

    public static void addVehicle(Vehicle newVehicle) throws IOException {
        inventory.add(newVehicle);
    }

    public void removeVehicle(Vehicle vehicle) throws IOException {
        inventory.remove(vehicle);
    }

}
