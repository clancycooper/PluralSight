package com.pluralsight;

import java.util.Scanner;

import static com.pluralsight.Hand.players;

public class BlackJack {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //new Deck, new dealer, dealer shuffles hand
        Deck deck = new Deck();
        Hand dealerHand = new Hand();
        deck.shuffle();

        //User is prompted for the number of players at their table
        System.out.print("Please enter the number of players (2-7) at the table: ");
        int numOfPlayers = scanner.nextInt();
        scanner.nextLine();

        //For each player a new hand, a second list tracks the players names
        for (int i = 0; i < numOfPlayers && numOfPlayers <= 7; i++) {
            Hand playerHand = new Hand();
            System.out.println("What is the name of Player " + (i+1) + "?");
            String playerName = scanner.nextLine();
            players.add(playerName);
            playerHand.deal(deck.deal());
            playerHand.deal(deck.deal());
            int handValue = playerHand.getValue();
            System.out.println(handValue);
        }

        // deal 5 cards
        for(int i = 0; i < 5; i++) {
            // get a card from the deck
            Card card = deck.deal();
            // deal that card to the hand
            dealerHand.deal(card);
        }


        int handValue = dealerHand.getValue();
        System.out.println("This hand is worth " + handValue);
    }
}
