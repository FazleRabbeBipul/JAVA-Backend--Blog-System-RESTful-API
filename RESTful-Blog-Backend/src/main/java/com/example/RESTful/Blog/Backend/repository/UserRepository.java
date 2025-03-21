package com.example.RESTful.Blog.Backend.repository;

import com.example.RESTful.Blog.Backend.model.BlogUser;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Optional;

public interface UserRepository extends JpaRepository<BlogUser, Long> {
    boolean existsByEmail(String email);

}
