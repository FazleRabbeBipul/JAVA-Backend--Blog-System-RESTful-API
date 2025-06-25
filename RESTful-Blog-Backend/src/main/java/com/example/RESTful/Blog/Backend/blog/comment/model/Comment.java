package com.example.RESTful.Blog.Backend.blog.comment.model;

import com.example.RESTful.Blog.Backend.blog.post.model.BlogPost;
import com.example.RESTful.Blog.Backend.user.model.UserDetails;
import jakarta.persistence.*;
import lombok.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Content is mandatory")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)  // lazy fetch, load when accessed
    @JoinColumn(name = "user_id", nullable = false)
    private UserDetails author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "blogpost_id", nullable = false)
    private BlogPost blogPost;
}
