package com.example.RESTful.Blog.Backend.blog.category.service;

import com.example.RESTful.Blog.Backend.blog.category.dto.request.CategoryRequestDto;
import com.example.RESTful.Blog.Backend.blog.category.dto.response.CategoryResponseDto;

import java.util.List;

public interface CategoryService {
    List<CategoryResponseDto> getAllCategories();
    CategoryResponseDto createCategory(CategoryRequestDto categoryDto);
    CategoryResponseDto getCategoryById(Long id);
}
