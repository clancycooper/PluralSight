package org.example;

import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);
    public static String name;
    public static void main(String[] args) {
        System.out.println("Please enter your name:");
        name = scanner.nextLine();
        System.out.println("Hello " + name + "!");
    }
}