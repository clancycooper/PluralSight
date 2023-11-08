package com.pluralsight;

import java.io.IOException;

import static com.pluralsight.DealershipFileManager.getDealership;
import static com.pluralsight.DealershipFileManager.getInventory;

public class CarDealershipApp {
    public static void main(String[] args) throws IOException {
        getDealership();
        getInventory();
    }
}
