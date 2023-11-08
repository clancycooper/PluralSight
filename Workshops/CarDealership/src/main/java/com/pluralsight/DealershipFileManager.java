package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DealershipFileManager {
    public static String csv;
    public static Dealership dealership;
    public static ArrayList<Vehicle> vehicle = new ArrayList<>();

    public void getDealership() throws IOException {
        BufferedReader infoLine = new BufferedReader(new FileReader("src/main/resources/inventory.csv"));
        csv = infoLine.readLine();

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
                dealership.addVehicle(vehicle);

                System.out.println(vin + "|" + year + "|" + make + "|" + model + "|" + vehicleType + "|" + color + "|" + odometer + "|" + price);

            } else {
                String name = dealershipSplit[0];
                String address = dealershipSplit[1];
                String phone = dealershipSplit[2];
                dealership = new Dealership(name, address, phone);

                System.out.println(name + "|" + address + "|" + phone);
            }
        }
        infoLine.close();
        //public static void saveDealership() {

       // }

}
}
