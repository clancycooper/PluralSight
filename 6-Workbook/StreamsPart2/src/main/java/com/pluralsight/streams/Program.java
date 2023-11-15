package com.pluralsight.streams;

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
}