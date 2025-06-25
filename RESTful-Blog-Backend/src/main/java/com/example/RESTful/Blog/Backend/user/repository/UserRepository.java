package com.example.RESTful.Blog.Backend.user.repository;

import com.example.RESTful.Blog.Backend.user.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDetails, Long> {
    boolean existsByEmail(String email);

}
