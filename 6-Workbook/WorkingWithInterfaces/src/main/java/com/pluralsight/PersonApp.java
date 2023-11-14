package com.pluralsight;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PersonApp {
    public static void main(String[] args) {
        List<Person> myFamily = new ArrayList<>();
        myFamily.add(new Person("Scout", "White", 31));
        myFamily.add(new Person("Clancy", "Cooper", 29));
        myFamily.add(new Person("Banjomin", "Joseph", 2));
        myFamily.add(new Person("Contra", "White", 10));
        myFamily.add(new Person("Richard", "White", 50));
        myFamily.add(new Person("Maggie", "Erb", 26));

        // Sort by last name using a custom comparator
        Collections.sort(myFamily, Comparator.comparing(Person::getLastName).thenComparing(Person::getFirstName).thenComparingInt(Person::getAge));
        System.out.println("My Family \n");

        // Print the sorted list
        for (Person person : myFamily) {
            System.out.println(person);
        }
    }
}
