package com.pluralsight;

import java.util.Scanner;

public class FamousQuotes {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        try {
            String[] quotes = new String[11];
            quotes[0] = "Q0: Don't be fatuous, Jeffrey.";
            quotes[1] = "Q1: That rug really tied the room together.";
            quotes[2] = "Q2: I'm the Dude. So that's what you call me. You know, that or, uh, His Dudeness, or uh, Duder, or El Duderino if you're not into the whole brevity thing.";
            quotes[3] = "Q3: I mean, say what you want about the tenets of National Socialism, Dude, at least it's an ethos.";
            quotes[4] = "Q4: Yeah, well - the Dude abides.";
            quotes[5] = "Q5: Obviously you're not a golfer.";
            quotes[6] = "Q6: Yeah, well, you know, that's just like, uh, your opinion, man.";
            quotes[7] = "Q7: Is this a... what day is this?";
            quotes[8] = "Q8: I am the walrus.";
            quotes[9] = "Q9: Hey, careful, man, there's a beverage here!";
            quotes[10] = "Q10: Mr. Treehorn treats objects like women, man.";

            System.out.println("Select a number between 1-10 for a Big Lebowski movie quote.");
            int userSelect = scanner.nextInt();
            System.out.println(quotes[userSelect]);
        } catch (Exception e) {
            System.out.println("That had NOT occurred to us, Dude. Try a number 1-10.");
            e.printStackTrace();
        }
    }
}
