package com.pluralsight.dealership;

import static com.pluralsight.dealership.Vehicle.getPrice;

public class LeaseContract extends Contract {
    protected double expectedEndingValue = 0.5;
    protected double leaseFee = 0.07;


    public LeaseContract(String date, String customerName, String customerEmail, String vehicleSold, double expectedEndingValue, double leaseFee) {
        super(date, customerName, customerEmail, vehicleSold);
        this.expectedEndingValue = expectedEndingValue;
        this.leaseFee = leaseFee;
    }

    public double getExpectedEndingValue() {
        expectedEndingValue = getPrice() * expectedEndingValue;
        return expectedEndingValue;
    }

    public double getLeaseFee() {
        return leaseFee;
    }

    @Override
    public double getTotalPrice() {
        double totalPrice = getPrice() + expectedEndingValue + leaseFee;
        return totalPrice;
    }

    @Override
    public double getMonthlyPayment() {
        double monthly = getTotalPrice() / 36;
        double interest = (getTotalPrice() / 4.0) / 100;
        double monthlyLeasePayment = monthly + interest;
        return monthlyLeasePayment;

    }
}