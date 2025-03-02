package com.example.RESTful.Blog.Backend.service;

import com.example.RESTful.Blog.Backend.model.Category;
import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    Category createCategory(Category category);
    Category getCategoryById(Long id);
}
