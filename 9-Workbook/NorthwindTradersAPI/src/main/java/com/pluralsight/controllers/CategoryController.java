package com.pluralsight.controllers;

import com.pluralsight.dao.CategoryDAO;
import com.pluralsight.models.Category;
import com.pluralsight.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(path="/categories", method=RequestMethod.POST)
    @ResponseStatus(value= HttpStatus.CREATED)
    public Category addCategory(
            @RequestBody Category category
    ){
        Category newCategory = dao.insert(category);
        return newCategory;
    }
}
