package com.pluralsight;

import java.util.Scanner;

public class PayrollCalculator {
    public static void main(String[] args) {
        //define scanner
        Scanner myScanner = new Scanner(System.in);

        //input name, hours, hourly
        System.out.print("Enter your name: ");
        String name = myScanner.next();
        System.out.print("Enter your hours worked: ");
        float wrk_hours = myScanner.nextFloat();
        System.out.print("Enter your hourly rate: ");
        float hrly_rate = myScanner.nextFloat();

        //gross pay
        System.out.print(name + " you make " + wrk_hours * hrly_rate + " in gross pay.");
    }
}
