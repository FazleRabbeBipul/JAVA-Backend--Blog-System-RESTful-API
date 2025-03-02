package com.example.RESTful.Blog.Backend.service;

import com.example.RESTful.Blog.Backend.model.BlogPost;
import com.example.RESTful.Blog.Backend.model.Category;

import java.util.List;

public interface BlogPostService {
    List<BlogPost> getAllPosts();
    BlogPost createPost(BlogPost post);
    BlogPost getBlogPostById(Long id);
    BlogPost updateBlogPost(Long id, BlogPost updatedPost);
    void deleteBlogPost(Long id);
}
