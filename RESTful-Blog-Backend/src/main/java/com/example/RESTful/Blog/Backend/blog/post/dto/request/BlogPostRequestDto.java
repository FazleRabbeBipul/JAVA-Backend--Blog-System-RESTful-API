package com.example.RESTful.Blog.Backend.blog.post.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.example.RESTful.Blog.Backend.blog.category.dto.request.CategoryRequestDto;
import com.example.RESTful.Blog.Backend.user.dto.request.UserDetailsRequestDto;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BlogPostRequestDto {
    private Long id;

    @NotBlank(message = "Title is mandatory")
    private String title;

    @NotBlank(message = "Content is mandatory")
    private String content;

    private LocalDateTime createdAt;

    @NotNull(message = "Category is mandatory")
    private CategoryRequestDto category;

    @NotNull(message = "Author is mandatory")
    private UserDetailsRequestDto author;
}
