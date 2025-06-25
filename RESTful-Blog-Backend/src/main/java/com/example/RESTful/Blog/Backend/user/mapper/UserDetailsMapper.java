package com.example.RESTful.Blog.Backend.user.mapper;

import com.example.RESTful.Blog.Backend.user.dto.request.UserDetailsRequestDto;
import com.example.RESTful.Blog.Backend.user.dto.response.UserDetailsResponseDto;
import com.example.RESTful.Blog.Backend.user.model.UserDetails;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserDetailsMapper {
    UserDetailsResponseDto toDto(UserDetails userDetails);
    UserDetails toEntity(UserDetailsRequestDto userDetailsRequestDto);
}
