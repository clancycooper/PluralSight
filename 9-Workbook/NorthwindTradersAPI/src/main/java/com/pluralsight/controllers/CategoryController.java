package com.pluralsight.controllers;

import com.pluralsight.dao.CategoryDAO;
import com.pluralsight.models.Category;
import com.pluralsight.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoryController {
    private CategoryDAO dao;

    @Autowired
    public CategoryController(CategoryDAO dao) {
        this.dao = dao;
    }

    @RequestMapping(path = "/categories", method = RequestMethod.GET)
    public List<Category> getCategories() {
        var categories = dao.getAll();
        return categories;
    }

    @RequestMapping(path = "/categories/{id}", method = RequestMethod.GET)
    public Category getCategoriesByID(@PathVariable int id) {
        Category category = dao.getById(id);
        return category;
    }
}
