package com.pluralsight;

import java.time.LocalDateTime;

public class Employee {
    private int employeeId;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;
    private double overtimeHours;
    private LocalDateTime punchIn;
    private LocalDateTime punchOut;

    public Employee(int employeeId, String name, String department, double payRate, double hoursWorked) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
        if(hoursWorked > 40) {
            this.overtimeHours = hoursWorked - 40;
        } else {
            this.overtimeHours = 0.00;
        }
    }

    public double getTotalPay() {
        if (hoursWorked <= 40) {
            return hoursWorked * payRate;
        }
        else return (hoursWorked * payRate) + (overtimeHours * (payRate * 1.5));
    }

    public double getRegularHours() {
        return hoursWorked;
    }

    public double getOvertimeHours() {
        return overtimeHours;
    }

    public void punchIn() {
        LocalDateTime.now();
    }

    public void punchIn(LocalDateTime time) {
        this.punchIn = punchIn;
    }

    public LocalDateTime punchOut() {
        return LocalDateTime.now();
    }

    public void punchOut(LocalDateTime time) {
        LocalDateTime.now();
    }

}
