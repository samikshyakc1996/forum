package com.example.forum.service;
import com.example.forum.model.User;
import com.example.forum.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Create or update a user profile
    public User saveUserProfile(User user) {
        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            User currentUser = existingUser.get();
            currentUser.setUsername(user.getUsername());
           // currentUser.setProfilePicture(user.getProfilePicture());
            return userRepository.save(currentUser);
        } else {
            return userRepository.save(user);
        }
    }

    // Find a user by email
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // Find a user by ID
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }
}
