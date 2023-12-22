package com.pluralsight.models;

import java.util.Scanner;

public class Dealership {
    public static Scanner scanner = new Scanner(System.in);
    private int dealershipID;
    private String name, phone, address;

    //public static ArrayList<Vehicle> inventory = new ArrayList<Vehicle>();


    public Dealership(int dealershipID, String name, String address, String phone) {
        this.dealershipID = dealershipID;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public int getDealershipID() {
        return dealershipID;
    }

    public void setDealershipID(int dealershipID) {
        this.dealershipID = dealershipID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


//    public static void getVehiclesByPrice() throws IOException {
//        ArrayList<Vehicle> byPrice = new ArrayList<>();
//        System.out.println("Filter Vehicles by Price:\n" +
//                "Please enter the minimum dollar amount: ");
//        double minPrice = scanner.nextDouble();
//        System.out.println("Please enter the maximum dollar amount: ");
//        double maxPrice = scanner.nextDouble();
//        scanner.nextLine();
//        for (Vehicle vehicle : inventory) {
//            if ((vehicle.getPrice() >= minPrice) && (vehicle.getPrice() <= maxPrice)) {
//                byPrice.add(vehicle);
//            }
//        }
//        displayVehicles(byPrice);
//
//        System.out.println("Do you want to start a new search? Y/N");
//        String userYN = scanner.nextLine();
//        if (userYN.equalsIgnoreCase("Y")) {
//            getVehiclesByPrice();
//        }
//        else if (userYN.equalsIgnoreCase("N")) {
//            display();
//        }
//        else {
//            System.out.println("Invalid Response. Rerouting to Main Menu.");
//            display();
//
//
//        }
//    }
//
//    public static void getVehiclesByMakeModel() throws IOException {
//        ArrayList<Vehicle> byMakeModel = new ArrayList<>();
//        System.out.println("Filter Vehicles by Make/Model:\n" +
//                "Please enter the Make: ");
//        String make = scanner.nextLine();
//        System.out.println("Please enter the Model: ");
//        String model = scanner.nextLine();
//        for (Vehicle vehicles : inventory) {
//            if ((vehicles.getMake().equalsIgnoreCase(make)) || (vehicles.getModel().equalsIgnoreCase(model))) {
//                byMakeModel.add(vehicles);
//            }
//        }
//        displayVehicles(byMakeModel);
//
//        System.out.println("Do you want to start a new search? Y/N");
//        String userYN = scanner.nextLine();
//        if (userYN.equalsIgnoreCase("Y")) {
//            getVehiclesByMakeModel();
//        }
//        else if (userYN.equalsIgnoreCase("N")) {
//            display();
//        }
//        else {
//            System.out.println("Invalid Response. Rerouting to Main Menu.");
//            display();
//
//
//        }
//    }
//
//    public static void getVehiclesByYear() throws IOException {
//        ArrayList<Vehicle> byYear = new ArrayList<>();
//        System.out.println("Filter Vehicles by Year:\n" +
//                "Please enter the earliest year: ");
//        int year1 = scanner.nextInt();
//        System.out.println("Please enter the latest year: ");
//        int year2 = scanner.nextInt();
//        scanner.nextLine();
//        for (Vehicle vehicles : inventory) {
//            if ((vehicles.getYear() >= year1) && (vehicles.getYear() <= year2)) {
//                byYear.add(vehicles);
//            }
//        }
//        displayVehicles(byYear);
//
//        System.out.println("Do you want to start a new search? Y/N");
//        String userYN = scanner.nextLine();
//        if (userYN.equalsIgnoreCase("Y")) {
//            getVehiclesByYear();
//        }
//        else if (userYN.equalsIgnoreCase("N")) {
//            display();
//        }
//        else {
//            System.out.println("Invalid Response. Rerouting to Main Menu.");
//            display();
//
//
//        }
//    }
//
//    public static void getVehiclesByColor() throws IOException {
//        ArrayList<Vehicle> byColor = new ArrayList<>();
//        System.out.println("Filter Vehicles by Color:\n" +
//                "Please enter the Color: ");
//        String color = scanner.nextLine();
//        for (Vehicle vehicles : inventory) {
//            if (vehicles.getColor().equalsIgnoreCase(color)) {
//                byColor.add(vehicles);
//            }
//        }
//        displayVehicles(byColor);
//
//        System.out.println("Do you want to start a new search? Y/N");
//        String userYN = scanner.nextLine();
//        if (userYN.equalsIgnoreCase("Y")) {
//            getVehiclesByColor();
//        }
//        else if (userYN.equalsIgnoreCase("N")) {
//            display();
//        }
//        else {
//            System.out.println("Invalid Response. Rerouting to Main Menu.");
//            display();
//
//
//        }
//    }
//
//    public static void getVehiclesByMileage() throws IOException {
//        ArrayList<Vehicle> byMileage = new ArrayList<>();
//        System.out.println("Filter Vehicles by Mileage:\n" +
//                "Please enter the minimum Mileage: ");
//        int minMiles = scanner.nextInt();
//        System.out.println("Please enter the maximum Mileage: ");
//        int maxMiles = scanner.nextInt();
//        scanner.nextLine();
//        for (Vehicle vehicles : inventory) {
//            if ((vehicles.getOdometer() >= minMiles) && (vehicles.getOdometer() <= maxMiles)) {
//                byMileage.add(vehicles);
//            }
//        }
//        displayVehicles(byMileage);
//        System.out.println("Do you want to start a new search? Y/N");
//        String userYN = scanner.nextLine();
//        if (userYN.equalsIgnoreCase("Y")) {
//            getVehiclesByMileage();
//        }
//        else if (userYN.equalsIgnoreCase("N")) {
//            display();
//        }
//        else {
//            System.out.println("Invalid Response. Rerouting to Main Menu.");
//            display();
//
//
//        }
//    }
//
//    public static void getVehiclesByType() throws IOException {
//        ArrayList<Vehicle> byType = new ArrayList<>();
//        System.out.println("Filter Vehicles by Type:\n" +
//                "Please enter the Type: ");
//        String type = scanner.nextLine();
//        for (Vehicle vehicles : inventory) {
//            if (vehicles.getVehicleType().equalsIgnoreCase(type)) {
//                byType.add(vehicles);
//            }
//        }
//        displayVehicles(byType);
//
//        System.out.println("Do you want to start a new search? Y/N");
//        String userYN = scanner.nextLine();
//        if (userYN.equalsIgnoreCase("Y")) {
//            getVehiclesByType();
//        }
//        else if (userYN.equalsIgnoreCase("N")) {
//            display();
//        }
//        else {
//            System.out.println("Invalid Response. Rerouting to Main Menu.");
//            display();
//
//
//        }
//    }
//
//    public static void getAllVehicles() throws IOException {
//        displayVehicles(inventory);
//
//        System.out.println("Press H to Return to Main Menu");
//        String userButton = scanner.nextLine();
//        if (userButton.equalsIgnoreCase("H")) {
//            display();
//        }
//        else {
//            display();
//        }
//
//    }
//
//    public static void addVehicle() throws IOException {
//        System.out.println("""
//                Listing your vehicle on our site
//                Please enter the following information:
//                VIN:\s""");
//        int vin = scanner.nextInt();
//        System.out.println("Year: ");
//        int year = scanner.nextInt();
//        scanner.nextLine();
//        System.out.println("Make: ");
//        String make = scanner.nextLine();
//        System.out.println("Model: ");
//        String model = scanner.nextLine();
//        System.out.println("Type: ");
//        String vehicleType = scanner.nextLine();
//        System.out.println("Color: ");
//        String color = scanner.nextLine();
//        System.out.println("Mileage: ");
//        int odometer = scanner.nextInt();
//        scanner.nextLine();
//        System.out.println("Price: ");
//        double price = scanner.nextDouble();
//        scanner.nextLine();
//        Vehicle newVehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
//        inventory.add(newVehicle);
//        //saveDealership(vin, year, make, model, vehicleType, color, odometer, price);
//        System.out.println("Your vehicle has been added to our inventory! Would you like to add another? Y/N");
//
//        String userYN = scanner.nextLine();
//        if (userYN.equalsIgnoreCase("Y")) {
//            addVehicle();
//        }
//        else {
//            display();
//        }
//    }
//
//    public static void removeVehicle() throws IOException {
//        //Cannot get this to work for the life of me
//    }
}
