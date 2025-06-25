package com.example.RESTful.Blog.Backend.blog.comment.repository;

import com.example.RESTful.Blog.Backend.blog.comment.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByBlogPostId(Long blogPostId);
}