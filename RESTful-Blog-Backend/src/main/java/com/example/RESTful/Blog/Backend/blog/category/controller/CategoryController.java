package com.example.RESTful.Blog.Backend.blog.category.controller;

import com.example.RESTful.Blog.Backend.blog.category.dto.request.CategoryRequestDto;
import com.example.RESTful.Blog.Backend.blog.category.dto.response.CategoryResponseDto;
import com.example.RESTful.Blog.Backend.blog.category.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<CategoryResponseDto> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @PostMapping
    public CategoryResponseDto createCategory(@RequestBody CategoryRequestDto categoryDto) {
        return categoryService.createCategory(categoryDto);
    }

    @GetMapping("/{id}")
    public CategoryResponseDto getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }
}
