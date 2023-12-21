package com.pluralsight.controllers;

import com.pluralsight.dao.CategoryDAO;
import com.pluralsight.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
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
    public Category getCategoryByID(@PathVariable int id) {
        Category category = dao.getById(id);
        return category;
    }

    @RequestMapping(path="/categories", method=RequestMethod.POST)
    @ResponseStatus(value= HttpStatus.CREATED)
    public Category addCategory(
            @RequestBody Category category
    ){
        Category newCategory = dao.insert(category);
        return newCategory;
    }

    @RequestMapping(path="/categories/{id}",method=RequestMethod.PUT)
    public void updateCategory (
            @PathVariable int id,
            @RequestBody Category category
    )
    {
        dao.update(id, category);
    }

    @RequestMapping(path="/categories/{id}",method=RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteCategory (@PathVariable int id)
    {
        dao.delete(id);
    }
}
