
package com.example.RESTful.Blog.Backend.service;

import com.example.RESTful.Blog.Backend.model.Comment;
import java.util.List;

public interface CommentService {
    List<Comment> getAllComments();
    Comment addComment(Comment comment);
    Comment updateComment(Long id, Comment updatedComment);
    void deleteComment(Long id);

    Comment getCommentById(Long id);
    List<Comment> getCommentsByBlogPostId(Long blogPostId);


}
