package com.example.studentcourse.repository;

import com.example.studentcourse.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByCourseId(Long courseId); // ✅ Query by foreign key
}
