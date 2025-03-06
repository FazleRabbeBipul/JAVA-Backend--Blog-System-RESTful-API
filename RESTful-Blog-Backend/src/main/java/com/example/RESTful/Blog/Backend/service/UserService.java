package com.example.RESTful.Blog.Backend.service;

import com.example.RESTful.Blog.Backend.model.BlogUser;
import java.util.List;
import java.util.Optional;

public interface UserService {
    BlogUser saveUser(BlogUser user);
    List<BlogUser> getAllUsers(); // Get all users
    Optional<BlogUser> getUserById(Long id); //  Get user by ID
    boolean deleteUser(Long id);  // Delete user by ID
}
