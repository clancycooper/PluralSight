package com.pluralsight;

import java.util.Scanner;

public class SandwichShop {

    public static void main(String[] args) {
        //Create Scanner
        Scanner mySandwich = new Scanner(System.in);

        //Prompt user for their Sandwich Size
        System.out.println("""
                Hello, my name is Clancy and welcome to my sandwich shop!
                Would you like a #1 Regular for $5.45 or a #2 Large for $8.95?\s""");
        System.out.print("I would like a #");
        int sandwich_size = mySandwich.nextInt();

        //Calculate base price
        double base_price = 0;
        if(sandwich_size == 1) {
            base_price = 5.45;
        } else if(sandwich_size == 2) {
            base_price = 8.95;
        } else {
            System.out.println("Sorry, that's not something we offer. You're welcome to look over the menu while you decide on your order!");
            System.exit(0);
        }

        //Prompt user for their age
        System.out.println("Awesome choice!\n" +
                "Go ahead and enter your age to see if you qualify for a discount!");
        int customer_age = mySandwich.nextInt();

        //Calculate discount price
        double discount_price = 0;
        if(customer_age <= 17) {
            discount_price = base_price * .9;
            System.out.printf("You qualify for our Student Discount! Your total today is $" + "%.2f",  discount_price);
        } else if(customer_age >= 65) {
            discount_price = base_price * .8;
            System.out.printf("You qualify for our Senior Discount! Your total today is $" + "%.2f", discount_price);
        } else {
            discount_price = base_price;
            System.out.printf("Your total today is $" + "%.2f", discount_price);
        }
    }
}
