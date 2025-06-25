package com.example.RESTful.Blog.Backend.user.validator;

import com.example.RESTful.Blog.Backend.user.model.UserDetails;
import com.example.RESTful.Blog.Backend.user.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class UserUpdateValidator {

    private final UserRepository userRepository;

    public UserUpdateValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void validateEmailForUpdate(UserDetails existingUser, String newEmail) {
        if (newEmail != null && !newEmail.equals(existingUser.getEmail())) {
            if (userRepository.existsByEmail(newEmail)) {
                throw new IllegalArgumentException("Email is already taken");
            }
        }
    }
}