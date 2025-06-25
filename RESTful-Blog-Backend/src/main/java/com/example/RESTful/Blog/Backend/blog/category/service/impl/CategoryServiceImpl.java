package com.example.RESTful.Blog.Backend.blog.category.service.impl;

import com.example.RESTful.Blog.Backend.blog.category.dto.request.CategoryRequestDto;
import com.example.RESTful.Blog.Backend.blog.category.dto.response.CategoryResponseDto;
import com.example.RESTful.Blog.Backend.blog.category.mapper.CategoryMapper;
import com.example.RESTful.Blog.Backend.blog.category.model.Category;
import com.example.RESTful.Blog.Backend.blog.category.repository.CategoryRepository;
import com.example.RESTful.Blog.Backend.blog.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public List<CategoryResponseDto> getAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryResponseDto createCategory(CategoryRequestDto categoryDto) {
        Category category = categoryMapper.toEntity(categoryDto);
        Category saved = categoryRepository.save(category);
        return categoryMapper.toResponseDto(saved);
    }

    @Override
    public CategoryResponseDto getCategoryById(Long id) {
        Category category = categoryRepository.findById(id).orElse(null); // Or throw exception
        return category != null ? categoryMapper.toResponseDto(category) : null;
    }
}
