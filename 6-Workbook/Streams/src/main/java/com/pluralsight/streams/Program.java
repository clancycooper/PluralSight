package com.pluralsight.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.pluralsight.streams.Person.*;

public class Program {

    public static void main(String[] args) {

        myFriends.add(new Person("Andi", "Burke", 26));
        myFriends.add(new Person("Scout", "White", 31));
        myFriends.add(new Person("Maggie", "Erb", 26));
        myFriends.add(new Person("Corey", "Erb", 32));
        myFriends.add(new Person("Anna", "West", 25));
        myFriends.add(new Person("Tim", "West", 27));

        System.out.println("The average age of my friends is: " + avgAge());
        System.out.println("The oldest of my friends is: " + getOldest());
        System.out.println("The youngest of my friends is: " + getYoungest());
        searchFriends();

    }

    public static void searchFriends() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the name you would like to search: ");
        String userSearch = scanner.nextLine();
        List<Person> matchedSearches = new ArrayList<>();

        for (Person person : myFriends) {
            if (userSearch.equalsIgnoreCase(person.getFirstName()) || userSearch.equalsIgnoreCase(person.getLastName())) {
                matchedSearches.add(person);
            }
        }
        if (matchedSearches.isEmpty()) {
            System.out.println("No matching friends found.");
        } else {
            System.out.println("Matched searches: ");
            for (Person person : matchedSearches) {
                System.out.println(person);
            }
        }
        System.out.println("Would you like to perform another search? Y/N");
        String userChoice = scanner.nextLine();
        if (userChoice.equalsIgnoreCase("Y")) {
            searchFriends();
        } else {
            System.out.println("End of search.");
        }
    }


}
