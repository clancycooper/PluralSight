package com.pluralsight.dao;

import com.pluralsight.models.Vehicle;

import java.util.List;

public interface VehiclesDAO {
    List<Vehicle> getAll();
    Vehicle getByMinPrice(int id);
    Vehicle getByMaxPrice(int id);
    Vehicle getByMakeModel(int id);
    Vehicle getByYear(int id);
    Vehicle getByColor(int id);
    Vehicle getByType(int id);
    Vehicle getByMinMile(int id);
    Vehicle getByMaxMile(int id);
    Vehicle insert(Vehicle vehicle);
    void update(int id, Vehicle vehicle);
    void delete(int id);
}
