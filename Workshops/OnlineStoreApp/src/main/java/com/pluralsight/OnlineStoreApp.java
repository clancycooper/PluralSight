package com.pluralsight;

import java.util.Scanner;

import static com.pluralsight.Display.displayCart;
import static com.pluralsight.Display.displayProducts;
import static com.pluralsight.ProductScreen.loadProducts;

public class OnlineStoreApp {
    public static void main(String[] args) {
        loadProducts();
    }
    public static void homeScreen() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Clancy's Online Shop, how can I assist you today? \n 1) Display all products \n 2) Display my cart \n 3) Exit");
        int menuSwap = scanner.nextInt();
        switch (menuSwap) {
            case 1 -> displayProducts();
            case 2 -> displayCart();
            case 3 -> System.exit(0);
            default -> {
                System.out.println("Oops! Please enter 1, 2, or 3!");
                homeScreen();
            }
        }

    }
}
