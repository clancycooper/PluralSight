package com.pluralsight;

import java.util.Arrays;

public class TestStatistics {
    public static void main(String[] args) {
        //Create an array with 10 test scores
        int[] testScores = {100, 98, 75, 85, 77, 65, 98, 70, 72, 100};

        //Sorting the array
        Arrays.sort(testScores);
        System.out.println("Test scores were: " + Arrays.toString(testScores));

        //Declare length and sum, Calculate the average
        double length = testScores.length;
        double sum = 0;
        for (int i = 0; i < testScores.length; i++) {
            sum += testScores[i];
        }
        //Create average
        double average = sum/length;

        //Declare max, Calculate the max
        int max = 0;
        for(int i = 1; i < testScores.length; i++){
            if(testScores[i] > max)
                max = testScores[i];
        }
        //Declare min, Calculate the min
        int min = 100;
        for(int i = 0; i < testScores.length; i++) {
            if(testScores[i] < min)
                min = testScores[i];
        }
        System.out.println("The average test score is: " + average + "\n"
                + "The max score is: " + max + "\n"
                + "The min score is: " + min);
    }
}
