package com.pluralsight;

public class Vehicle {
    protected String engineType, color;
    protected int speed, carrierCapacity, fuelCapacity, cargoCapacity;

    public Vehicle(String engineType, String color, int speed, int carrierCapacity, int fuelCapacity, int cargoCapacity) {
        this.engineType = engineType;
        this.color = color;
        this.speed = speed;
        this.carrierCapacity = carrierCapacity;
        this.fuelCapacity = fuelCapacity;
        this.cargoCapacity = cargoCapacity;
    }


    public String getEngineType() {
        return engineType;
    }

    public String getColor() {
        return color;
    }

    public int getSpeed() {
        return speed;
    }

    public int getCarrierCapacity() {
        return carrierCapacity;
    }

    public int getFuelCapacity() {
        return fuelCapacity;
    }

    public int getCargoCapacity() {
        return cargoCapacity;
    }

    public void refuel() {
    }

    public void accelerate() {
    }

    public void brake() {
    }
}
