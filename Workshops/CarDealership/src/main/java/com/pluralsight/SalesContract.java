package com.pluralsight;

public class SalesContract extends Contract{
    protected double salesTaxAmount = 0.05;
    protected double recordingFee = 100.00;
    protected double processingFee;

    protected boolean finance;

    public SalesContract(String date, String customerName, String customerEmail, String vehicleSold, double salesTaxAmount, double recordingFee, double processingFee, boolean finance) {
        super(date, customerName, customerEmail, vehicleSold);
        this.salesTaxAmount = salesTaxAmount;
        this.recordingFee = recordingFee;
        this.processingFee = processingFee;
        this.finance = finance;
    }

    public double getSalesTaxAmount() {
        return salesTaxAmount;
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public double getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
        //if 295 for vehicles under 10,000 and 495 for all others
    }

    public boolean isFinance() {
        return finance;
    }

    public void setFinance(boolean finance) {
        this.finance = finance;
    }
    //@Override
    //        public double getValue() {
    //            return (originalCost / squareFoot) + (.25 * lotSize);
    //        }
}