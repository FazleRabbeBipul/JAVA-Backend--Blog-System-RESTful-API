package com.example.RESTful.Blog.Backend.controller;

import com.example.RESTful.Blog.Backend.model.BlogUser;
import com.example.RESTful.Blog.Backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public BlogUser registerUser(@RequestBody BlogUser user) {
        return userService.saveUser(user);
    }
}
