package com.pluralsight.controllers;

import com.pluralsight.dao.JdbcSalesContractDAO;
import com.pluralsight.models.SalesContract;
import com.pluralsight.models.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SalesController {
    private JdbcSalesContractDAO jdbcSalesContractDAO;

    @Autowired
    public SalesController(JdbcSalesContractDAO jdbcSalesContractDAO) {
        this.jdbcSalesContractDAO = jdbcSalesContractDAO;
    }

    @RequestMapping(path = "/sales", method = RequestMethod.GET)
    public List<SalesContract> getAllSales() {
        var sales = jdbcSalesContractDAO.getAllSales();
        return sales;
    }

    @RequestMapping(path = "/sales/id/{saleID}", method = RequestMethod.GET)
    public List<SalesContract> getById(@PathVariable int saleID) {
        var sales = jdbcSalesContractDAO.getById(saleID);
        return sales;
    }

    @RequestMapping(path="/sales/add", method=RequestMethod.POST)
    @ResponseStatus(value= HttpStatus.CREATED)
    public SalesContract addSale(
            @RequestBody SalesContract salesContract
    ){
        SalesContract newSale = jdbcSalesContractDAO.insertSale(salesContract);
        return newSale;
    }
}
