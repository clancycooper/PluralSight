package com.pluralsight.dao;

import com.pluralsight.model.Product;

import java.util.List;

public interface ProductDAOInt {
    Product add(Product product);

   List<Product> getAll();

}
