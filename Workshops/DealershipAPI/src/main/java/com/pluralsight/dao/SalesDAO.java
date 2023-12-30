package com.pluralsight.dao;

import com.pluralsight.models.SalesContract;

import java.util.List;

public interface SalesDAO {
    List<SalesContract> getAllSales();
    SalesContract insertSale(SalesContract sale);
}
