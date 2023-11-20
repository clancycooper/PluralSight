package com.pluralsight;
import com.pluralsight.Turtle.*;

import java.awt.*;
import java.awt.geom.Point2D;

public abstract class Shape {
    protected Turtle turtle;
    protected Point2D.Double location;
    protected double border;
    protected Color color;

    public Shape(Turtle turtle, Point2D.Double location, double border, Color color) {
        this.turtle = turtle;
        this.location = location;
        this.border = border;
        this.color = color;
    }

    public Turtle getTurtle() {
        return turtle;
    }

    public void setTurtle(Turtle turtle) {
        this.turtle = turtle;
    }

    public Point2D.Double getLocation() {
        return location;
    }

    public void setLocation(Point2D.Double location) {
        this.location = location;
    }

    public double getBorder() {
        return border;
    }

    public void setBorder(double border) {
        this.border = border;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract void paint();

}
