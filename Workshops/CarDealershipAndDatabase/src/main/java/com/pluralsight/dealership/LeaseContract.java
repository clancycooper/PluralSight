package com.pluralsight.dealership;

public class LeaseContract {

    // leaseID (int) (PK A_I)
    // VIN (int)
    // dealershipID (int)
    // firstName (String)
    // lastName (String)
    // address (String)
    // amountPaid (double)
    // amountDue(double)
    // startDate (String)
    // endDate(String)
    //Methods
    //-saveLease (Insert)
    //-updateLease (time permitting, update)

    private int leaseID, VIN, dealershipID;
    private String firstName, lastName, address, startDate, endDate;
    private double amountPaid, amountDue;

    //public class LeaseContract extends Contract {
    //protected double expectedEndingValue = 0.5;
    //protected double leaseFee = 0.07;

    public LeaseContract(String firstName, String lastName, String address, String startDate, String endDate, double amountPaid, double amountDue) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.startDate = startDate;
        this.endDate = endDate;
        this.amountPaid = amountPaid;
        this.amountDue = amountDue;
    }



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public double getAmountDue() {
        return amountDue;
    }

    public void setAmountDue(double amountDue) {
        this.amountDue = amountDue;
    }

    //    public LeaseContract(String date, String customerName, String customerEmail, String vehicleSold,) {
//        super(date, customerName, customerEmail, vehicleSold);
//        this.expectedEndingValue = expectedEndingValue;
//        this.leaseFee = leaseFee;
//    }

//    public double getExpectedEndingValue() {
//        expectedEndingValue = getPrice() * expectedEndingValue;
//        return expectedEndingValue;
//    }
//
//    public double getLeaseFee() {
//        return leaseFee;
//    }
//
//    @Override
//    public double getTotalPrice() {
//        double totalPrice = getPrice() + expectedEndingValue + leaseFee;
//        return totalPrice;
//    }
//
//    @Override
//    public double getMonthlyPayment() {
//        double monthly = getTotalPrice() / 36;
//        double interest = (getTotalPrice() / 4.0) / 100;
//        double monthlyLeasePayment = monthly + interest;
//        return monthlyLeasePayment;
//
//    }
}