package com.example.RESTful.Blog.Backend.blog.comment.dto;

import com.example.RESTful.Blog.Backend.blog.post.dto.request.BlogPostRequestDto;
import com.example.RESTful.Blog.Backend.user.dto.request.UserDetailsRequestDto;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class CommentRequestDto {

    private Long id; // Optional, useful for updates

    @NotBlank(message = "Content is mandatory")
    private String content;

    @NotNull(message = "Author is required")
    private UserDetailsRequestDto author;

    @NotNull(message = "BlogPost is required")
    private BlogPostRequestDto blogPost;
}
