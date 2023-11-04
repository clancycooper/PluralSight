package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static com.pluralsight.CartScreen.addCart;
import static com.pluralsight.Display.displayCart;
import static com.pluralsight.Display.displayProducts;
import static com.pluralsight.OnlineStoreApp.homeScreen;
import static java.lang.Float.parseFloat;

public class ProductScreen {
    public static HashMap<String, Products> productList = new HashMap<>();

    public static void loadProducts() {
        try {
            //Declaring readers/String
            FileReader fileReader = new FileReader("src/main/resources/products.csv");
            BufferedReader bufReader = new BufferedReader(fileReader);
            String csv;
            //While loop for reading and adding products to Hashmap
            while ((csv = bufReader.readLine()) != null) {
                String[] inventory = csv.split("\\|");
                String sku = inventory[0];
                String name = inventory[1];
                float price = parseFloat(inventory[2]);
                String department = inventory[3];
                Products newProduct = new Products(sku, name, price, department);
                productList.put(sku, newProduct);
            }
            homeScreen();
            fileReader.close();
            bufReader.close();
        } catch (IOException e) {
            System.out.println("Sorry, there was an IOException!");
            e.printStackTrace();
        }
    }

    public static void search_filterProducts() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the number value of your search from the list below: \n");
        System.out.println(" 1) Search by Product Name \n 2) Search by Product Price \n 3) Search by Product Department \n 4) Return Home");
        int search = scanner.nextInt();
        switch (search) {
            case 1:
                byProdName();
            case 2:
                byProdPrice();
            case 3:
                byProdDept();
            case 4:
                homeScreen();
            default:
                System.out.println("Oops! Invalid response. Please enter 1, 2, 3 or 4!");
                search_filterProducts();
        }
    }
    private static void byProdName() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nPlease enter the Product Name: \n");
        String nameSearch = scan.nextLine();
        int i = 0;
        for (Map.Entry<String, Products> entry : productList.entrySet()) {
            if (entry.getValue().getName().equalsIgnoreCase(nameSearch)) {
                System.out.println("Name : " + entry.getValue().getName() + " | Price: $" + entry.getValue().getPrice());
                i++;
            }
        }
        if(i == 0) {
            System.out.println("Oh no! We couldn't find a product matching that description!");
            byProdName();
        }
        System.out.println("What would you like to do next? \n 1) Add items to my cart \n 2) See my Cart \n 3) Display all Products \n 4) Go Home");
        int menuSwap = scan.nextInt();
        switch(menuSwap) {
            case 1: addCart();
            case 2: displayCart();
            case 3: displayProducts();
            case 4: homeScreen();
            default:
                System.out.println("Sorry! Invalid input, try 1, 2, 3, or 4!");
                byProdName();
        }
    }

    private static void byProdPrice() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nPlease enter the minimum dollar amount: $");
        float minPrice = scanner.nextFloat();
        System.out.print("\nPlease enter the maximum dollar amount: $");
        float maxPrice = scanner.nextFloat();
        int i = 0;
        for (Map.Entry<String, Products> entry : productList.entrySet()) {
            if (entry.getValue().getPrice() >= minPrice && entry.getValue().getPrice() <= maxPrice) {
                System.out.println(" Name: " + entry.getValue().getName() + " | Price: $" + entry.getValue().getPrice());
                i++;
            }
        }
        if (i == 0) {
            System.out.println("Oh no! We couldn't find any products matching that price range. Please try again!");
            byProdPrice();
        }
        System.out.println("What would you like to do next? \n 1) Add items to my cart \n 2) See my Cart \n 3) Display all Products \n 4) Go Home");
        int menuSwap = scanner.nextInt();
        switch (menuSwap) {
            case 1:
                addCart();
            case 2:
                displayCart();
            case 3:
                displayProducts();
            case 4:
                homeScreen();
            default:
                System.out.println("Sorry! Invalid input, try 1, 2, 3, or 4!");
                byProdName();
        }
    }


    private static void byProdDept() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nPlease enter the Department Name: \n");
        String deptSearch = sc.nextLine();
        int i = 0;
        for (Map.Entry<String, Products> entry : productList.entrySet()) {
            if (entry.getValue().getDepartment().equalsIgnoreCase(deptSearch)) {
                System.out.println("Department: " + entry.getValue().getDepartment() + " | Name: " + entry.getValue().getName() + " | Price: $" + entry.getValue().getPrice());
                i++;
            }
        }
        if (i == 0) {
            System.out.println("Oh no! We couldn't find a product matching that description!");
            byProdDept();
        }
        System.out.println("What would you like to do next? \n 1) Add items to my cart \n 2) See my Cart \n 3) Display all Products \n 4) Go Home");
        int menuSwap = sc.nextInt();
        switch (menuSwap) {
            case 1:
                addCart();
            case 2:
                displayCart();
            case 3:
                displayProducts();
            case 4:
                homeScreen();
            default:
                System.out.println("Sorry! Invalid input, try 1, 2, 3, or 4!");
                byProdName();
        }
    }
}
