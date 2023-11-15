package com.pluralsight;

import com.pluralsight.forms.Turtle;
import com.pluralsight.forms.World;

import java.awt.*;

public class MainApp
{
    public static void main(String[] args) {
        //Code for drawing a red Square
        World world = new World();
        Turtle turtle = new Turtle(world);
        turtle.setColor(Color.red);

        // Loop four times to draw each side of the square
        for (int i = 0; i < 4; i++) {
                turtle.forward(100);  // Move forward 100 pixels
                turtle.turnRight(90); // Turn right (or left) 90 degrees
            }
        }

        World world = new World();
        Turtle newTurtle = new Turtle(world);
        int sides = 100; // Number of sides to simulate a circle
        // Loop through the number of sides to draw the circle
        for(int i = 0; i < sides; i++) {
        newTurtle.forward(5);  // Move forward a small distance
        newTurtle.turnRight(360.0 / sides); // Turn slightly to the right
    }
}

        /* Commenting this out for now
        This starter code to get you familiar with how
        // the TurtleLogo application works

        // The world is your canvas
        World world = new World(200, 200);
        Turtle turtle = new Turtle(world,-100, -100);
        
        int width = 200;
        int height = 200;

        // calculate the hypotenuse (diagonal)
        // a2 + b2 = c2
        double widthSquared = Math.pow(width, 2);
        double heightSquared = Math.pow(height, 2);
        double hypotenuse = Math.sqrt(widthSquared + heightSquared);


        turtle.setPenWidth(3);
        turtle.setColor(Color.GREEN);

        turtle.turnRight(45);
        turtle.forward(hypotenuse);

        turtle.penUp();
        turtle.goTo(100, 100);
        turtle.turnRight(90);

        turtle.penDown();
        turtle.forward(hypotenuse);*/
}
