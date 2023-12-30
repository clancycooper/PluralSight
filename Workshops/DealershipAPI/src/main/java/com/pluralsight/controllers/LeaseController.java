package com.pluralsight.controllers;

import com.pluralsight.dao.JdbcLeaseContractDAO;
import com.pluralsight.models.LeaseContract;
import com.pluralsight.models.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LeaseController {
    private JdbcLeaseContractDAO jdbcLeaseContractDAO;

    @Autowired
    public LeaseController(JdbcLeaseContractDAO jdbcLeaseContractDAO) {
        this.jdbcLeaseContractDAO = jdbcLeaseContractDAO;
    }

    @RequestMapping(path = "/leases", method = RequestMethod.GET)
    public List<LeaseContract> getAllLeases() {
        var leases = jdbcLeaseContractDAO.getAllLeases();
        return leases;
    }
}
