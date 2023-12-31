package com.pluralsight.controllers;

import com.pluralsight.dao.JdbcLeaseContractDAO;
import com.pluralsight.models.LeaseContract;
import com.pluralsight.models.SalesContract;
import com.pluralsight.models.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(path = "/leases/id/{leaseID}", method = RequestMethod.GET)
    public List<LeaseContract> getById(@PathVariable int leaseID) {
        var leases = jdbcLeaseContractDAO.getByID(leaseID);
        return leases;
    }

    @RequestMapping(path="/leases/add", method=RequestMethod.POST)
    @ResponseStatus(value= HttpStatus.CREATED)
    public LeaseContract leaseContract(
            @RequestBody LeaseContract leaseContract
    ){
        LeaseContract newLease = jdbcLeaseContractDAO.insertLease(leaseContract);
        return newLease;
    }
}
