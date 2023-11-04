package com.pluralsight;

import java.util.Scanner;

public class AddressBuilder {
    public static void main(String[] args) {
        Scanner addressInput = new Scanner(System.in);
        System.out.println("Please provide the following information:");

        StringBuilder userName = new StringBuilder();
        System.out.println("Full name:");
        userName.append(addressInput.nextLine() + "\n");

        StringBuilder userBilling = new StringBuilder();
        System.out.println("Billing Street:");
        userBilling.append(addressInput.nextLine() + "\n");
        System.out.println("Billing City:");
        userBilling.append(addressInput.nextLine() + ", ");
        System.out.println("Billing State:");
        userBilling.append(addressInput.nextLine() + " ");
        System.out.println("Billing Zip:");
        userBilling.append(addressInput.nextLine() + "\n");

        StringBuilder userShipping = new StringBuilder();
        System.out.println("\n" + "Shipping Street:");
        userShipping.append(addressInput.nextLine() + "\n");
        System.out.println("Shipping City:");
        userShipping.append(addressInput.nextLine() + ", ");
        System.out.println("Shipping State:");
        userShipping.append(addressInput.nextLine() + " ");
        System.out.println("Shipping Zip:");
        userShipping.append(addressInput.nextLine() + "\n");

        String myUserName = userName.toString();
        String myUserBilling = userBilling.toString();
        String myUserShipping = userShipping.toString();

        System.out.println("\n" + myUserName + "\n" + "Billing Address\n" + myUserBilling + "\n" + "Shipping Adress\n" + myUserShipping);
    }
}
