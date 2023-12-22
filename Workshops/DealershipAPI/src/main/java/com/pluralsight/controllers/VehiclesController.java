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
        void vehicles = jdbcVehiclesDAO.getAllVehicles();
        return vehicles;
    }
}
