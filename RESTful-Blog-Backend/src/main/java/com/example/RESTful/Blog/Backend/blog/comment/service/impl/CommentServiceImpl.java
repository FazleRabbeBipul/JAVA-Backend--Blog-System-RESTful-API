package com.example.RESTful.Blog.Backend.blog.comment.service.impl;

import com.example.RESTful.Blog.Backend.blog.comment.dto.CommentRequestDto;
import com.example.RESTful.Blog.Backend.blog.comment.dto.CommentResponseDto;
import com.example.RESTful.Blog.Backend.blog.comment.mapper.CommentMapper;
import com.example.RESTful.Blog.Backend.blog.comment.model.Comment;
import com.example.RESTful.Blog.Backend.blog.comment.repository.CommentRepository;
import com.example.RESTful.Blog.Backend.blog.comment.service.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, CommentMapper commentMapper) {
        this.commentRepository = commentRepository;
        this.commentMapper = commentMapper;
    }

    @Override
    public List<CommentResponseDto> getAllComments() {
        return commentRepository.findAll()
                .stream()
                .map(commentMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public CommentResponseDto addComment(CommentRequestDto commentDto) {
        Comment comment = commentMapper.toEntity(commentDto);
        Comment savedComment = commentRepository.save(comment);
        return commentMapper.toResponseDto(savedComment);
    }

    @Override
    public CommentResponseDto updateComment(Long id, CommentRequestDto updatedCommentDto) {
        Optional<Comment> existingComment = commentRepository.findById(id);
        if (existingComment.isPresent()) {
            Comment comment = existingComment.get();
            // Only updating content as per original logic
            comment.setContent(updatedCommentDto.getContent());
            Comment savedComment = commentRepository.save(comment);
            return commentMapper.toResponseDto(savedComment);
        }
        return null; // or consider throwing exception for not found
    }

    @Override
    public void deleteComment(Long id) {
        if (commentRepository.existsById(id)) {
            commentRepository.deleteById(id);
        }
    }

    @Override
    public CommentResponseDto getCommentById(Long id) {
        Optional<Comment> comment = commentRepository.findById(id);
        return comment.map(commentMapper::toResponseDto).orElse(null);
    }

    @Override
    public List<CommentResponseDto> getCommentsByBlogPostId(Long blogPostId) {
        return commentRepository.findByBlogPostId(blogPostId)
                .stream()
                .map(commentMapper::toResponseDto)
                .collect(Collectors.toList());
    }
}
