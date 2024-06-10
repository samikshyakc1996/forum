package com.example.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import com.example.forum.model.User;
import java.util.Optional;
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
