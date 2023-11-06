package com.pluralsight;

public class Hovercraft extends Vehicle {
    private String waterResistance;

    public String getWaterResistance() {
        return waterResistance;
    }

    public Hovercraft(String engineType, String color, int speed, int carrierCapacity, int fuelCapacity, int cargoCapacity, String waterResistance) {
        super(engineType, color, speed, carrierCapacity, fuelCapacity, cargoCapacity);
        this.waterResistance = waterResistance;
    }

    public void setWaterResistance(String waterResistance) {
        this.waterResistance = waterResistance;
    }

    public void isFloat() {

    }
}
