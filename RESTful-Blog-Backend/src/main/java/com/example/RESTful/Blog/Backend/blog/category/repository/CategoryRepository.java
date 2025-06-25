package com.example.RESTful.Blog.Backend.blog.category.repository;

import com.example.RESTful.Blog.Backend.blog.category.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
