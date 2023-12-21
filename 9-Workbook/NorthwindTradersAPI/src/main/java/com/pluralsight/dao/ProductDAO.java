package com.pluralsight.dao;

import com.pluralsight.models.Product;

import java.util.List;

public interface ProductDAO {
    List<Product> getAll();
    Product getById(int id);
    Product insert(Product product);
    void update(int id, Product product);
    void delete(int id);
}
