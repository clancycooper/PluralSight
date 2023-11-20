package com.pluralsight;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.Scanner;

import static com.pluralsight.Shape.parseColor;


public class MainApp {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
      homeScreen();
    }

    public static void homeScreen() {
        System.out.println("Welcome to Clancy's Paint-By-Turtle App!\n" +
                "What would you like to do first?\n" +
                "A) Add Shape\n" +
                "S) Save Shape\n" +
                "X) Exit Program");
        String menuSwap = scanner.nextLine().toUpperCase();

        switch (menuSwap) {
            case "A":
                addShape();
            case "S":
                saveShape();
            case "X":
                System.exit(0);
        }
    }


        public static void addShape() {
            System.out.println("Which shape would you like to paint?\n" +
                    "C) Circle\n" +
                    "S) Square\n" +
                    "R) Rectangle\n" +
                    "X) Return to Main Menu");
            String userChoice = scanner.nextLine();

            switch (userChoice) {
                case "C":
                    System.out.println("What is the radius of the circle you'd like the turtle to draw?");
                    double radius = scanner.nextDouble();
                    System.out.println("How thick would you like the border width to be?" + "\n (ex: 2)");
                    int border = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("What color would you like the border of your circle to be?");
                    String tempColor = scanner.nextLine();
                    System.out.println("Enter x-coordinate:");
                    double xCoordinate = scanner.nextDouble();
                    System.out.println("Enter y-coordinate:");
                    double yCoordinate = scanner.nextDouble();
                    scanner.nextLine();
                    Point2D.Double location = new Point2D.Double(xCoordinate, yCoordinate);
                    Color color = parseColor(tempColor.toLowerCase());

                    World world = new World();
                    Turtle turtle = new Turtle(world);
                    Circle circle = new Circle(turtle, location, border, color, radius);
                    System.out.println("Here comes your turtle painter!");
                    circle.paint();
                    homeScreen();
                    break;
            }
        }

        public static void saveShape() {

        }
}