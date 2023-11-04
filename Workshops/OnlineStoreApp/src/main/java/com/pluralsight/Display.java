package com.pluralsight;

import java.util.HashMap;
import java.util.Scanner;

import static com.pluralsight.CartScreen.addCart;
import static com.pluralsight.CartScreen.cartList;
import static com.pluralsight.OnlineStoreApp.homeScreen;
import static com.pluralsight.ProductScreen.productList;
import static com.pluralsight.ProductScreen.search_filterProducts;

public class Display {
    public static void displayProducts() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nAll Available Products:");
        for(HashMap.Entry<String, Products> productsEntry : productList.entrySet()) {
            System.out.println("SKU: " + productsEntry.getKey() + " | Name: " + productsEntry.getValue().getName() + " | Price: $" + productsEntry.getValue().getPrice() + " | Department: " + productsEntry.getValue().getDepartment());
        }
        System.out.println("\nWhat would you like to do next? \n Please enter a number below");
        System.out.println(" 1) Search and Filter Products \n 2) Return home \n 3) Add to cart");
        int prodMenu = scanner.nextInt();
        switch(prodMenu) {
            case 1: search_filterProducts();
            case 2: homeScreen();
            case 3: addCart();
            default:
                System.out.println("\nOh no! Invalid response, please type 1 or 2.");
        }
    }

    public static void displayCart() {
        System.out.println("\nYour cart:");
        for(CartItem p : cartList.values()) {
            Products current = p.getProduct();
            System.out.printf("\nSKU: %s | Name: %s | Price: %s | Quantity: %s%n", current.getSku(), current.getName(), current.getPrice(), CartItem.getQuantity());
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("What would you like to do next? \n 1) See my cart \n 2) Search and Filter Products \n 3) Go Home");
        int menuSwap = scanner.nextInt();
        switch(menuSwap) {
            case 1: displayCart();
            case 2: search_filterProducts();
            case 3: homeScreen();
            default:
                System.out.println("Sorry, invalid input, try 1, 2, or 3!");
                displayCart();
        }

    }
}
