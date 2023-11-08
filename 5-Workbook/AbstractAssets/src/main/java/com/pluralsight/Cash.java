package com.pluralsight;

public class Cash extends Asset {
    public Cash(String dateAcquired, String description, double originalCost) {
        super(dateAcquired, description, originalCost);
    }

    @Override
    public double getValue() {
        return originalCost;
    }
}
