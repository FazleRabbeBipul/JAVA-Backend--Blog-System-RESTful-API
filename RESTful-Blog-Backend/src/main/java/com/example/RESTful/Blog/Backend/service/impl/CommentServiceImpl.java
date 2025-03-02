package com.example.RESTful.Blog.Backend.service.impl;

import com.example.RESTful.Blog.Backend.model.Comment;
import com.example.RESTful.Blog.Backend.repository.CommentRepository;
import com.example.RESTful.Blog.Backend.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    @Override
    public Comment addComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Comment updateComment(Long id, Comment updatedComment) {
        Optional<Comment> existingComment = commentRepository.findById(id);
        if (existingComment.isPresent()) {
            Comment comment = existingComment.get();
            comment.setContent(updatedComment.getContent()); // Only update content
            return commentRepository.save(comment);
        }
        return null; // Return null if comment not found
    }

    @Override
    public void deleteComment(Long id) {
        if (commentRepository.existsById(id)) {
            commentRepository.deleteById(id);
        }
    }

    @Override
    public Comment getCommentById(Long id) {
        return commentRepository.findById(id).orElse(null); // Returns null if not found
    }

    @Override
    public List<Comment> getCommentsByBlogPostId(Long blogPostId) {
        return commentRepository.findByBlogPostId(blogPostId);
    }

}
