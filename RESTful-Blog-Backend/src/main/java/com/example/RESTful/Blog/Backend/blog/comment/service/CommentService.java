
package com.example.RESTful.Blog.Backend.blog.comment.service;

import com.example.RESTful.Blog.Backend.blog.comment.dto.CommentRequestDto;
import com.example.RESTful.Blog.Backend.blog.comment.dto.CommentResponseDto;

import java.util.List;

public interface CommentService {

    List<CommentResponseDto> getAllComments();
    CommentResponseDto addComment(CommentRequestDto commentDto);
    CommentResponseDto updateComment(Long id, CommentRequestDto updatedCommentDto);
    void deleteComment(Long id);

    CommentResponseDto getCommentById(Long id);
    List<CommentResponseDto> getCommentsByBlogPostId(Long blogPostId);

}
