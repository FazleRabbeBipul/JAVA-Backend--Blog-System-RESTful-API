package com.example.RESTful.Blog.Backend.blog.post.dto.response;

import java.time.LocalDateTime;

import com.example.RESTful.Blog.Backend.blog.category.dto.response.CategoryResponseDto;
import com.example.RESTful.Blog.Backend.user.dto.response.UserDetailsResponseDto;

import lombok.Data;

@Data
public class BlogPostResponseDto {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private CategoryResponseDto category;
    private UserDetailsResponseDto author;
}
