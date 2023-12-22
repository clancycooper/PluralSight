package com.pluralsight.models;


public class SalesContract {
    private int saleID, VIN, dealershipID;
    private String firstName, lastName, address, saleDate;


//public class SalesContract extends Contract{
//    protected double salesTaxAmount;
//    protected double recordingFee = 100.00;
//    protected double processingFee;
//
//    protected boolean finance;

    public SalesContract(String firstName, String lastName, String address, String saleDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.saleDate = saleDate;
    }

//    public SalesContract(String date, String customerName, String customerEmail, String vehicleSold, double salesTaxAmount, double recordingFee, double processingFee, boolean finance) {
//        super(date, customerName, customerEmail, vehicleSold);
//        this.salesTaxAmount = salesTaxAmount;
//        this.recordingFee = recordingFee;
//        this.processingFee = processingFee;
//        this.finance = finance;
//    }

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


//
//    public double getSalesTaxAmount() {
//        double salesTaxAmount = (getPrice() / .05) / 100;
//        return salesTaxAmount;
//    }
//
//    public double getRecordingFee() {
//        return recordingFee;
//    }
//
//    public double getProcessingFee() {
//
//        //if 295 for vehicles under 10,000 and 495 for all others
//
//        if (getPrice() < 10000) {
//            processingFee = 295;
//        }
//        else {
//            processingFee = 495;
//        }
//        return processingFee;
//
//    }
//
//    public void setProcessingFee(double processingFee) {
//        this.processingFee = processingFee;
//
//    }
//
//    public boolean isFinance() {
//        return finance;
//    }
//
//    public void setFinance(boolean finance) {
//        this.finance = finance;
//    }
//
//
//    @Override
//    public double getTotalPrice() {
//        double totalPrice = getPrice() + salesTaxAmount + recordingFee + processingFee;
//        return totalPrice;
//    }
//
//    @Override
//    public double getMonthlyPayment() {
//        double monthlyLoanPayment = 0.0;
//
//        if (isFinance() && getPrice() >= 10000) {
//            double interest = (getTotalPrice() / 4.25) / 100;
//            double monthly = getTotalPrice() /48;
//            monthlyLoanPayment = interest + monthly;
//        }
//        else if (isFinance() && getPrice() < 10000) {
//            double interest = (getTotalPrice() / 5.25) / 100;
//            double monthly = getTotalPrice() /24;
//            monthlyLoanPayment = interest + monthly;
//        }
//        else {
//            monthlyLoanPayment = 0.0;
//        }
//
//        return monthlyLoanPayment;
//    }

}