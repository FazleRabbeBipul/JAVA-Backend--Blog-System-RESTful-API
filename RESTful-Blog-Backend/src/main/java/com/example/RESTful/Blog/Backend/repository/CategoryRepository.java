package com.example.RESTful.Blog.Backend.repository;

import com.example.RESTful.Blog.Backend.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
