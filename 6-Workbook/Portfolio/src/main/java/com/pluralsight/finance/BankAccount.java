package com.pluralsight.finance;

import com.pluralsight.Valuable;

public class BankAccount implements Valuable {
    private String name;
    private int accountNumber;
    private double balance;

    public BankAccount(String name, int accountNumber, double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {

    }

    public void withdraw(double amount) {

    }

    @Override
    public double getValue() {
        return Valuable.super.getValue();
    }

    @Override
    public int compareTo(Valuable o) {
        return 0;
    }
}
