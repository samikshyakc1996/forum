package com.example.forum.service;

import com.example.forum.model.Post;
import com.example.forum.model.User;
import com.example.forum.repository.PostRepository;
import com.example.forum.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    // Create a new post
    public Post createPost(Post post, String email) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            post.setUser(user);
            post.setCreatedAt(LocalDateTime.now());
            return postRepository.save(post);
        }
        return null;
    }

    // Get a post by ID
    public Optional<Post> getPostById(Long id) {
        return postRepository.findById(id);
    }

    // Get all posts
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    // Get posts by user
    public List<Post> getPostsByUser(String email) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        return userOptional.map(user -> postRepository.findByUser(user)).orElse(null);
    }

    // Update a post
    public Post updatePost(Long id, Post updatedPost) {
        Optional<Post> postOptional = postRepository.findById(id);
        if (postOptional.isPresent()) {
            Post post = postOptional.get();
            post.setTitle(updatedPost.getTitle());
            post.setContent(updatedPost.getContent());
            return postRepository.save(post);
        }
        return null;
    }

    // Delete a post
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}

