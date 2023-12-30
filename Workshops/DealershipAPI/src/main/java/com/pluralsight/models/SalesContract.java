package com.pluralsight.models;


public class SalesContract {
    private int saleID, VIN, dealershipID;
    private String firstName, lastName, address, saleDate;


    public SalesContract(int saleID, int vin, int dealershipID, String firstName, String lastName, String address, String saleDate) {
        this.saleID = saleID;
        this.VIN = vin;
        this.dealershipID = dealershipID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.saleDate = saleDate;
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

    public String getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }

    public int getSaleID() {
        return saleID;
    }

    public void setSaleID(int saleID) {
        this.saleID = saleID;
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
}