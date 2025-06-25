package com.example.RESTful.Blog.Backend.user.service.impl;

import com.example.RESTful.Blog.Backend.user.dto.request.UserDetailsRequestDto;
import com.example.RESTful.Blog.Backend.user.dto.response.UserDetailsResponseDto;
import com.example.RESTful.Blog.Backend.user.mapper.UserDetailsMapper;
import com.example.RESTful.Blog.Backend.user.model.UserDetails;
import com.example.RESTful.Blog.Backend.user.repository.UserRepository;
import com.example.RESTful.Blog.Backend.user.service.UserService;
import com.example.RESTful.Blog.Backend.user.validator.UserUpdateValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserDetailsMapper userDetailsMapper;
    private final UserUpdateValidator userUpdateValidator;


    @Override
    public UserDetailsResponseDto saveUser(UserDetailsRequestDto user) {
        System.out.println("Received DTO: " + user);
        UserDetails userDetails = userDetailsMapper.toEntity(user);
        System.out.println("Mapped Entity: " + userDetails);

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new IllegalArgumentException("Email is already taken");
        }
        UserDetails newUserDetails = userRepository.save(userDetails);

        return userDetailsMapper.toDto(newUserDetails);
    }


    @Override
    public List<UserDetailsResponseDto> getAllUsers() {
        return userRepository.findAll()
                .stream().map(userDetailsMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<UserDetailsResponseDto> getUserById(Long id) {
        return userRepository.findById(id)
                .map(userDetailsMapper::toDto);
    }

    @Override
    public boolean deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public UserDetailsResponseDto updateUser(Long id, UserDetailsRequestDto user) {
        UserDetails existingUser = userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found"));

        userUpdateValidator.validateEmailForUpdate(existingUser, user.getEmail());

        // Full update: overwrite all fields
        existingUser.setUsername(user.getUsername());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());

        UserDetails updated = userRepository.save(existingUser);
        return userDetailsMapper.toDto(updated);
    }

    @Override
    public UserDetailsResponseDto partialUpdateUser(Long id, UserDetailsRequestDto user) {
        UserDetails existingUser = userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found"));

        if (user.getUsername() != null) {
            existingUser.setUsername(user.getUsername());
        }
        if (user.getEmail() != null && !user.getEmail().equals(existingUser.getEmail())) {
            userUpdateValidator.validateEmailForUpdate(existingUser, user.getEmail());
            existingUser.setEmail(user.getEmail());
        }
        if (user.getPassword() != null) {
            existingUser.setPassword(user.getPassword());
        }

        UserDetails updated = userRepository.save(existingUser);
        return userDetailsMapper.toDto(updated);
    }
}
