package com.pluralsight.controllers;

import com.pluralsight.dao.JdbcVehiclesDAO;
import com.pluralsight.models.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @RequestMapping(path = "/vehicles/min/price/{minPrice}", method = RequestMethod.GET)
    public List<Vehicle> getMinPrice(@PathVariable double minPrice) {
        var vehicles = jdbcVehiclesDAO.getByMinPrice(minPrice);
        return vehicles;
    }

    @RequestMapping(path = "/vehicles/max/price/{maxPrice}", method = RequestMethod.GET)
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

    @RequestMapping(path = "/vehicles/min/year/{minYear}", method = RequestMethod.GET)
    public List<Vehicle> getByMinYear(@PathVariable int minYear) {
        var vehicles = jdbcVehiclesDAO.getByMinYear(minYear);
        return vehicles;
    }

    @RequestMapping(path = "/vehicles/max/year/{maxYear}", method = RequestMethod.GET)
    public List<Vehicle> getByMaxYear(@PathVariable int maxYear) {
        var vehicles = jdbcVehiclesDAO.getByMaxYear(maxYear);
        return vehicles;
    }

    @RequestMapping(path = "/vehicles/color/{color}", method = RequestMethod.GET)
    public List<Vehicle> getByColor(@PathVariable String color) {
        var vehicles = jdbcVehiclesDAO.getByColor(color);
        return vehicles;
    }

    @RequestMapping(path = "/vehicles/min/mile/{minMile}", method = RequestMethod.GET)
    public List<Vehicle> getByMinMile(@PathVariable int minMile) {
        var vehicles = jdbcVehiclesDAO.getByMinMile(minMile);
        return vehicles;
    }

    @RequestMapping(path = "/vehicles/max/mile/{maxMile}", method = RequestMethod.GET)
    public List<Vehicle> getByMaxMile(@PathVariable int maxMile) {
        var vehicles = jdbcVehiclesDAO.getByMaxMile(maxMile);
        return vehicles;
    }

    @RequestMapping(path = "/vehicles/type/{type}", method = RequestMethod.GET)
    public List<Vehicle> getByType(@PathVariable String type) {
        var vehicles = jdbcVehiclesDAO.getByType(type);
        return vehicles;
    }

    @RequestMapping(path="/vehicles/add", method=RequestMethod.POST)
    @ResponseStatus(value= HttpStatus.CREATED)
    public Vehicle addVehicle(
            @RequestBody Vehicle vehicle
    ){
        Vehicle newVehicle = jdbcVehiclesDAO.insert(vehicle);
        return newVehicle;
    }

}
