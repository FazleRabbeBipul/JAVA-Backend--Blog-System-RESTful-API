package com.example.RESTful.Blog.Backend.user.model;

import jakarta.persistence.*;
import lombok.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Username is mandatory")
    private String username;

    @Email(message = "Email should be valid" )
    @NotBlank(message = "Email is mandatory")
    @Column(unique = true ) //  uniqueness at the database level
    private String email;

    @NotBlank(message = "Password is mandatory")
    private String password;
}

