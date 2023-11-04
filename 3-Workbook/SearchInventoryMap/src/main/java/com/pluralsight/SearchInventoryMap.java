package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SearchInventoryMap {
    //Class HashMap
    public static HashMap<Integer, Products> inventoryList = new HashMap<Integer, Products>();
    //Main method, starts Load Inventory method (File and Buffered Readers for inventory csv)
    public static void main(String[] args) {
        loadInventory();
    }
    //Home screen, Welcome message, Navigation to Search Inventory method
    public static void homeScreen() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Clancy's General Store, how can I assist you today? \n 1) Search Inventory\n 2) Exit");
        int menuSwap = scanner.nextInt();
        switch (menuSwap) {
            case 1 -> searchInventory();
            case 2 -> System.exit(0);
            default -> {
                System.out.println("Oops! Please enter either 1 or 2!");
                homeScreen();
            }
        }
    }
    //Load Inventory method, loads our inventory from csv file, splits inventory at our delimiter, jumps to Home once finished
    public static void loadInventory() {
        try {
            //Create File Reader and Buffered Reader
            FileReader fileReader = new FileReader("src/main/resources/inventory.csv");
            BufferedReader bufReader = new BufferedReader(fileReader);
            String csv;
            //While loop for reading, splitting, and putting our csv
            while ((csv = bufReader.readLine()) != null) {
                //Setting while loop to read while inventory is not null
                String[] inventory = csv.split("\\|");
                int id = Integer.parseInt(inventory[0]);
                String name = inventory[1];
                float price = Float.parseFloat(inventory[2]);
                Products newProduct = new Products(id, name, price);
                inventoryList.put(id, newProduct);
            }
            //Remember to close readers! Sends user back to Home
            fileReader.close();
            bufReader.close();
            homeScreen();
        }
        //Catch for IO Exception
        catch (IOException e) {
            System.out.println("Sorry, there was an IOException!");
            e.printStackTrace();
        }
    }
    //Search method, loads product ID list, allows user to search, user can search multiple times, go back home, or exit the program
    public static void searchInventory() {
        try {
            Scanner scanner = new Scanner (System.in);
            System.out.print("Our available product IDs: \n");
            for (Map.Entry<Integer, Products> entry : inventoryList.entrySet()) {
                System.out.println("Id: " + entry.getKey());
            }
            System.out.println("Which item # are you interested in? ");
            String userInput = scanner.nextLine();
            int matchedProduct = 0;
            for(HashMap.Entry<Integer, Products> inventory : inventoryList.entrySet()) {
                if(inventory.getKey() == Integer.parseInt(userInput)){
                    System.out.println("\nID: " + inventory.getKey() + " | Name: " + inventory.getValue().getName() + " | Price: $" + inventory.getValue().getPrice());
                    break;
                } else if (matchedProduct == inventoryList.size() - 1) {
                    System.out.println("We don't carry that product. ");
                    searchInventory();
                }
                else {
                    matchedProduct++;
                }
                //Loop for another search, home, or exit
            }
            System.out.println("\nWould you like to do another search? \n 1) Yes, please!\n 2) Take me home\n 3) Exit");
            int searchAgain = scanner.nextInt();
            switch (searchAgain) {
                case 1 -> searchInventory();
                case 2 -> homeScreen();
                default -> System.exit(0);
            }
        }
        //Catch for Exception 'error'
        catch (Exception error) {
            System.out.println("Oh no! An error occurred!");
            error.printStackTrace();
        }
    }
}
