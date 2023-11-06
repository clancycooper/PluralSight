package com.pluralsight;

public class SemiTruck extends Vehicle {
    private int brakingDistance, cargoLoad;

    public SemiTruck(String engineType, String color, int speed, int carrierCapacity, int fuelCapacity, int cargoCapacity, int brakingDistance, int cargoLoad) {
        super(engineType, color, speed, carrierCapacity, fuelCapacity, cargoCapacity);
        this.brakingDistance = brakingDistance;
        this.cargoLoad = cargoLoad;
    }

    public int getBrakingDistance() {
        return brakingDistance;
    }

    public void setBrakingDistance(int brakingDistance) {
        this.brakingDistance = brakingDistance;
    }

    public int getCargoLoad() {
        return cargoLoad;
    }

    public void setCargoLoad(int cargoLoad) {
        this.cargoLoad = cargoLoad;
    }
}
