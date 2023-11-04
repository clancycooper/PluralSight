package com.pluralsight;

import java.util.Scanner;

public class FullNameGenerator {
    public static void main(String[] args) {
        Scanner enterName = new Scanner(System.in);
        System.out.print("Enter your full name\n" + "First Name: ");
        String firstName = enterName.nextLine();
        System.out.print("Middle Name: ");
        String middleName = enterName.nextLine();
        System.out.print("Last Name: ");
        String lastName = enterName.nextLine();
        System.out.print("Suffix: ");
        String suffixName = enterName.nextLine();

        String fullName = (firstName + " " + middleName + " " + lastName + " " + suffixName + " ");
        fullName = fullName.trim();
        System.out.println(fullName);

    }
}
