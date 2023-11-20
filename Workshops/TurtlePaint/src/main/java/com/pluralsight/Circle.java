package com.pluralsight;

import java.awt.*;
import java.awt.geom.Point2D;

public class Circle extends Shape {
    private double radius;

    public Circle(Turtle turtle, Point2D.Double location, double border, Color color, double radius) {
        super(turtle, location, border, color);
        this.radius = radius;
    }

    public void paint(){
    turtle.setColor(this.color);
    turtle.setPenWidth(this.border);
    turtle.penUp();
    turtle.goTo(this.location);
    turtle.penDown();
    turtle.setDelay(.0001);

    int sides = 360;
    double angle = 360.0 / sides;
    double distance = 2 * Math.PI * radius / sides;

        for (int i = 0; i < sides; i++) {
            turtle.forward(distance);
            turtle.turnRight(angle);
        }
    }
}
