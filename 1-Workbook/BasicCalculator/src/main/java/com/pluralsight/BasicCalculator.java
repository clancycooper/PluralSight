package com.pluralsight;

import java.util.Scanner;

public class BasicCalculator {
    public static void main(String[] args) {
        //create scanner
        Scanner myScanner = new Scanner(System.in);

        //start scanner
        System.out.print("Enter the first number: ");
        float first_num = myScanner.nextFloat();
        System.out.print("Enter the second number: ");
        float second_num = myScanner.nextFloat();

        //next prompt
        System.out.println("Possible calculations:\n" +
                "(A)dd\n" +
                "(S)ubtract\n" +
                "(M)ultiply\n" +
                "(D)ivide");
        System.out.print("Please select an option: ");
        String option = myScanner.next();

        //define variables as math classes
        System.out.println("(A) " + first_num + " + " + second_num + "=\n" +
                "(S) " + first_num + " - " + second_num + "=\n" +
                "(M) " + first_num + " * " + second_num + "=\n" +
                "(D) " + first_num + " / " + second_num + "=\n");



    }
}
