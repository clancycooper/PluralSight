package com.pluralsight.dao;

import com.pluralsight.models.Vehicle;

import java.util.List;

public interface VehiclesDAO {
    List<Vehicle> getAll();
    List<Vehicle> getByMinPrice(double minPrice);
    List<Vehicle> getByMaxPrice(double maxPrice);
    List<Vehicle> getByMake(String makeID);
    List<Vehicle> getByModel(String modelID);
    Vehicle getByMinYear(int id);
    Vehicle getByMaxYear(int id);
    Vehicle getByColor(int id);
    Vehicle getByType(int id);
    Vehicle getByMinMile(int id);
    Vehicle getByMaxMile(int id);
    Vehicle insert(Vehicle vehicle);
    void update(int id, Vehicle vehicle);
    void delete(int id);
}
