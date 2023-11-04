package com.pluralsight;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {
    @Test
    void punchOut() {
        Employee testEmployee = new Employee(0, "Scout", "Register", 17.00, 40.00);
        LocalDateTime testOut = LocalDateTime.now();
        LocalDateTime expectedOut = LocalDateTime.now();

        testEmployee.punchOut();
        LocalDateTime actualOut;
        actualOut = testEmployee.punchOut();

        assertEquals(expectedOut, actualOut);
        System.out.println(expectedOut + " " + actualOut);
    }

}