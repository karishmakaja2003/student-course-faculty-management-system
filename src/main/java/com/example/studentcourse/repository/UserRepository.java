package com.example.studentcourse.repository;

import com.example.studentcourse.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

    // Custom query method to find user by userId and password
    Optional<User> findByUserIdAndPassword(String userId, String password);

    // Optional: For login validation and role-based access
    Optional<User> findByUserId(String userId);

    boolean existsById(String userId);
}
