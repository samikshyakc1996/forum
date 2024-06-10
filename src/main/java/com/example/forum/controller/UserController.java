package com.example.forum.controller;

import com.example.forum.model.User;
import com.example.forum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, World!!!";
    }
    // Get current user's profile
    @GetMapping("/profile")
    public User getProfile(@AuthenticationPrincipal OAuth2User principal) {
        String email = principal.getAttribute("email");
        Optional<User> user = userService.findByEmail(email);
        return user.orElse(null);
    }
    // Update user's profile
    @PutMapping("/profile")
    public User updateProfile(@RequestBody User updatedUser, @AuthenticationPrincipal OAuth2User principal) {
        String email = principal.getAttribute("email");
        Optional<User> user = userService.findByEmail(email);
        if (user.isPresent()) {
            updatedUser.setId(user.get().getId());
            updatedUser.setEmail(email);
            return userService.saveUserProfile(updatedUser);
        }
        return null;
    }
}