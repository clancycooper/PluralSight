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

    @RequestMapping(path = "/vehicles/{minPrice}", method = RequestMethod.GET)
    public List<Vehicle> getMinPrice(@PathVariable double minPrice) {
        var vehicles = jdbcVehiclesDAO.getByMinPrice(minPrice);
        return vehicles;
    }

}
