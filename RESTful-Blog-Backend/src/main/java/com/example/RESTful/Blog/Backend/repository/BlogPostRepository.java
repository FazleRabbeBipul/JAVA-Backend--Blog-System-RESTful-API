package com.example.RESTful.Blog.Backend.repository;

import com.example.RESTful.Blog.Backend.model.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {
}
