package com.pluralsight;

public class VehicleGame {
    public static void main(String[] args) {
        Moped myMoped = new Moped();
        myMoped.setModel("Vespa");
        myMoped.setColor("Red");
        myMoped.setCarrierCapacity(2);
        System.out.println("My moped is a " + myMoped.getModel() + " in " + myMoped.getColor() + " and seats " + myMoped.getCarrierCapacity());

        Car myCar = new Car();
        myCar.setModel("Prius");
        myCar.setColor("Black");
        myCar.setCarrierCapacity(5);
        System.out.println("My car is a " + myCar.getModel() + " in " + myCar.getColor() + " and seats " + myCar.getCarrierCapacity());

        SemiTruck mySemi = new SemiTruck();
        mySemi.setBrakingDistance(700);
        mySemi.setCargoLoad(10);
        mySemi.setColor("Yellow");
        System.out.println("My semi can brake in " + mySemi.getBrakingDistance() + " feet." + " It can hold " + mySemi.getCargoLoad() + " tons and is " + mySemi.getColor());

        Hovercraft myHoverCraft = new Hovercraft();
        myHoverCraft.setSpeed(85);
        myHoverCraft.setCarrierCapacity(2);
        myHoverCraft.setWaterResistance("High");
        System.out.println("My hovercraft can go " + myHoverCraft.getSpeed() + " miles per hour and seats " + myHoverCraft.getCarrierCapacity() + ". It has " + myHoverCraft.getWaterResistance() + " water resistance.");

        UFO myUFO = new UFO();
        myUFO.setSpeed(5000);
        myUFO.setFly(true);
        myUFO.setCarrierCapacity(2);
        System.out.println("My UFO can travel " + myUFO.getSpeed() + " miles per hour and seats " + myUFO.getCarrierCapacity() + ". But does it fly? " + myUFO.isFly());
    }
}
