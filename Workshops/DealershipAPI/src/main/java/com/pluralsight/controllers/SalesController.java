package com.pluralsight.controllers;

import com.pluralsight.dao.JdbcSalesContractDAO;
import com.pluralsight.models.LeaseContract;
import com.pluralsight.models.SalesContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
