package com.example.RESTful.Blog.Backend.service.impl;

import com.example.RESTful.Blog.Backend.model.BlogPost;
import com.example.RESTful.Blog.Backend.model.Category;
import com.example.RESTful.Blog.Backend.repository.BlogPostRepository;
import com.example.RESTful.Blog.Backend.service.BlogPostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BlogPostServiceImpl implements BlogPostService {
    private final BlogPostRepository blogPostRepository;

    @Autowired
    public BlogPostServiceImpl(BlogPostRepository blogPostRepository) {
        this.blogPostRepository = blogPostRepository;
    }

    @Override
    public List<BlogPost> getAllPosts() {
        return blogPostRepository.findAll();
    }

    @Override
    public BlogPost createPost(BlogPost post) {
        return blogPostRepository.save(post);
    }

    @Override
    public BlogPost getBlogPostById(Long id) {
        return blogPostRepository.findById(id).orElse(null); // Returns null if not found
    }

    @Override
    public void deleteBlogPost(Long id) {
        if (!blogPostRepository.existsById(id)) {
            throw new RuntimeException("Blog post not found with id: " + id);
        }
        blogPostRepository.deleteById(id);
    }

    @Override
    public BlogPost updateBlogPost(Long id, BlogPost updatedPost) {
        return blogPostRepository.findById(id).map(existingPost -> {
            existingPost.setTitle(updatedPost.getTitle());
            existingPost.setContent(updatedPost.getContent());
            existingPost.setCategory(updatedPost.getCategory());

            return blogPostRepository.save(existingPost);
        }).orElseThrow(() -> new RuntimeException("Blog post not found with id: " + id));
    }


}
