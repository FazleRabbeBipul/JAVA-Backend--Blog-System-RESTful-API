package com.example.RESTful.Blog.Backend.user.controller;

import com.example.RESTful.Blog.Backend.user.dto.request.UserDetailsRequestDto;
import com.example.RESTful.Blog.Backend.user.dto.response.UserDetailsResponseDto;
import com.example.RESTful.Blog.Backend.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor

public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDetailsResponseDto> registerUser(@Valid @RequestBody UserDetailsRequestDto user) {
        UserDetailsResponseDto savedUser = userService.saveUser(user);
        return ResponseEntity.status(201).body(savedUser);
    }

    @GetMapping
    public ResponseEntity<List<UserDetailsResponseDto>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        Optional<UserDetailsResponseDto> user = userService.getUserById(id);
        return user.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id)
                ? ResponseEntity.ok("User deleted successfully.")
                : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDetailsResponseDto> updateUser(
            @PathVariable Long id,
            @Valid @RequestBody UserDetailsRequestDto userDto) {
        UserDetailsResponseDto updatedUser = userService.updateUser(id, userDto);
        return ResponseEntity.ok(updatedUser);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserDetailsResponseDto> partialUpdateUser(
            @PathVariable Long id,
            @RequestBody UserDetailsRequestDto userDto) {
        UserDetailsResponseDto updatedUser = userService.partialUpdateUser(id, userDto);
        return ResponseEntity.ok(updatedUser);
    }

}
