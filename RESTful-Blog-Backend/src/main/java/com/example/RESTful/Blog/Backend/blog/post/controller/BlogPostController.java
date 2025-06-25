package com.example.RESTful.Blog.Backend.blog.post.controller;

import com.example.RESTful.Blog.Backend.blog.post.dto.request.BlogPostRequestDto;
import com.example.RESTful.Blog.Backend.blog.post.dto.response.BlogPostResponseDto;
import com.example.RESTful.Blog.Backend.blog.post.service.BlogPostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogs")
public class BlogPostController {

    private final BlogPostService blogPostService;

    @Autowired
    public BlogPostController(BlogPostService blogPostService) {
        this.blogPostService = blogPostService;
    }

    @GetMapping
    public List<BlogPostResponseDto> getAllPosts() {
        return blogPostService.getAllPosts();
    }

    @PostMapping
    public BlogPostResponseDto createPost(@RequestBody BlogPostRequestDto postDto) {
        return blogPostService.createPost(postDto);
    }

    @GetMapping("/{id}")
    public BlogPostResponseDto getBlogPostById(@PathVariable Long id) {
        return blogPostService.getBlogPostById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BlogPostResponseDto> updateBlogPost(
            @PathVariable Long id,
            @RequestBody BlogPostRequestDto updatedPostDto
    ) {
        BlogPostResponseDto updated = blogPostService.updateBlogPost(id, updatedPostDto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBlogPost(@PathVariable Long id) {
        blogPostService.deleteBlogPost(id);
        return ResponseEntity.ok("Blog post deleted successfully.");
    }
}
