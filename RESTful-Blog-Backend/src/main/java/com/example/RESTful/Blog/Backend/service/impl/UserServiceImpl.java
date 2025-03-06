package com.example.RESTful.Blog.Backend.service.impl;

import com.example.RESTful.Blog.Backend.model.BlogUser;
import com.example.RESTful.Blog.Backend.repository.UserRepository;
import com.example.RESTful.Blog.Backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    @Override
//    public BlogUser saveUser(BlogUser user) {
//        return userRepository.save(user);
//    }
    @Override
    public BlogUser saveUser(BlogUser user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new IllegalArgumentException("Email is already taken");
        }
        return userRepository.save(user);
    }



    @Override
    public List<BlogUser> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<BlogUser> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public boolean deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
