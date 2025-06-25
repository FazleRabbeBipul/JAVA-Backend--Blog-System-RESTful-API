package com.example.RESTful.Blog.Backend.blog.category.dto.request;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CategoryRequestDto {
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;
}
