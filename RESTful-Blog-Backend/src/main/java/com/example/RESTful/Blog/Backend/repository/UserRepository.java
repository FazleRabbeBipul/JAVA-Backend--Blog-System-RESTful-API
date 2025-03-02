package com.example.RESTful.Blog.Backend.repository;

import com.example.RESTful.Blog.Backend.model.BlogUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<BlogUser, Long> {
}
