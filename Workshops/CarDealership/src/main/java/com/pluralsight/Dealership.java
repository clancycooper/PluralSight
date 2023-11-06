package com.pluralsight;

import java.util.ArrayList;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;


    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;

        //instantiate ArrayList
        inventory = new ArrayList<>();
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

    public void getAllVehicles() {
        //getInventory
        for (int i = 0; i < inventory.size(); i++) {
            Vehicle allVehicles = inventory.get(i);
            //System.out.println(allVehicles);
        }
    }

    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);

    }

    public static Vehicle removeVehicle(Vehicle vehicle) {
        return vehicle;
        //.remove
    }

}
