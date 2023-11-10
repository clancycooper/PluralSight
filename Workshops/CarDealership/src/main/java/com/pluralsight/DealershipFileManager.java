package com.pluralsight;

import java.io.*;

import static com.pluralsight.Dealership.inventory;

public class DealershipFileManager {
    public static String csv;
    public static Dealership dealership;

    public static void getDealership() throws IOException {
        BufferedReader infoLine = new BufferedReader(new FileReader("src/main/resources/inventory.csv"));
        String csv;

        while ((csv = infoLine.readLine()) != null) {
            String[] dealershipSplit = csv.split("\\|");
            if (!dealershipSplit[0].contains("D")) {
                int vin = Integer.parseInt(dealershipSplit[0]);
                int year = Integer.parseInt(dealershipSplit[1]);
                String make = dealershipSplit[2];
                String model = dealershipSplit[3];
                String vehicleType = dealershipSplit[4];
                String color = dealershipSplit[5];
                int odometer = Integer.parseInt(dealershipSplit[6]);
                double price = Double.parseDouble(dealershipSplit[7]);
                Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                inventory.add(vehicle);

            } else {
                String name = dealershipSplit[0];
                String address = dealershipSplit[1];
                String phone = dealershipSplit[2];
                dealership = new Dealership(name, address, phone);
            }
        }
        infoLine.close();
    }
    public static void saveDealership(int vin, int year, String make, String model, String vehicleType, String color, int mileage, double price) throws IOException {
        FileWriter writeFile = new FileWriter("src/main/resources/inventory.csv", true);
        BufferedWriter saveFile = new BufferedWriter(writeFile);
        saveFile.write("\n" + vin + "|" + year + "|" + make + "|" + model + "|" + vehicleType + "|" + color + "|" + mileage + "|" + price);
        saveFile.close();
    }

    public static void backupDeletedVehicle(int vin, int year, String make, String model, String vehicleType, String color, int mileage, double price) throws IOException {
        FileWriter backupFile = new FileWriter("src/main/resources/inventorybackup.csv", true);
        BufferedWriter backupWriter = new BufferedWriter(backupFile);
        backupWriter.write("\n" + vin + "|" + year + "|" + make + "|" + model + "|" + vehicleType + "|" + color + "|" + mileage + "|" + price);
        backupWriter.close();
    }


}

