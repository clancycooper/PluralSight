package com.pluralsight.streams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    public static double avgAge() {
        if (myFriends.isEmpty()) {
            return 0;
        }

        double sum = 0;
        for (Person friend : myFriends) {
            sum += friend.getAge();
        }
        return sum / myFriends.size();
    }

    public static Person getOldest() {
        if (myFriends.isEmpty()) {
            return null;
        }
        return Collections.max(myFriends);
    }

    public static Person getYoungest() {
        if (myFriends.isEmpty()) {
            return null;
        }
        return Collections.min(myFriends);
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
