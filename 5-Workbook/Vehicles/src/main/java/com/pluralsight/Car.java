package com.pluralsight;

public class Car extends Vehicle {
    private String make;
    private String model;
    private String carType;

    public Car(String engineType, String color, int speed, int carrierCapacity, int fuelCapacity, int cargoCapacity, String make, String model, String carType) {
        super(engineType, color, speed, carrierCapacity, fuelCapacity, cargoCapacity);
        this.make = make;
        this.model = model;
        this.carType = carType;
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

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }
}
