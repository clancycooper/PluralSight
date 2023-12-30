package com.pluralsight.models;

public class LeaseContract {

    private int leaseID, VIN, dealershipID;
    private String firstName, lastName, address, startDate, endDate;
    private double amountPaid, amountDue;

    public LeaseContract(int leaseID, int vin, int dealershipID, String firstName, String lastName, String address, String startDate, String endDate, double amountPaid, double amountDue) {
        this.leaseID = leaseID;
        this.VIN = vin;
        this.dealershipID = dealershipID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.startDate = startDate;
        this.endDate = endDate;
        this.amountPaid = amountPaid;
        this.amountDue = amountDue;
    }

    public int getLeaseID() {
        return leaseID;
    }

    public void setLeaseID(int leaseID) {
        this.leaseID = leaseID;
    }

    public int getVIN() {
        return VIN;
    }

    public void setVIN(int VIN) {
        this.VIN = VIN;
    }

    public int getDealershipID() {
        return dealershipID;
    }

    public void setDealershipID(int dealershipID) {
        this.dealershipID = dealershipID;
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
}