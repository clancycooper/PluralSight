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
        System.out.println("""
                Welcome to Clancy's Paint-By-Turtle App!
                What would you like to do first?
                A) Add Shape
                S) Save Shape
                X) Exit Program""");
        String menuSwap = scanner.nextLine().toUpperCase();

        switch (menuSwap) {
            case "A":
                addShape();
                break;
            case "S":
                saveShape();
                break;
            case "X":
                System.exit(0);
                break;
            default:
                System.out.println("Sorry, didn't catch that.");
                homeScreen();
                break;
        }
    }

        public static void addShape() {
            System.out.println("""
                    Which shape would you like to paint?
                    C) Circle
                    S) Square
                    R) Rectangle
                    X) Return to Main Menu""");
            String userChoice = scanner.nextLine().toUpperCase();

            switch (userChoice) {
                case "C":
                    System.out.println("What is the radius of the circle you'd like the turtle to draw?");
                    double radius = scanner.nextDouble();
                    System.out.println("How thick would you like the border width to be?" + "\n (ex: 2)");
                    int border = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("What color would you like the border of your circle to be?");
                    String tempColor = scanner.nextLine();
                    System.out.println("Where would you like your circle to be?\n" + " Enter x-coordinate:");
                    double xCoordinate = scanner.nextDouble();
                    System.out.println(" Enter y-coordinate:");
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

                case "S" :
                    System.out.println("How thick would you like the border width to be?" + "\n (ex: 2)");
                    int sqBorder = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("What color would you like the border of your square to be?");
                    String tempSqColor = scanner.nextLine();
                    System.out.println("Where would you like your square to be?\n" + " Enter the x-coordinate:");
                    double xSqCoordinate = scanner.nextDouble();
                    System.out.println(" Enter the y-coordinate:");
                    double ySqCoordinate = scanner.nextDouble();
                    scanner.nextLine();
                    Point2D.Double sqLocation = new Point2D.Double(xSqCoordinate, ySqCoordinate);
                    Color sqColor = parseColor(tempSqColor);

                    World sqWorld = new World();
                    Turtle sqTurtle = new Turtle(sqWorld);
                    Square square = new Square(sqTurtle, sqLocation, sqBorder, sqColor);
                    System.out.println("Here comes your turtle painter!");
                    square.paint();
                    homeScreen();
                    break;
            }
        }

        public static void saveShape() {

        }
}