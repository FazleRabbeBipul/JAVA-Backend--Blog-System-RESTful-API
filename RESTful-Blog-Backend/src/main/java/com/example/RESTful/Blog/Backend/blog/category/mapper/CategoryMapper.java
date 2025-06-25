package com.example.RESTful.Blog.Backend.blog.category.mapper;

import com.example.RESTful.Blog.Backend.blog.category.dto.request.CategoryRequestDto;
import com.example.RESTful.Blog.Backend.blog.category.dto.response.CategoryResponseDto;
import com.example.RESTful.Blog.Backend.blog.category.model.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryResponseDto toResponseDto(Category category);
    Category toEntity(CategoryRequestDto dto);
}
