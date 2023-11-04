package com.pluralsight;

import java.text.NumberFormat;
import java.util.Scanner;

public class FinancialCalculator {
    //Prompt user to select their calculator 1, 2, or 3
    public static void main(String[] args) {
        System.out.print("Please select which calculator you would like to use: ");
        Scanner myCalculator = new Scanner(System.in);
        int calcSelect = myCalculator.nextInt();

        if(calcSelect == 1) {
            MortgageCalculator();
        } else if(calcSelect == 2) {
            CDCalculator();
        }

    }
    //Calculator 1: Mortgage Calculator
    public static void MortgageCalculator() {

        //Prompt user for Principal, Interest, and Length
        System.out.println("Welcome to the Mortgage Calculator\n" + "Please enter the following information:");
        System.out.print("1. What is the principal (loan amount)? ");
        Scanner myCalculator = new Scanner(System.in);
        int Principal = myCalculator.nextInt();
        System.out.print("2. What is the interest percentage? ");
        float Interest = myCalculator.nextFloat() / 100 / 12;
        System.out.print("3. What is the length of your loan (in years)? ");
        int Length = myCalculator.nextInt() * 12;

        //Calculate monthly payment and total interest
        double mathPow = Math.pow(1 + Interest, Length);
        double monthly_payment =  (Principal * Interest) / (1-Math.pow(1 + Interest, - Length));
        double total_interest = monthly_payment * Length - Principal;

        //Print results (formatted)
        String monthly_paymentFormatted = NumberFormat.getCurrencyInstance().format(monthly_payment);
        String total_interestFormatted = NumberFormat.getCurrencyInstance().format(total_interest);
        System.out.println("Your monthly payment is " + monthly_paymentFormatted + " and your total interest is " + total_interestFormatted + ".");
    }
    public static void CDCalculator() {
        //Prompt user for deposit, interest rate and number of years
        System.out.println("Welcome to the Certificate of Deposit Calculator\n" + "Please enter the following information:");
        System.out.print("1. How much are you going to deposit? ");
        Scanner myCalculator = new Scanner(System.in);
        double Deposit = myCalculator.nextDouble();
        System.out.print("2. What is the interest rate annually? ");
        double InterestRate = myCalculator.nextDouble() / 100;
        System.out.print("3. How many years will your CD term be? ");
        int Length = myCalculator.nextInt() * 365;
        //A = P(1+r/n)(nt)
        //
        //A is the total that your CD will be worth at the end of the term, including the amount you put in.
        //P is the principal, or the amount you deposited when you bought the CD.
        //R is the rate, or annual interest rate, expressed as a decimal. If the interest rate is 1.25% APY, r is 0.0125.
        //n is the number of times that interest in compounded every year. Most CDs pay interest that is compounded daily, so n = 365. Check with your bank to verify the interest is compounded daily.
        //t is time, or the number of years until the maturity date
        //Deposit * (1 + interestInDecimal)^years

        //Calculate future value and total interest
        double future_value = Math.pow(Deposit * (1 + InterestRate), Length);
        String future_valueFormatted = NumberFormat.getCurrencyInstance().format(future_value);
        System.out.println(future_valueFormatted);
    }
}
