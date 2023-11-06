package com.pluralsight;

public class Moped extends Vehicle {
private String make;
private String model;

    public Moped(String engineType, String color, int speed, int carrierCapacity, int fuelCapacity, int cargoCapacity, String make, String model) {
        super(engineType, color, speed, carrierCapacity, fuelCapacity, cargoCapacity);
        this.make = make;
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
