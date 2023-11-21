package com.pluralsight;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.Scanner;

import static com.pluralsight.Shape.parseColor;


public class MainApp {
    public static Scanner scanner = new Scanner(System.in);
    public static World world;
    public static Turtle turtle;
    public static Point2D.Double location;
    public static int border;
    public static Color color;
    public static double xCoordinate, yCoordinate, radius, length, width;
    public static String tempColor;

    public static void main(String[] args) {
        System.out.println("Please enter the size of your canvas\n" +
                "Width: ");
        int width = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Height: ");
        int height = scanner.nextInt();
        scanner.nextLine();
        world = new World(width, height);
        turtle = new Turtle(world);

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
                radius = scanner.nextDouble();
                System.out.println("How thick would you like the border width to be?" + "\n (ex: 2)");
                border = scanner.nextInt();
                scanner.nextLine();
                System.out.println("What color would you like the border of your circle to be?\n" + "(Choose between: red, blue, green, magenta and cyan)");
                tempColor = scanner.nextLine();
                System.out.println("Where would you like your circle to be?\n" + " Enter x-coordinate:");
                xCoordinate = scanner.nextDouble();
                System.out.println(" Enter y-coordinate:");
                yCoordinate = scanner.nextDouble();
                scanner.nextLine();
                location = new Point2D.Double(xCoordinate, yCoordinate);
                color = parseColor(tempColor.toLowerCase());


                Circle circle = new Circle(turtle, location, border, color, radius);
                System.out.println("Here comes your turtle painter!");
                circle.paint();
                homeScreen();
                break;

            case "S" :
                System.out.println("How thick would you like the border width to be?" + "\n (ex: 2)");
                border = scanner.nextInt();
                scanner.nextLine();
                System.out.println("What color would you like the border of your square to be?");
                tempColor = scanner.nextLine();
                System.out.println("Where would you like your square to be?\n" + " Enter the x-coordinate:");
                xCoordinate = scanner.nextDouble();
                System.out.println(" Enter the y-coordinate:");
                yCoordinate = scanner.nextDouble();
                scanner.nextLine();
                location = new Point2D.Double(xCoordinate, yCoordinate);
                color = parseColor(tempColor);


                Square square = new Square(turtle, location, border, color);
                System.out.println("Here comes your turtle painter!");
                square.paint();
                homeScreen();
                break;

            case "R" :
                System.out.println("How thick would you like the border width to be?" + "\n (ex: 2)");
                border = scanner.nextInt();
                scanner.nextLine();
                System.out.println("What color would you like the border of your rectangle to be?");
                tempColor = scanner.nextLine();
                System.out.println("Where would you like your rectangle to be?\n" + " Enter the x-coordinate:");
                xCoordinate = scanner.nextDouble();
                System.out.println(" Enter the y-coordinate:");
                yCoordinate = scanner.nextDouble();
                scanner.nextLine();
                System.out.println("How long should your rectangle be?");
                length = scanner.nextDouble();
                System.out.println("How wide should your rectangle be?");
                width = scanner.nextDouble();
                scanner.nextLine();
                location = new Point2D.Double(xCoordinate, yCoordinate);
                color = parseColor(tempColor);


                Rectangle rectangle = new Rectangle(turtle, location, border, color, length, width);
                System.out.println("Here comes your turtle painter!");
                rectangle.paint();
                homeScreen();

        }
    }

    public static void saveShape() {

    }
}