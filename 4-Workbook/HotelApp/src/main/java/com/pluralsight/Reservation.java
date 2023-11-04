package com.pluralsight;

public class Reservation {
    private String roomType;
    private double price;
    private int numberOfNights;
    private boolean isWeekend;
    private double reservationTotal;

    public void Reservation(String roomType, double price, int numberOfNights, boolean isWeekend, double reservationTotal) {
        this.roomType = roomType;
        this.price = price;
        this.numberOfNights = numberOfNights;
        this.isWeekend = isWeekend;
        this.reservationTotal = reservationTotal;
    }

    public String getRoomType() {
        return roomType;
    }

    public double setRoomType(String roomType) {
        if(roomType.equalsIgnoreCase("King")) {
            price = 139.00;
        } else {
            price = 124.00;
        }
        return price;
    }

    public double getPrice() {
        return price;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }
    public boolean isWeekend() {
        return isWeekend;
    }

    public void setWeekend(boolean weekend) {
        isWeekend = weekend;
    }

    public double getReservationTotal() {
        double reservationTotal;
        if(isWeekend()) {
            double weekendPrice = price * numberOfNights;
            reservationTotal = (weekendPrice * .10) + weekendPrice;
        } else {
            reservationTotal = price * numberOfNights;
        }
        return reservationTotal;
    }
}
