package com.pluralsight;

public class Dice {
    int dice;

    public Dice() {
        dice = 0;
    }
    //create new method for Roll, set roll algo, return roll
    public int roll(){
        return 1 + (int)(Math.random() * 6);
    }
}
