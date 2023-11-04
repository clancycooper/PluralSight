package com.pluralsight;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {
    @org.junit.jupiter.api.Test
    void checkIn_should_be_occupied_and_dirty() {
        Room testRoom = new Room();
        boolean isOccupied = true;
        boolean isDirty = true;
        boolean isAvailable = false;
        boolean expectedOccupancy = true;
        boolean expectedDirty = true;
        boolean expectedAvailable = false;

        testRoom.checkIn();

        boolean actualOccupied = testRoom.isOccupied();
        boolean actualDirty = testRoom.isDirty();
        boolean actualAvailable = testRoom.isAvailable();
        assertTrue(expectedOccupancy, String.valueOf(actualOccupied));
        assertTrue(expectedDirty, String.valueOf(actualDirty));
        assertFalse(expectedAvailable, String.valueOf(actualAvailable));
    }

    @org.junit.jupiter.api.Test
    void checkOut_isNotOccupied_isDirty_isNotAvailable() {
        Room testRoom = new Room();
        boolean isOccupied = false;
        boolean isDirty = true;
        boolean isAvailable = false;
        boolean expectedOccupancy = false;
        boolean expectedDirty = true;
        boolean expectedAvailable = false;

        testRoom.checkOut();
        boolean actualOccupied = testRoom.isOccupied();
        boolean actualDirty = testRoom.isDirty();
        boolean actualAvailable = testRoom.isAvailable();

        assertFalse(expectedOccupancy, String.valueOf(actualOccupied));
        assertTrue(expectedDirty, String.valueOf(actualDirty));
        assertFalse(expectedAvailable, String.valueOf(actualAvailable));
    }

    @org.junit.jupiter.api.Test
    void cleanRoom() {
        Room testRoom = new Room();
        boolean isDirty = false;
        boolean isAvailable = true;
        boolean expectedDirty = false;
        boolean expectedAvailable = true;

        testRoom.cleanRoom();
        boolean actualDirty = testRoom.isDirty();
        boolean actualAvailable = testRoom.isAvailable();
        assertFalse(expectedDirty, String.valueOf(actualDirty));
        assertTrue(expectedAvailable, String.valueOf(actualAvailable));
    }

}