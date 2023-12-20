package com.pluralsight.controllers;

import com.pluralsight.models.Product;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @RequestMapping(path = "/products", method = RequestMethod.GET)
    public String getProduct() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, 1, "Chai", 18.00));
        products.add(new Product(2, 1, "Chang", 19.00));
        products.add(new Product(3, 2, "Aniseed Syrup", 10.00));
        products.add(new Product(4, 2, "Chef Anton's Cajun Seasoning", 22.00));

        StringBuilder productString = new StringBuilder();
        for (Product product : products) {
            productString.append(product.toString()).append("\n");
        }

        return productString.toString();
    }


    @RequestMapping(path = "/products/{id}", method = RequestMethod.GET)
    public String getProductByID(@PathVariable int id) {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, 1, "Chai", 18.00));
        products.add(new Product(2, 1, "Chang", 19.00));
        products.add(new Product(3, 2, "Aniseed Syrup", 10.00));
        products.add(new Product(4, 2, "Chef Anton's Cajun Seasoning", 22.00));

        for (Product product : products) {
            if (product.getProductID() == id) {
                return product.toString();
            }
        }

        return null;
    }

}
