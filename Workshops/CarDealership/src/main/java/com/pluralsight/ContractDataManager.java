package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ContractDataManager {
    public static void saveContract (int vin, int year, String make, String model, String vehicleType, String color, int mileage, double price) throws IOException {
        FileWriter writeFile = new FileWriter("src/main/resources/Contract.csv", true);
        BufferedWriter saveFile = new BufferedWriter(writeFile);
        saveFile.write("\n" + vin + "|" + year + "|" + make + "|" + model + "|" + vehicleType + "|" + color + "|" + mileage + "|" + price);
        saveFile.close();
    }
}