package com.pluralsight;

public class Vehicle {
    private String engineType, color;
    private int speed, carrierCapacity, fuelCapacity, cargoCapacity;

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

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getCarrierCapacity() {
        return carrierCapacity;
    }

    public void setCarrierCapacity(int carrierCapacity) {
        this.carrierCapacity = carrierCapacity;
    }

    public int getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(int fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public int getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(int cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    public void refuel() {

    }

    public void accelerate() {

    }

    public void brake() {

    }
}
