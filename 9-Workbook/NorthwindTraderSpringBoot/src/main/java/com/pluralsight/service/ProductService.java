package com.pluralsight.service;

import com.pluralsight.dao.ProductDAOInt;
import com.pluralsight.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductService {

    private final ProductDAOInt productDAOInt;

    @Autowired
    public ProductService(ProductDAOInt productDAOInt) {
        this.productDAOInt = productDAOInt;
    }

    public List<Product> getAllProducts() {
        return productDAOInt.getAll();
    }
}

