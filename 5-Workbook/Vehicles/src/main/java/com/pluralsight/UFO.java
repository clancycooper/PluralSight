package com.pluralsight;

public class UFO extends Vehicle {
     private boolean fly;

    public UFO(String engineType, String color, int speed, int carrierCapacity, int fuelCapacity, int cargoCapacity, boolean fly) {
        super(engineType, color, speed, carrierCapacity, fuelCapacity, cargoCapacity);
        this.fly = fly;
    }

    public boolean isFly() {
        return fly;
    }

    public void setFly(boolean fly) {
        this.fly = fly;
    }
}
