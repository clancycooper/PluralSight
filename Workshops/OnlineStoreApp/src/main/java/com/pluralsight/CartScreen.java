package com.pluralsight;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static com.pluralsight.Display.displayCart;
import static com.pluralsight.Display.displayProducts;
import static com.pluralsight.OnlineStoreApp.homeScreen;
import static com.pluralsight.ProductScreen.productList;
import static com.pluralsight.ProductScreen.search_filterProducts;

public class CartScreen {
    public static HashMap<String, CartItem> cartList = new HashMap<String, CartItem>();

    public static void addCart() {
        Scanner scanner = new Scanner(System.in);
        displayProducts();
        System.out.println("\nPlease enter the SKU of the item your would like to add to your cart:");
        String skuSearch = scanner.nextLine().toUpperCase();
        for(Map.Entry<String, Products> entry : productList.entrySet()) {
            if(entry.getValue().getSku().equalsIgnoreCase(skuSearch)) {
                System.out.println("\nName : " + entry.getValue().getName() + " | Price: $" + entry.getValue().getPrice());
                System.out.println("Would you like to add this product to your cart? \n Type Y: Yes \n Type N: No \n");
                String userCart = scanner.nextLine();
                System.out.println("How many would you like to add to your cart? \n Type your amount: ");
                int cartQuantity = scanner.nextInt();
                if(userCart.equalsIgnoreCase("Y")){
                    cartList.put(skuSearch, new CartItem(cartQuantity, productList.get(skuSearch)));
                    System.out.println("Success! Your item has been added to your cart!");
                    break;
                } else if(userCart.equalsIgnoreCase("N")) {
                    addCart();
                }
            }
        }
        System.out.println("What would you like to do next? \n 1) Return to Search and Filter \n 2) Return Home \n 3) Remove items from my cart");
        int menuSwap = scanner.nextInt();
        switch(menuSwap) {
            case 1: search_filterProducts();
            case 2: homeScreen();
            case 3: removeCart();
            default:
                System.out.println("Sorry didn't catch that, try typing 1 or 2!");
                addCart();
        }
    }

    public static void removeCart() {
        Scanner scanner = new Scanner(System.in);
        displayProducts();
        System.out.println("\nPlease enter the SKU of the item you would like to remove from your cart:");
        String skuSearch = scanner.nextLine().toUpperCase();
        for(Map.Entry<String, Products> entry : productList.entrySet()) {
            if(entry.getValue().getSku().equalsIgnoreCase(skuSearch)) {
                System.out.println("\nName : " + entry.getValue().getName() + " | Price: $" + entry.getValue().getPrice());
                System.out.println("How many would you like to remove from your cart? \n Type your amount: ");
                int cartQuantity = scanner.nextInt();
                if(cartQuantity == 0) {
                    cartList.remove(skuSearch);
                    System.out.println("Success! Your item has been removed from your cart!");
                    displayCart();
                } else {
                    cartList.get(skuSearch).setQuantity(cartQuantity);
                    displayCart();
                }
            }
        }
    }
}
