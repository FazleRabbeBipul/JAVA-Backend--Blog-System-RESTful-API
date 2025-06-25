package com.example.RESTful.Blog.Backend.user.controller;


import com.example.RESTful.Blog.Backend.user.dto.request.UserDetailsRequestDto;
import com.example.RESTful.Blog.Backend.user.dto.response.UserDetailsResponseDto;
import com.example.RESTful.Blog.Backend.user.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
@ExtendWith(SpringExtension.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void registerUser_shouldReturnCreatedUser() throws Exception {
        UserDetailsRequestDto requestDto = new UserDetailsRequestDto();
        requestDto.setEmail("test@example.com");

        UserDetailsResponseDto responseDto = new UserDetailsResponseDto();
        responseDto.setEmail("test@example.com");

        Mockito.when(userService.saveUser(any())).thenReturn(responseDto);

        mockMvc.perform(post("/users/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.email").value("test@example.com"));
    }

    @Test
    void getAllUsers_shouldReturnList() throws Exception {
        UserDetailsResponseDto user1 = new UserDetailsResponseDto();
        user1.setEmail("a@example.com");

        UserDetailsResponseDto user2 = new UserDetailsResponseDto();
        user2.setEmail("b@example.com");

        Mockito.when(userService.getAllUsers()).thenReturn(List.of(user1, user2));

        mockMvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].email").value("a@example.com"))
                .andExpect(jsonPath("$[1].email").value("b@example.com"));
    }

    @Test
    void getUserById_shouldReturnUser_whenExists() throws Exception {
        UserDetailsResponseDto user = new UserDetailsResponseDto();
        user.setEmail("found@example.com");

        Mockito.when(userService.getUserById(1L)).thenReturn(Optional.of(user));

        mockMvc.perform(get("/users/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value("found@example.com"));
    }

    @Test
    void getUserById_shouldReturnNotFound_whenMissing() throws Exception {
        Mockito.when(userService.getUserById(99L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/users/99"))
                .andExpect(status().isNotFound());
    }

    @Test
    void deleteUser_shouldReturnSuccess_whenDeleted() throws Exception {
        Mockito.when(userService.deleteUser(1L)).thenReturn(true);

        mockMvc.perform(delete("/users/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("User deleted successfully."));
    }

    @Test
    void deleteUser_shouldReturnNotFound_whenMissing() throws Exception {
        Mockito.when(userService.deleteUser(100L)).thenReturn(false);

        mockMvc.perform(delete("/users/100"))
                .andExpect(status().isNotFound());
    }
}
