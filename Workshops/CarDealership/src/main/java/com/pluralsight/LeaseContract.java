package com.pluralsight;

public class LeaseContract extends Contract{
    protected double expectedEndingValue = 0.5;
    protected double leaseFee = 0.07;

    public LeaseContract(String date, String customerName, String customerEmail, String vehicleSold, double expectedEndingValue, double leaseFee) {
        super(date, customerName, customerEmail, vehicleSold);
        this.expectedEndingValue = expectedEndingValue;
        this.leaseFee = leaseFee;
    }

    public double getExpectedEndingValue() {
        return expectedEndingValue;
    }

    public double getLeaseFee() {
        return leaseFee;
    }
    //@Override
    //        public double getValue() {
    //            return (originalCost / squareFoot) + (.25 * lotSize);
    //        }



}