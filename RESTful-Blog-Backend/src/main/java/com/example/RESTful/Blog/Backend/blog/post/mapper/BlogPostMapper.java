package com.example.RESTful.Blog.Backend.blog.post.mapper;

import com.example.RESTful.Blog.Backend.blog.category.mapper.CategoryMapper;
import com.example.RESTful.Blog.Backend.blog.post.dto.request.BlogPostRequestDto;
import com.example.RESTful.Blog.Backend.blog.post.dto.response.BlogPostResponseDto;
import com.example.RESTful.Blog.Backend.blog.post.model.BlogPost;
import com.example.RESTful.Blog.Backend.user.mapper.UserDetailsMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class, UserDetailsMapper.class})
public interface BlogPostMapper {
    BlogPostResponseDto toResponseDto(BlogPost blogPost);
    BlogPost toEntity(BlogPostRequestDto dto);
}
