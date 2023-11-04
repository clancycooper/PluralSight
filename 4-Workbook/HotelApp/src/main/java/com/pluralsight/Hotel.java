package com.pluralsight;

public class Hotel {
    String name;
    int numberOfRooms;
    int numberOfSuites;
    int bookedSuites = 0;
    int bookedBasicRooms = 0;

    public void Hotel(String name, int numberOfRooms, int numberOfSuites) {
        this.numberOfRooms = numberOfRooms;
        this.numberOfSuites = numberOfSuites;
    }

    public void Hotel(String name, int numberOfRooms, int numberOfSuites, int bookedSuites, int bookedBasicRooms) {
        this.numberOfRooms = numberOfRooms;
        this.numberOfSuites = numberOfSuites;
        this.bookedSuites = bookedSuites;
        this.bookedBasicRooms = bookedBasicRooms;
    }

    public boolean bookRoom(int roomReservation, boolean isSuite) {
        if(roomReservation < getAvailableSuites() && isSuite) {
            bookedSuites += roomReservation;
            System.out.println("You have reserved " + roomReservation + " Suites.");
            return true;
        } else if (roomReservation < getAvailableRooms() && isSuite != true) {
            bookedBasicRooms += roomReservation;
            System.out.println("You have reserved " + roomReservation + " Rooms.");
            return true;
        } else {
            System.out.println("No vacancy.");
            return false;
        }
    }

    public int getAvailableRooms() {
        return numberOfRooms - bookedBasicRooms;
    }

    public int getAvailableSuites() {
        return numberOfSuites - bookedSuites;
    }
}
