package com.example.RESTful.Blog.Backend.blog.comment.mapper;

import com.example.RESTful.Blog.Backend.blog.comment.dto.CommentRequestDto;
import com.example.RESTful.Blog.Backend.blog.comment.dto.CommentResponseDto;
import com.example.RESTful.Blog.Backend.blog.comment.model.Comment;
import com.example.RESTful.Blog.Backend.blog.post.mapper.BlogPostMapper;
import com.example.RESTful.Blog.Backend.user.mapper.UserDetailsMapper;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserDetailsMapper.class, BlogPostMapper.class})
public interface CommentMapper {
    CommentResponseDto toResponseDto(Comment comment);
    Comment toEntity(CommentRequestDto commentDto);
}