package com.example.studentcourse.controller;

import com.example.studentcourse.entity.User;
import com.example.studentcourse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User loginData) {
        Optional<User> userOpt = userService.login(loginData.getUserId(), loginData.getPassword());

        if (userOpt.isPresent()) {
            User user = userOpt.get();

            String role = user.getUserType();  // <-- Use getUserType()
            if (role == null || role.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Unknown role.");
            }

            Map<String, Object> response = new HashMap<>();
            response.put("userId", user.getUserId());
            response.put("username", user.getUsername());
            response.put("role", role);

            return ResponseEntity.ok(response);

        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

}
