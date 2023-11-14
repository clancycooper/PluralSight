package com.pluralsight.finance;

import com.pluralsight.*;

public class FinanceApplication {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("Pam", 123, 12500);
        BankAccount account2 = new BankAccount("Gary", 456, 1500);

        account1.deposit(100);
        account2.deposit(100);

        //had to change Valuable type to Bank Account, had to change accountNumber to int
        //Methods available: get/sets for balance, account number and name, withdraw and getValue.

        Portfolio myPortfolio = new Portfolio("My Portfolio", "Clancy Long");

        // Adding assets to the portfolio
        myPortfolio.add(new House("Clancy's House", 300000, 1994, 6000, 5));
        myPortfolio.add(new Gold("Clancy's Gold", 50000, 24.0));
        myPortfolio.add(new Jewelry("Clancy's Watch", 10000, 18));

        // Getting the total value, min value and max value of the portfolio
        double totalValue = myPortfolio.getValue();
        Valuable mostValue = myPortfolio.getMostValuable();
        Valuable leastValue = myPortfolio.getLeastValuable();
        System.out.println("Total value of Clancy's portfolio: " + totalValue +
                "\nClancy's Most Valuable Asset: " + mostValue.getValue() +
                "\nClancy's Least Valuable Asset: " + leastValue.getValue());
    }
}
