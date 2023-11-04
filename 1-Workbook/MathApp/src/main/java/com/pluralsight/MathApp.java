package com.pluralsight;

public class MathApp {
    public static void main(String[] args) {


        // Question 1:
        // declaring Bob, Gary and highest salaries
        double bobSalary = 45000.00;
        double garySalary = 65000.00;
        double highestSalary = Math.max(bobSalary, garySalary);
        // printing the highest salary
        System.out.println("The highest salary is... " + highestSalary);

        //Question 2:
        //declaring variables carPrice, truckPrice and lowestPrice
        double carPrice = 350000.00;
        double truckPrice = 555000.00;
        double lowestPrice = Math.min(carPrice, truckPrice);
        //printing the lowest price
        System.out.println("The lowest vehicle price is... " + lowestPrice);

        //Question 3:
        //declaring variables radius and area
        double radius = 7.25;
        double area = Math.pow(radius, 2) * Math.PI;
        //printing the area
        System.out.println("The surface area of a circle with a radius of 7.25 is... " + area);

        //Question 4:
        // declaring variable five
        double five = 5.0;
        double square_root = Math.sqrt(five);
        //printing the square root of five
        System.out.println("The square root of five is... " + square_root);

        //Question 5:
        //
        double x1 = 5;
        double y1 = 10;
        double x2 = 85;
        double y2 = 50;
        double distance = Math.sqrt(Math.pow(x2 - x1, 2)) + (Math.pow(y2 - y1, 2));
        //Print solution
        System.out.println("The distance between (5,10) and (85,50) is... " + distance);
    }

}
