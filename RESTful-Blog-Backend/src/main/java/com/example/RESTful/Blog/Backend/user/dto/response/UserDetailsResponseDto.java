package com.example.RESTful.Blog.Backend.user.dto.response;

import lombok.Data;

@Data
public class UserDetailsResponseDto {
    private Long id;
    private String username;
    private String email;
    //private String password;
}
