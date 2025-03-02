package com.example.RESTful.Blog.Backend.service.impl;

import com.example.RESTful.Blog.Backend.model.BlogUser;
import com.example.RESTful.Blog.Backend.repository.UserRepository;
import com.example.RESTful.Blog.Backend.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public BlogUser saveUser(BlogUser user) {
        return userRepository.save(user);
    }
}
