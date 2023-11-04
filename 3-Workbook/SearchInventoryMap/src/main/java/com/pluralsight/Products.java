package com.pluralsight;

public class Products {
    private int id =0;
    private String name = "";
    private float price = 0.00F;

    public Products(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

}
