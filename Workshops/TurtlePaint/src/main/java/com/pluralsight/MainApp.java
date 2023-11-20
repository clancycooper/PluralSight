package com.pluralsight;

import java.awt.geom.Point2D;

import static com.pluralsight.Turtle.drawSquare;
import static java.awt.Color.red;

public class MainApp
{
    public static void main(String[] args) {
        World world = new World();
        Turtle turtle = new Turtle(world);
        Circle myCircle = new Circle(turtle, new Point2D.Double(100,100), 6, red, 130);
        myCircle.paint();
    }
}