package com.pluralsight;

public class Card {
    private String suit, value;
    private boolean isFaceUp;

    public Card(String suit, String value) {
        this.suit = suit;
        this.value = value;
        this.isFaceUp = false;
    }

    public String getSuit() {
        if(isFaceUp) {
            return suit;
        } else {
            return "#";
        }
    }

    public String getValue() {
        if(isFaceUp){
            return value;
        } else {
            return "#";
        }
    }

    public boolean isFaceUp() {
        return isFaceUp;
    }

    public int getPointValue() {
        if(isFaceUp){
            //Ace can equal either 11 or 1
            if(value.equals("A")) {
                return 11;
            }
            //Face cards are worth 10
            else if(value.equals("K") || value.equals("Q") || value.equals("J")) {
                return 10;
            }
            //Rest are worth their face value
            return Integer.parseInt(value);
        } else {
            return 0;
        }
    }
    public void flip(){
        isFaceUp = !isFaceUp;
    }
}
