package com.pluralsight;

public class HotelApp {
    public static void main(String[] args) {
        //Employee(int employeeId, String name, String department, double payRate, double hoursWorked)
        Employee employee1 = new Employee(1, "Hunter", "Front Desk", 17.00, 40.00);
        Employee employee2 = new Employee(2, "Andrea", "HR", 23.00, 40.00);
        Employee employee3 = new Employee(3, "Clancy", "Maintenance", 15.00, 25.00);
        Employee employee4 = new Employee(4, "Aubreyana", "Management", 23.00, 45.00);
        Employee employee5 = new Employee(5, "Danesha", "Kitchen", 17.00, 35.00);



        //System.out.println("Hunter made $" + employee1.getTotalPay() + "\n" + "Aubreyana made $" + employee4.getTotalPay());
        // System.out.println("Hunter punched in at " + employee1.getTime());
    }
}
