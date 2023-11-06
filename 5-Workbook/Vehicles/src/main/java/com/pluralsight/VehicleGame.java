package com.pluralsight;

public class VehicleGame {
    public static void main(String[] args) {
        //String engineType, String color, int speed, int carrierCapacity, int fuelCapacity, int cargoCapacity, String make, String model
        Moped myMoped = new Moped("gas powered", "Red", 80, 2, 7, 0, "Vespa", null);
        System.out.println("My moped has a " + myMoped.getEngineType() + " engine in " + myMoped.getColor() + " and goes up to " + myMoped.getSpeed() + "mph.");

        //String engineType, String color, int speed, int carrierCapacity, int fuelCapacity, int cargoCapacity, String make, String model, String carType
        Car myCar = new Car("gas powered", "Black", 112, 5, 10, 0, "Toyota", "Pruis", "hybrid");
        System.out.println("My car is a " + myCar.getCarType() + " " + myCar.getMake() + " " + myCar.getModel() + " in " + myCar.getColor() + " and goes up to " + myCar.getSpeed() + "mph.");

        //String engineType, String color, int speed, int carrierCapacity, int fuelCapacity, int cargoCapacity, int brakingDistance, int cargoLoad
        SemiTruck mySemi = new SemiTruck("diesel powered", "Yellow", 80, 3, 120, 500, 700, 0);
        System.out.println("My semi is a " + mySemi.getColor() + " " + mySemi.getEngineType() + " truck and can go up to " + mySemi.getSpeed() + "mph. It can hold " + mySemi.getFuelCapacity() + " gallons of fuel.");

        //String engineType, String color, int speed, int carrierCapacity, int fuelCapacity, int cargoCapacity, String waterResistance
        Hovercraft myHoverCraft = new Hovercraft("gas powered", "Blue", 35, 4, 10, 0, "high");
        System.out.println("My hovercraft is " + myHoverCraft.getColor() + " with a " + myHoverCraft.getEngineType() + " engine and it can go up to " + myHoverCraft.getSpeed() + "mph and has " + myHoverCraft.getWaterResistance() + " water resistance." );

        //String engineType, String color, int speed, int carrierCapacity, int fuelCapacity, int cargoCapacity, boolean fly
        UFO myUFO = new UFO("alien powered", "chrome", 5000, 2, 60000, 0, true);
        System.out.println("My UFO is " + myUFO.getEngineType() + " in " + myUFO.getColor() + " and goes " + myUFO.getSpeed() + "mph. It has " + myUFO.getFuelCapacity() + " gallons of fuel, but can it fly? " + myUFO.isFly());
    }
}
