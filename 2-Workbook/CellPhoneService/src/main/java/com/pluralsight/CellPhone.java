package com.pluralsight;

public class CellPhone {
    private int serialNum;
    private String model;
    private String carrier;
    private String phoneNum;
    private String owner;
    private String callingNum;

    public CellPhone()
    {
        serialNum = 0;
        model = "";
        carrier = "";
        phoneNum = "";
        owner = "";
        callingNum = "";

    }

    public void dial(String callingNum) {
        System.out.println(owner + " is calling " + callingNum);
    }

    public int getSerialNum() {
        return serialNum;
    }

    public String getModel() {
        return model;
    }
    public String getCarrier() { return carrier; }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getOwner() {
        return owner;
    }
    public String getCallingNum() { return callingNum; }

    public void setSerialNum(int serialNum) {
        this.serialNum = serialNum;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
    public void setCallingNum(String callingNum) { this.callingNum = callingNum; }
}
