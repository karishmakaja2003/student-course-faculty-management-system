package com.example.studentcourse.service;

import com.example.studentcourse.entity.Student;
import com.example.studentcourse.repository.StudentRepository;
import com.example.studentcourse.repository.CourseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    // Save new student
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    // Get all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Get student by ID
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    // Delete student by ID
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    // Enroll student in a course (set courseId field)
    public Student enrollStudentInCourse(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId)
            .orElseThrow(() -> new RuntimeException("Student not found"));

        // Optional: validate course exists
        if (!courseRepository.existsById(courseId)) {
            throw new RuntimeException("Course not found");
        }

        student.setCourseId(courseId);  // just setting course ID, no relationship
        return studentRepository.save(student);
    }

   
    public Student updateStudent(Long id, Student updatedStudent) {
        Student student = studentRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Student not found"));

        student.setName(updatedStudent.getName());
        student.setDob(updatedStudent.getDob());
        student.setAddress1(updatedStudent.getAddress1());
        student.setAddress2(updatedStudent.getAddress2());
        student.setState(updatedStudent.getState());
        student.setCity(updatedStudent.getCity());
        student.setCountry(updatedStudent.getCountry());
        student.setPincode(updatedStudent.getPincode());
        student.setCourseId(updatedStudent.getCourseId());

        return studentRepository.save(student);
    }
}
