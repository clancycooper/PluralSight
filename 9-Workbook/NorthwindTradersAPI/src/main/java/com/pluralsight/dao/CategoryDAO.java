package com.pluralsight.dao;

import com.pluralsight.models.Category;

import java.util.List;

public interface CategoryDAO {
    List<Category> getAll();
    Category getById(int id);
    Category insert(Category category);
}
