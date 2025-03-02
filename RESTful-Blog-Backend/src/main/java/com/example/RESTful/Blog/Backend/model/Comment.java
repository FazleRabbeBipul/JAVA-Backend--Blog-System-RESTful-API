package com.example.RESTful.Blog.Backend.model;

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

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private BlogUser author;

    @ManyToOne
    @JoinColumn(name = "blogpost_id", nullable = false)
    private BlogPost blogPost;
}
