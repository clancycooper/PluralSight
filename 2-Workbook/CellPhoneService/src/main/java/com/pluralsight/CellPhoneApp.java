package com.pluralsight;

import java.util.Scanner;

public class CellPhoneApp {
    public static void main(String[] args) {
        CellPhone cellPhone = new CellPhone();
        Scanner userCell = new Scanner(System.in);

        System.out.print("What is the serial number? ");
        cellPhone.setSerialNum(userCell.nextInt());
        userCell.nextLine();
        System.out.print("What model is the phone? ");
        cellPhone.setModel(userCell.nextLine());
        System.out.print("Who is the carrier? ");
        cellPhone.setCarrier(userCell.nextLine());
        System.out.print("What is the phone number? ");
        cellPhone.setPhoneNum(userCell.nextLine());
        System.out.print("Who is the owner of the phone? ");
        cellPhone.setOwner(userCell.nextLine());

        CellPhone cellPhone1 = new CellPhone();
        public static void display(CellPhone cellPhone1) {

        }

        System.out.println("\nSerial Number: " + cellPhone.getSerialNum());
        System.out.println("Model: " + cellPhone.getModel());
        System.out.println("Carrier: " + cellPhone.getCarrier());
        System.out.println("Phone Number: " + cellPhone.getPhoneNum());
        System.out.println("Owner Name: " + cellPhone.getOwner());

    }
}
