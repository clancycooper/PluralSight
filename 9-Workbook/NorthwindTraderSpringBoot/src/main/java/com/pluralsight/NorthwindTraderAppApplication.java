package com.pluralsight;

import com.pluralsight.model.Product;
import com.pluralsight.service.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class NorthwindTraderAppApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(NorthwindTraderAppApplication.class, args);
		ProductService productService = context.getBean(ProductService.class);

		productService.getAllProducts().forEach(product ->  System.out.println(product.toString()));
	}

}
