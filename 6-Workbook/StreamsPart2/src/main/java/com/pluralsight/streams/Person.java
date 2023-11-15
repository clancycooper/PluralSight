package com.pluralsight.streams;

import java.util.*;

public class Person implements Comparable<Person> {
    public static List<Person> myFriends = new ArrayList<>();
    private String firstName, lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void searchFriends() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the name you would like to search: ");
        String userSearch = scanner.nextLine();
        List<Person> matchedSearches = myFriends.stream().filter
                (person ->  userSearch.equalsIgnoreCase(person.getFirstName()) ||
                        userSearch.equalsIgnoreCase(person.getLastName())).toList();

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

    public static double avgAge() {
        return myFriends.stream().mapToInt(Person::getAge).average().orElse(0.0);
    }

    public static Person getOldest() {
        Optional<Person> oldestFriend = myFriends.stream().max(Comparator.comparingInt(Person::getAge));
        return oldestFriend.orElse(null);
    }

    public static Person getYoungest() {
        Optional<Person> youngestFriend = myFriends.stream().min(Comparator.comparingInt(Person::getAge));
        return youngestFriend.orElse(null);
    }

    @Override
    public int compareTo(Person otherPerson) {
        return Integer.compare(this.age, otherPerson.age);
    }


    @Override
    public String toString() {
        return "First Name: " + firstName + " " + "| " +
                "Last Name: " + lastName + " " + "| " +
                "Age: " + age;
    }
}