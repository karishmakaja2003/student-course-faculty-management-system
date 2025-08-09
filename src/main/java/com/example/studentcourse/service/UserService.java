package com.example.studentcourse.service;

import com.example.studentcourse.entity.User;
import com.example.studentcourse.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Register a new user
    public User register(User user) {
        return userRepository.save(user);
    }

   
    public Optional<User> login(String userId, String password) {
        return userRepository.findByUserIdAndPassword(userId, password);
    }

   
    public Optional<User> getUserByUserId(String userId) {
        return userRepository.findByUserId(userId);
    }

    // Check if user exists by userId
    public boolean userExists(String userId) {
        return userRepository.existsById(userId);
    }
}
