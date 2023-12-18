package com.pluralsight.DAO;

import com.pluralsight.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SimpleProductsDAO implements ProductsDAO {
    private List<Products> employees;

    @Autowired
    public void setEmployees(List<Products> employees) {
        this.employees = employees;
    }

    @Override
    public void add(Products product) {
    employees.add(product);
    }

    @Override
    public List<Products> getAll() {
    return employees;
    }
}
