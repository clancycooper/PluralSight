package com.pluralsight.controllers;

import com.pluralsight.dao.JdbcVehiclesDAO;
import com.pluralsight.models.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class VehiclesController {
    private JdbcVehiclesDAO jdbcVehiclesDAO;

    @Autowired
    public VehiclesController(JdbcVehiclesDAO jdbcVehiclesDAO) {
        this.jdbcVehiclesDAO = jdbcVehiclesDAO;
    }

    @RequestMapping(path = "/vehicles", method = RequestMethod.GET)
    public List<Vehicle> getAllVehicles() {
        var vehicles = jdbcVehiclesDAO.getAll();
        return vehicles;
    }

    @RequestMapping(path = "/vehicles/min/{minPrice}", method = RequestMethod.GET)
    public List<Vehicle> getMinPrice(@PathVariable double minPrice) {
        var vehicles = jdbcVehiclesDAO.getByMinPrice(minPrice);
        return vehicles;
    }

    @RequestMapping(path = "/vehicles/max/{maxPrice}", method = RequestMethod.GET)
    public List<Vehicle> getMaxPrice(@PathVariable double maxPrice) {
        var vehicles = jdbcVehiclesDAO.getByMaxPrice(maxPrice);
        return vehicles;
    }

    @RequestMapping(path = "/vehicles/make/{makeID}", method = RequestMethod.GET)
    public List<Vehicle> getByMake(@PathVariable String makeID) {
        var vehicles = jdbcVehiclesDAO.getByMake(makeID);
        return vehicles;
    }

    @RequestMapping(path = "/vehicles/model/{modelID}", method = RequestMethod.GET)
    public List<Vehicle> getByModel(@PathVariable String modelID) {
        var vehicles = jdbcVehiclesDAO.getByModel(modelID);
        return vehicles;
    }
}
