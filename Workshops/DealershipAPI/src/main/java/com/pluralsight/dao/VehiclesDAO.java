package com.pluralsight.dao;

import com.pluralsight.models.Vehicle;

import java.util.List;

public interface VehiclesDAO {
    List<Vehicle> getAll();
    List<Vehicle> getByMinPrice(double minPrice);
    Vehicle getByMaxPrice(int id);
    Vehicle getByMake(int id);
    Vehicle getByModel(int id);
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
