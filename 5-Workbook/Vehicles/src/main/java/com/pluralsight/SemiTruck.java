package com.pluralsight;

public class SemiTruck extends Vehicle {
    private int brakingDistance, cargoLoad;

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
