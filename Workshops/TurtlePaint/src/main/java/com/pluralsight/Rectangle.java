package com.pluralsight;

import java.awt.*;
import java.awt.geom.Point2D;

public class Rectangle extends Shape {
    private double length, width;

    public Rectangle(Turtle turtle, Point2D.Double location, double border, Color color, double length, double width) {
        super(turtle, location, border, color);
        this.length = length;
        this.width = width;
    }

    public void paint() {
        turtle.setColor(this.color);
        turtle.setPenWidth(this.border);
        turtle.penUp();
        turtle.goTo(this.location);
        turtle.penDown();

        for (int i = 0; i < 2; i++) {
            turtle.forward(length);
            turtle.turnRight(90);
            turtle.forward(width);
            turtle.turnRight(90);
        }
    }
}
