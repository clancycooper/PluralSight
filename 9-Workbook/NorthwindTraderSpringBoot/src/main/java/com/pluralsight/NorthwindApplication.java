package com.pluralsight;

import com.pluralsight.dao.ProductDAOInt;
import com.pluralsight.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NorthwindApplication implements CommandLineRunner {

    private final ProductDAOInt productDAOInt;

    public NorthwindApplication(ProductDAOInt productDAOInt) {
        this.productDAOInt = productDAOInt;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Product> products = productDAOInt.getAll();
        products.forEach(product -> System.out.println(product.toString()));
    }
}

