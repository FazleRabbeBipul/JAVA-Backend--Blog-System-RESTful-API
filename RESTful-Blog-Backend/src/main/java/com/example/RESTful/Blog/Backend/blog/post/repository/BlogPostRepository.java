package com.example.RESTful.Blog.Backend.blog.post.repository;

import com.example.RESTful.Blog.Backend.blog.post.model.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {
}
