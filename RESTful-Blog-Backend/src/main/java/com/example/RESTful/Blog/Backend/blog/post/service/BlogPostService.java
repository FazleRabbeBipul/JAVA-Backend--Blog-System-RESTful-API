package com.example.RESTful.Blog.Backend.blog.post.service;

import com.example.RESTful.Blog.Backend.blog.post.dto.request.BlogPostRequestDto;
import com.example.RESTful.Blog.Backend.blog.post.dto.response.BlogPostResponseDto;

import java.util.List;

public interface BlogPostService {

    List<BlogPostResponseDto> getAllPosts();
    BlogPostResponseDto createPost(BlogPostRequestDto postDto);
    BlogPostResponseDto getBlogPostById(Long id);
    BlogPostResponseDto updateBlogPost(Long id, BlogPostRequestDto updatedPostDto);
    void deleteBlogPost(Long id);
}
