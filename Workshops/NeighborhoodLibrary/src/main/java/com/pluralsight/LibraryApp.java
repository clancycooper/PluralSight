package com.pluralsight;

import java.util.Scanner;

public class LibraryApp {
    //Just some variables to cut down on repeated phrases + class scanner
    public static Scanner library = new Scanner(System.in);
    public static String defaultMessage = "Sorry, didn't catch that. Try entering a number.";
    public static String welcomeMessage = "Welcome to Clancy's Fancy Pages, a neighborhood library.\n";
    public static String selectScreen = "Please select where you would like to go: \n Type 1: Show Available Books\n Type 2: Show Checked Out Books\n Type 3: Exit this program";
    public static String thankYou = "\nThanks for choosing Clancy's Fancy Pages! Have a great day! :)";
    public static String returnStore =  " Type 1: Return to Store \n Type 2: To exit the library";

    public static void main(String[] args) {
        //Main method leads to Store
        Store();
    }
    public static void Store() {
        //Store holds library, welcome message, and user screen select
        //Library
        Book[] book = new Book[20];
        book[0] = new Book(1, "100-00-000", "To Kill a Mockingbird", "Scout", true);
        book[1] = new Book(2, "200-00-000", "Fiddler on the Roof", "", false);
        book[2] = new Book(3, "300-00-000", "Lord of the Rings", "Jake", true);
        book[3] = new Book(4, "400-00-000", "The Holy Bible", "", false);
        book[4] = new Book(5, "500-00-000", "Twilight", "Maggie", true);
        book[5] = new Book(6, "600-00-000", "Alice in Wonderland", "Andi", true);
        book[6] = new Book(7, "700-00-00", "Bear Attacks: The Deadly Truth", "", false);
        book[7] = new Book(8, "800-00-000", "Watchmen", "Randy", true);
        book[8] = new Book(9, "900-00-000", "Hip-Hop Revolution: The Culture and Politics of Rap", "Christian", true);
        book[9] = new Book(10, "100-10-000", "The Cat in the Hat", "", false);
        book[10] = new Book(11, "110-11-000", "Mastering the Art of Soviet Cooking: A Memoir of Food and Longing", "Aleksandr", true);
        book[11] = new Book(12, "120-12-000", "Where the Sidewalk Ends", "", false);
        book[12] = new Book(13, "130-13-000", "The Creative Act: A Way of Being", "Erik", true);
        book[13] = new Book(14, "140-14-000", "The Self Taught Programmer", "Ivan", true);
        book[14] = new Book(15, "150-15-000", "Half of a Yellow Sun", "Abigiel", true);
        book[15] = new Book(16, "160-16-000", "The Boy Who Harnessed the Wind", "Paul", true);
        book[16] = new Book(17, "170-17-000", "Perks of Being a Wallflower", "", false);
        book[17] = new Book(18, "180-00-000", "Harry Potter and the Prisoner of Azkaban", "", false);
        book[18] = new Book(19, "190-19-000", "The Answer Is . . .: Reflections on My Life", "Richard", true);
        book[19] = new Book(20, "200-20-000", "A Man & His Watch: Iconic Watches and Stories from the Men Who Wore Them", "Joshua", true);
        //Select Screen and Welcome Message
        System.out.println(welcomeMessage + selectScreen);
        int userScreen = library.nextInt();
        //Send user to next Screen
        switch (userScreen) {
            case 1 -> AvailableBooks(book);
            case 2 -> CheckedOutBooks(book);
            case 3 -> System.exit(0);
            default -> System.out.println(defaultMessage);
        }
    }

    public static void AvailableBooks(Book[] book) {
        //AvailableBooks screen
        System.out.println(" Here is a current list of the books we have available:");
        for (Book item : book) {
            if (!item.getIsCheckedOut()) {
                System.out.println(item.toStringAvailable());
            }
        }
        //Allow user to check out an available book or return to store
        String userMenu = "\n Type 1: Check out an Available Book\n Type 2: Back to Store\n";
        System.out.println(userMenu);
        int userChoice = library.nextInt();
        library.nextLine();
        switch (userChoice) {
            //User chooses to check out
            case 1 -> {
                System.out.println("Your name: ");
                String userName = library.nextLine();
                System.out.println("The ID of the book you would like to reserve: ");
                int bookId = library.nextInt();
                for (Book value : book) {
                    if (value.getId() == bookId) {
                        value.checkOut(userName);
                        System.out.println("\nConfirmed! " + userName + " checked out " + value.getTitle() + "!");
                    }
                }
            }
            //User chooses to return to store
            case 2 -> Store();
            default -> System.out.println(defaultMessage);
        }
        //Thank you message and exit screens
        System.out.println(thankYou);
        System.out.println(returnStore);
        int userScreen = library.nextInt();
        switch (userScreen) {
            case 1 -> Store();
            case 2 -> System.exit(0);
            default -> System.out.println(defaultMessage);
        }
    }

    //Create CheckedOutBooks screen
    public static void CheckedOutBooks (Book[]book){
        String newList = " Here are the books that are currently checked out:";
        System.out.println(newList);
        for (Book value : book) {
            if (value.getIsCheckedOut()) {
                System.out.println(value.toStringAvailable() + " -" + value.getCheckedOutTo());
            }
        }
        //Allow user to check in a checked out book or return to store
        String userMenu = "\n Type 1: Return a book \n Type 2: Back to Store";
        System.out.println(userMenu);
        int userChoice = library.nextInt();
        library.nextLine();
        switch (userChoice) {
            //User chooses to return book
            case 1 -> {
                System.out.println("The ID of the book you would like to return: ");
                int bookId = library.nextInt();
                for (Book value : book) {
                    if (value.getId() == bookId) {
                        value.checkIn();
                        System.out.println("\nConfirmed! You returned " + value.getTitle() + "!");
                    }
                }
            }
            //User chooses to return
            case 2 -> Store();
            default -> System.out.println(defaultMessage);
        }
        //Thank you message and exit screens
        System.out.println(thankYou);
        System.out.println(returnStore);
        int returnHome = library.nextInt();
        switch (returnHome) {
            case 1 -> Store();
            case 2 -> System.exit(0);
            default -> System.out.println(defaultMessage);
        }
    }
}
