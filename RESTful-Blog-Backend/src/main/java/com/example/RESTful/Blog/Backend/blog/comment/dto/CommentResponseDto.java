package com.example.RESTful.Blog.Backend.blog.comment.dto;

import com.example.RESTful.Blog.Backend.blog.post.dto.response.BlogPostResponseDto;
import com.example.RESTful.Blog.Backend.user.dto.response.UserDetailsResponseDto;
import lombok.Data;

@Data
public class CommentResponseDto {

    private Long id;
    private String content;
    private UserDetailsResponseDto author;
    private BlogPostResponseDto blogPost;
}