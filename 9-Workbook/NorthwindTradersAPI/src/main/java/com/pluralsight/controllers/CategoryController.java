package com.pluralsight.controllers;

import com.pluralsight.models.Category;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoryController {

    @RequestMapping(path = "/categories", method = RequestMethod.GET)
    public String getCategory() {
        List<Category> categories = new ArrayList<>();
        categories.add(new Category(1, "Beverages"));
        categories.add(new Category(2, "Condiments"));
        categories.add(new Category(3, "Confections"));
        StringBuilder categoryString = new StringBuilder();
        for (Category category : categories) {
            categoryString.append(category.toString()).append("\n");
        }
        return categoryString.toString();
    }

    @RequestMapping(path = "/categories/{id}", method = RequestMethod.GET)
    public String getCategoryById(@PathVariable int id) {
        List<Category> categories = new ArrayList<>();
        categories.add(new Category(1, "Beverages"));
        categories.add(new Category(2, "Condiments"));
        categories.add(new Category(3, "Confections"));
        StringBuilder categoryString = new StringBuilder();
        for (Category category : categories) {
            if (category.getCategoryID() == id) {
                return category.toString();
            }
        }
        return null;
    }
}
