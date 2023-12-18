package com.pluralsight.DAO;
import com.pluralsight.Products;

import java.util.List;

public interface ProductsDAO {

    void add(Products product);
    List<Products> getAll();
}
