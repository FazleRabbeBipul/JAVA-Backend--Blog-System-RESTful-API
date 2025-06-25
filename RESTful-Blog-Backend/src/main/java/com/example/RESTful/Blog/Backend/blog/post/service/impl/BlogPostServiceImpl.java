package com.example.RESTful.Blog.Backend.blog.post.service.impl;

import com.example.RESTful.Blog.Backend.blog.post.dto.request.BlogPostRequestDto;
import com.example.RESTful.Blog.Backend.blog.post.dto.response.BlogPostResponseDto;
import com.example.RESTful.Blog.Backend.blog.post.mapper.BlogPostMapper;
import com.example.RESTful.Blog.Backend.blog.post.model.BlogPost;
import com.example.RESTful.Blog.Backend.blog.post.repository.BlogPostRepository;
import com.example.RESTful.Blog.Backend.blog.post.service.BlogPostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogPostServiceImpl implements BlogPostService {

    private final BlogPostRepository blogPostRepository;
    private final BlogPostMapper blogPostMapper;

    @Autowired
    public BlogPostServiceImpl(BlogPostRepository blogPostRepository, BlogPostMapper blogPostMapper) {
        this.blogPostRepository = blogPostRepository;
        this.blogPostMapper = blogPostMapper;
    }

    @Override
    public List<BlogPostResponseDto> getAllPosts() {
        return blogPostRepository.findAll()
                .stream()
                .map(blogPostMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public BlogPostResponseDto createPost(BlogPostRequestDto postDto) {
        BlogPost post = blogPostMapper.toEntity(postDto);
        BlogPost savedPost = blogPostRepository.save(post);
        return blogPostMapper.toResponseDto(savedPost);
    }

    @Override
    public BlogPostResponseDto getBlogPostById(Long id) {
        BlogPost post = blogPostRepository.findById(id)
                .orElse(null); // or throw exception
        return post != null ? blogPostMapper.toResponseDto(post) : null;
    }

    @Override
    public void deleteBlogPost(Long id) {
        if (!blogPostRepository.existsById(id)) {
            throw new RuntimeException("Blog post not found with id: " + id);
        }
        blogPostRepository.deleteById(id);
    }

    @Override
    public BlogPostResponseDto updateBlogPost(Long id, BlogPostRequestDto updatedPostDto) {
        return blogPostRepository.findById(id)
                .map(existingPost -> {
                    BlogPost updatedPost = blogPostMapper.toEntity(updatedPostDto);
                    existingPost.setTitle(updatedPost.getTitle());
                    existingPost.setContent(updatedPost.getContent());
                    existingPost.setCategory(updatedPost.getCategory());
                    existingPost.setAuthor(updatedPost.getAuthor());

                    BlogPost savedPost = blogPostRepository.save(existingPost);
                    return blogPostMapper.toResponseDto(savedPost);
                })
                .orElseThrow(() -> new RuntimeException("Blog post not found with id: " + id));
    }
}
