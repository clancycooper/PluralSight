package com.pluralsight;

import java.util.Scanner;

public class FullNameParser {
    Scanner enterName = new Scanner(System.in);
    public static void main(String[] args) {
        Scanner enterName = new Scanner(System.in);
        System.out.print("Enter your first name: ");
        String firstName = enterName.nextLine();
        System.out.print("Enter your middle name: ");
        String middleName = enterName.nextLine();
        System.out.print("Enter your last name: ");
        String lastName = enterName.nextLine();

        String firstNameTrim = firstName.trim();
        if(firstNameTrim.isEmpty()) {
            System.out.println("First name: None");
        } else {
            System.out.println("First name: " + firstNameTrim);
        }
        String middleNameTrim = middleName.trim();
        if(middleNameTrim.isEmpty()) {
            System.out.println("Middle name: None");
        } else {
            System.out.println("Middle name: " + middleNameTrim);
        }
        String lastNameTrim = lastName.trim();
        if(lastNameTrim.isEmpty()) {
            System.out.println("Last name: None");
        } else {
            System.out.println("Last name: " + lastNameTrim);
        }
    }
}
