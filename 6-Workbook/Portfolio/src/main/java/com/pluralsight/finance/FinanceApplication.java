package com.pluralsight.finance;

import com.pluralsight.Valuable;

public class FinanceApplication {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("Pam", 123,12500);
        BankAccount account2 = new BankAccount("Gary", 456,1500);

        account1.deposit(100);
        account2.deposit(100);

        //had to change Valuable type to Bank Account, had to change accountNumber to int
        //Methods available: get/sets for balance, account number and name, withdraw and getValue.
    }
}
