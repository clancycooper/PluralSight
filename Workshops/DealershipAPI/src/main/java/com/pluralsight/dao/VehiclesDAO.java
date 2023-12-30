package com.pluralsight.dao;

import com.pluralsight.models.Vehicle;

import java.util.List;

public interface VehiclesDAO {
    List<Vehicle> getAll();
    List<Vehicle> getByMinPrice(double minPrice);
    List<Vehicle> getByMaxPrice(double maxPrice);
    List<Vehicle> getByMake(String makeID);
    List<Vehicle> getByModel(String modelID);
    List<Vehicle> getByMinYear(int minYear);
    List<Vehicle> getByMaxYear(int maxYear);
    List<Vehicle> getByColor(String color);
    List<Vehicle> getByMinMile(int minMile);
    List<Vehicle> getByMaxMile(int maxMile);
    List<Vehicle> getByType(String type);
    Vehicle insert(Vehicle vehicle);
    void update(int vin, Vehicle vehicle);
    void delete(int vin);
}
