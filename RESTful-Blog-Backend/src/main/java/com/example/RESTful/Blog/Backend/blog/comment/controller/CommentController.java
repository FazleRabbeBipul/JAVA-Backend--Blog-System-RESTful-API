package com.example.RESTful.Blog.Backend.blog.comment.controller;

import com.example.RESTful.Blog.Backend.blog.comment.dto.CommentRequestDto;
import com.example.RESTful.Blog.Backend.blog.comment.dto.CommentResponseDto;
import com.example.RESTful.Blog.Backend.blog.comment.service.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public List<CommentResponseDto> getAllComments() {
        return commentService.getAllComments();
    }

    @PostMapping
    public CommentResponseDto addComment(@RequestBody CommentRequestDto commentDto) {
        return commentService.addComment(commentDto);
    }

    @PutMapping("/{id}")
    public CommentResponseDto updateComment(@PathVariable Long id, @RequestBody CommentRequestDto updatedCommentDto) {
        return commentService.updateComment(id, updatedCommentDto);
    }

    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentResponseDto> getCommentById(@PathVariable Long id) {
        CommentResponseDto comment = commentService.getCommentById(id);
        if (comment != null) {
            return ResponseEntity.ok(comment);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/post/{postId}")
    public ResponseEntity<List<CommentResponseDto>> getCommentsByPostId(@PathVariable Long postId) {
        List<CommentResponseDto> comments = commentService.getCommentsByBlogPostId(postId);
        return ResponseEntity.ok(comments);
    }
}
