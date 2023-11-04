package com.pluralsight;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TheaterReservations {
    public static void main(String[] args) {
        Scanner theaterReservations = new Scanner(System.in);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("M/d/yyyy");

        System.out.print("Enter the name of your reservation (FirstName LastName): ");
        String reservationName = theaterReservations.nextLine();
        reservationName = reservationName.trim();
        System.out.print("Enter the date of your showing (MM/DD/YYYY): ");
        String reservationDate = theaterReservations.nextLine();
        reservationDate = reservationDate.trim();
        System.out.print("How many tickets would you like to reserve for this showing? ");
        int ticketQuantity = Integer.parseInt(theaterReservations.nextLine());

        String[] reservationNames = reservationName.split("\\ ");
        LocalDate reservationDates = LocalDate.parse(reservationDate, format);

        if(ticketQuantity > 1) {
            System.out.println("Your tickets for " + reservationNames[1] + ", " + reservationNames[0] + " have been reserved for " + reservationDates + " in the amount of " + ticketQuantity + " tickets.");
        } else {
            System.out.println("Your ticket for " + reservationNames[1] + ", " + reservationNames[0] + " has been reserved for " + reservationDates + " in the amount of " + ticketQuantity + " ticket.");
        }
    }
}
