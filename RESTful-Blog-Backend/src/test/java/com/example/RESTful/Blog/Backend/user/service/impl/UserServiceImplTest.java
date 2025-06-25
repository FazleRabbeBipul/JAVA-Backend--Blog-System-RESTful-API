package com.example.RESTful.Blog.Backend.user.service.impl;

import com.example.RESTful.Blog.Backend.user.dto.request.UserDetailsRequestDto;
import com.example.RESTful.Blog.Backend.user.dto.response.UserDetailsResponseDto;
import com.example.RESTful.Blog.Backend.user.mapper.UserDetailsMapper;
import com.example.RESTful.Blog.Backend.user.model.UserDetails;
import com.example.RESTful.Blog.Backend.user.repository.UserRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserDetailsMapper userDetailsMapper;

    @BeforeEach
    void setUp() {
        // Mockito annotations initialized via @ExtendWith
    }

    @Test
    void saveUser_shouldSaveSuccessfully_whenEmailNotExists() {
        UserDetailsRequestDto requestDto = new UserDetailsRequestDto();
        requestDto.setEmail("test@example.com");

        UserDetails userEntity = new UserDetails();
        UserDetails savedUser = new UserDetails();
        UserDetailsResponseDto responseDto = new UserDetailsResponseDto();

        when(userRepository.existsByEmail(requestDto.getEmail())).thenReturn(false);
        when(userDetailsMapper.toEntity(requestDto)).thenReturn(userEntity);
        when(userRepository.save(userEntity)).thenReturn(savedUser);
        when(userDetailsMapper.toDto(savedUser)).thenReturn(responseDto);

        UserDetailsResponseDto result = userService.saveUser(requestDto);

        assertNotNull(result);
        assertEquals(responseDto, result);
    }

    @Test
    void saveUser_shouldThrowException_whenEmailAlreadyExists() {
        UserDetailsRequestDto requestDto = new UserDetailsRequestDto();
        requestDto.setEmail("duplicate@example.com");

        when(userRepository.existsByEmail(requestDto.getEmail())).thenReturn(true);

        assertThrows(IllegalArgumentException.class, () -> userService.saveUser(requestDto));
    }

    @Test
    void getAllUsers_shouldReturnListOfUsers() {
        List<UserDetails> userList = List.of(new UserDetails(), new UserDetails());

        when(userRepository.findAll()).thenReturn(userList);
        when(userDetailsMapper.toDto(any())).thenReturn(new UserDetailsResponseDto());

        List<UserDetailsResponseDto> result = userService.getAllUsers();

        assertEquals(3, result.size());
    }

    @Test
    void getUserById_shouldReturnUser_whenExists() {
        UserDetails user = new UserDetails();
        user.setId(100L);

        UserDetailsResponseDto responseDto = new UserDetailsResponseDto();

        when(userRepository.findById(100L)).thenReturn(Optional.of(user));
        when(userDetailsMapper.toDto(user)).thenReturn(responseDto);

        Optional<UserDetailsResponseDto> result = userService.getUserById(100L);

        assertTrue(result.isPresent());
        assertEquals(responseDto, result.get());

        assertEquals(100, result.get().getId());
    }

    @Test
    void getUserById_shouldReturnEmpty_whenNotExists() {
        when(userRepository.findById(99L)).thenReturn(Optional.empty());

        Optional<UserDetailsResponseDto> result = userService.getUserById(99L);

        assertTrue(result.isEmpty());
    }

    @Test
    void deleteUser_shouldReturnTrue_whenUserExists() {
        when(userRepository.existsById(1L)).thenReturn(true);

        boolean result = userService.deleteUser(1L);

        assertTrue(result);
        verify(userRepository).deleteById(1L);
    }

    @Test
    void deleteUser_shouldReturnFalse_whenUserNotExists() {
        when(userRepository.existsById(100L)).thenReturn(false);

        boolean result = userService.deleteUser(100L);

        assertFalse(result);
        verify(userRepository, never()).deleteById(any());
    }
}
