package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DealershipFileManager {
    public static String csv;
    public static void getDealership() throws IOException {
        BufferedReader infoLine = new BufferedReader(new FileReader("src/main/resources/inventory.csv"));

        while((csv = infoLine.readLine()) != null) {
            String[] dealershipSplit =csv.split("\\|");

            if(dealershipSplit[0].contains("D")) {
                String name = dealershipSplit[0];
                String address = dealershipSplit[1];
                String phone =dealershipSplit[2];
                Dealership dealerInfo = new Dealership(name, address, phone);

                System.out.println(name + "|" + address + "|" + phone);
            }

        }
        infoLine.close();

    }
    public static void getInventory() throws IOException {
        BufferedReader bufRead = new BufferedReader(new FileReader("src/main/resources/inventory.csv"));



        while ((csv = bufRead.readLine()) != null) {
            String[] inventorySplit = csv.split("\\|");

            if (!inventorySplit[0].contains("D")) {
                int vin = Integer.parseInt(inventorySplit[0]);
                int year = Integer.parseInt(inventorySplit[1]);
                String make = inventorySplit[2];
                String model = inventorySplit[3];
                String vehicleType = inventorySplit[4];
                String color = inventorySplit[5];
                int odometer = Integer.parseInt(inventorySplit[6]);
                double price = Double.parseDouble(inventorySplit[7]);
                Vehicle newVehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);

                System.out.println(vin + "|" + year + "|" + make + "|" + model + "|" + vehicleType + "|" + color + "|" + odometer + "|" + price);


            }
        }
        bufRead.close();
    }
}
