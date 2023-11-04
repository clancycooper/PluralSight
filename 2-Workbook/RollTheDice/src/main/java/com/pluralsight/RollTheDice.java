package com.pluralsight;

public class RollTheDice {
    public static void main(String[] args) {
        //create new Dice, declare first and second roll
        Dice dice = new Dice();
        int roll1;
        int roll2;

        //create ints for 2, 4, 6, 7 with value of 0, declare sum variable
        int two = 0;
        int four = 0;
        int six = 0;
        int seven = 0;
        int sum;

        //create a for loop that runs 100 times, call roll dice 2x
        for(int i = 1; i <= 100; i++) {
            roll1 = dice.roll();
            roll2 = dice.roll();
            sum = roll1 + roll2;

            //create an if statement that increments everytime the sum equals 2, 4, 6, 7
            if(sum == 2) {
                two++;
            } else if (sum == 4) {
                four++;
            } else if (sum == 6) {
                six++;
            } else if (sum == 7) {
                seven++;
            }

            //Print the sum of each roll
            System.out.println("Roll " + i + ": " + roll1 + " - " + roll2 + " Sum = " + sum + "\n");
        }
        //Print the total sum of 2's, 4's, 6's, 7's rolled
        System.out.println("Sum of 2's rolled: " + two + "\n"
                + "Sum of 4's rolled: " + four + "\n"
                + "Sum of 6's rolled: " + six + "\n"
                + "Sum of 7's rolled: " + seven);

    }
}
