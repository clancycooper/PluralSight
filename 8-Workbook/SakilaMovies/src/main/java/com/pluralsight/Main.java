package com.pluralsight;

import java.util.List;
import java.util.Scanner;
import org.apache.commons.dbcp2.BasicDataSource;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Welcome to the Sakila Movie Database!\n" +
                "Please enter the First Name of the actor you wish to search for");
        String firstName = scanner.nextLine();
        System.out.println("Please enter the Last Name of the actor you wish to search for");
        String lastName = scanner.nextLine();

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/sakila");
        dataSource.setUsername(args[0]);
        dataSource.setPassword(args[1]);

        DataManagerActor actorManager = new DataManagerActor(dataSource);

        List<Actor> actors = actorManager.searchActorsByName(firstName, lastName);

        for (Actor actor : actors) {
            System.out.println("First Name: " + actor.getFirstName());
            System.out.println("Last Name:  " + actor.getLastName());
            System.out.println("Actor ID:   " + actor.getActorID());
            System.out.println("--------");
        }

        System.out.println("Please enter the Actor ID of the actor whose filmography you'd like to view.");
        int actorID = scanner.nextInt();
        scanner.nextLine();

        List<Film> filmography = actorManager.searchFilmographyByID(actorID);

        for (Film film : filmography) {
            System.out.println("Film ID:        " + film.getFilmID());
            System.out.println("First Name:     " + film.getFirstName());
            System.out.println("Last Name:      " + film.getLastName());
            System.out.println("Film Title:     " + film.getFilmTitle());
            System.out.println("Description:    " + film.getDescription());
            System.out.println("Release Year:   " + film.getReleaseYear());
            System.out.println("Runtime:        " + film.getLength());
            System.out.println("--------");
        }
    }
}