package com.example.studentcourse.controller;

import com.example.studentcourse.service.StudentService;
import com.example.studentcourse.entity.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "*")

public class StudentController {

    @Autowired
    private StudentService studentService;

    // Create
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    // Read all
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    // Read by ID
    @GetMapping("/{id}")
    public Optional<Student> getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    // Update
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent) {
        return studentService.updateStudent(id, updatedStudent);
    }

    // Delete
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

    // Enroll Course
    @PutMapping("/{studentId}/enroll/{courseId}")
    public Student enrollCourse(@PathVariable Long studentId, @PathVariable Long courseId) {
        return studentService.enrollStudentInCourse(studentId, courseId);
    }
} 
