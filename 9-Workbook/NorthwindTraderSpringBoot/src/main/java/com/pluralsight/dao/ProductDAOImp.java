package com.pluralsight.dao;

import com.pluralsight.model.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImp implements ProductDAOInt{

    private final List<Product> products = new ArrayList<>();

    public ProductDAOImp() {
        products.add(new Product(1, "Chai", "Beverages", new BigDecimal("18.00")));
        products.add(new Product(2, "Chang", "Beverages", new BigDecimal("19.00")));
        products.add(new Product(3, "Aniseed Syrup", "Condiments", new BigDecimal("10.00")));
    }

    @Override
    public Product add(Product product) {
    products.add(product);
        return product;
    }

    @Override
    public List<Product> getAll() {
        return products;
    }
}
