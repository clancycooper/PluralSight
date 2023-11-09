package com.pluralsight;

import java.util.ArrayList;

public class Dealership {
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

    public static double getVehiclesByPrice(double min, double max) {

        return 0;
    }

    public static String getVehiclesByMakeModel(String make, String model) {
        return null;
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

    public static ArrayList<Vehicle> getAllVehicles() {
        ArrayList<Vehicle> allVehicles = new ArrayList<>();
        //getInventory
        for (Vehicle vehicles : inventory) {
            allVehicles.add(vehicles);
        }
        return allVehicles;
    }

    public static void addVehicle(Vehicle newVehicle) {
        inventory.add(newVehicle);

    }

    public void removeVehicle(Vehicle vehicle) {
        inventory.remove(vehicle);
    }

}
