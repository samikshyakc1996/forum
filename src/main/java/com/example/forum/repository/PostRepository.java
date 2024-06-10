package com.example.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.forum.model.Post;
import com.example.forum.model.User;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByUser(User user);

}
