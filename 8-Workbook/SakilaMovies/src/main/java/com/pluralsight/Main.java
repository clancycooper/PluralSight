package com.pluralsight;
import java.sql.*;
import java.util.Scanner;
import org.apache.commons.dbcp2.BasicDataSource;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String query = "";
        String username = System.getenv("mysql_user");
        String password = System.getenv("mysql_password");

        System.out.println("Welcome to the Sakila Movie Database!\n" +
                "Please enter the Last Name of the actor you wish to view.");
        String userInput = scanner.nextLine();
        query = "SELECT first_name, last_name " +
                "FROM actor " +
                "WHERE last_name LIKE ? " +
                "ORDER BY first_name;";

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/sakila");
        dataSource.setUsername(username);
        dataSource.setPassword(password);


        try (Connection conn = dataSource.getConnection();
             PreparedStatement prepStatement = conn.prepareStatement(query)) {

            prepStatement.setString(1, "%" + userInput + "%");
            ResultSet result = prepStatement.executeQuery();


            // Processing the result set
            if (result.next()) {
                do {
                    System.out.println("First Name: " + result.getString(1));
                    System.out.println("Last Name:  " + result.getString(2));
                    System.out.println(" -------- ");
                } while (result.next());
            }
            else {
                System.out.println("No matches!");
            }

        } catch(SQLException e){
            e.printStackTrace();
        }

        System.out.println("Please enter the First Name of the actor whose filmography you'd like to view.");
        String first = scanner.nextLine();
        System.out.println("Now enter the Last Name");
        String last = scanner.nextLine();

        query = "SELECT actor.first_name, actor.last_name, film.title " +
                "FROM actor " +
                "JOIN film_actor " +
                "ON actor.actor_id = film_actor.actor_id " +
                "JOIN film " +
                "ON film_actor.film_id = film.film_id " +
                "WHERE actor.first_name LIKE ? AND actor.last_name LIKE ? " +
                "ORDER BY actor.first_name;";

        try(Connection conn = dataSource.getConnection();
            PreparedStatement prepStatement = conn.prepareStatement(query)) {

            prepStatement.setString(1, "%" + first + "%");
            prepStatement.setString(2, "%" + last + "%");
            ResultSet result = prepStatement.executeQuery();

            if (result.next()) {
                do {
                    System.out.println("First Name: " + result.getString(1));
                    System.out.println("Last Name:  " + result.getString(2));
                    System.out.println("Film Title: " + result.getString(3));
                    System.out.println(" -------- ");
                } while (result.next());
            }
            else {
                System.out.println("No matches!");
            }

        } catch(SQLException e){
            e.printStackTrace();
        }
    }
}