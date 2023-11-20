package com.pluralsight;

import java.awt.*;
import java.awt.geom.Point2D;

public class Square extends Shape {

    public Square(Turtle turtle, Point2D.Double location, double border, Color color) {
        super(turtle, location, border, color);
    }

    public void paint(){
        turtle.setColor(this.color);
        turtle.setPenWidth(this.border);
        turtle.penUp();
        turtle.goTo(this.location);
        turtle.penDown();
        turtle.setDelay(1);

        for (int i = 0; i < 4; i++) {
            turtle.forward(200);
            turtle.turnRight(90);
        }
    }
}
