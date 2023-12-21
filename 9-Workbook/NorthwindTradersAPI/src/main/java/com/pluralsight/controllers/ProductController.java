package com.pluralsight.controllers;

import com.pluralsight.dao.ProductDAO;
import com.pluralsight.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    private ProductDAO dao;

    @Autowired
    public ProductController(ProductDAO dao) {
        this.dao = dao;
    }

    @RequestMapping(path = "/products", method = RequestMethod.GET)
    public List<Product> getProducts() {
        var products = dao.getAll();
        return products;
    }

    @RequestMapping(path = "/products/{id}", method = RequestMethod.GET)
    public Product getProductByID(@PathVariable int id) {
        Product product = dao.getById(id);
        return product;
    }
}
