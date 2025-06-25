package com.example.RESTful.Blog.Backend.user.service;

import com.example.RESTful.Blog.Backend.user.dto.request.UserDetailsRequestDto;
import com.example.RESTful.Blog.Backend.user.dto.response.UserDetailsResponseDto;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserDetailsResponseDto saveUser(UserDetailsRequestDto user);
    List<UserDetailsResponseDto> getAllUsers(); // Get all users
    Optional<UserDetailsResponseDto> getUserById(Long id); //  Get user by ID
    boolean deleteUser(Long id);  // Delete user by ID
    UserDetailsResponseDto updateUser(Long id, UserDetailsRequestDto user);
    UserDetailsResponseDto partialUpdateUser(Long id, UserDetailsRequestDto user);
}
