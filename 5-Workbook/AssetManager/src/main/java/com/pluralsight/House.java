package com.pluralsight;

public class House extends Asset {
    private String address;
    private int condition, squareFoot, lotSize;

    public House(String dateAcquired, String description, double originalCost, String address, int condition, int squareFoot, int lotSize) {
        super(dateAcquired, description, originalCost);
        this.address = address;
        this.condition = condition;
        this.squareFoot = squareFoot;
        this.lotSize = lotSize;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCondition() {
        if(getValue() >= 180){
            System.out.println("1 - Excellent");
        }
        else if (getValue() > 90 && getValue() <= 130){
            System.out.println("2 - Good");
        }
        else if (getValue() > 80 && getValue() <= 90){
            System.out.println("3 - Fair");
        }
        else {
            System.out.println("1 - Poor");
        }
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public int getSquareFoot() {
        return squareFoot;
    }

    public void setSquareFoot(int squareFoot) {
        this.squareFoot = squareFoot;
    }

    public int getLotSize() {
        return lotSize;
    }

    public void setLotSize(int lotSize) {
        this.lotSize = lotSize;
    }

    public double getValue() {
      double getValue = (originalCost / squareFoot) + (.25 * lotSize);
      return getValue;
    }
}
