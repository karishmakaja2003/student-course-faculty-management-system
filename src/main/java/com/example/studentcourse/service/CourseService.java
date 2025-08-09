package com.example.studentcourse.service;

import com.example.studentcourse.entity.Course;
import com.example.studentcourse.entity.Faculty;
import com.example.studentcourse.repository.CourseRepository;
import com.example.studentcourse.repository.FacultyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private FacultyRepository facultyRepository;

    // Add a new course
    public Course addCourse(Course course) {
        if (course.getFacultyId() != null) {
            Optional<Faculty> faculty = facultyRepository.findById(course.getFacultyId());
            if (faculty.isPresent()) {
                return courseRepository.save(course);
            } else {
                throw new RuntimeException("Faculty not found with ID: " + course.getFacultyId());
            }
        } else {
            throw new RuntimeException("Faculty ID is required");
        }
    }

    // Get all courses
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    // Get course by ID
    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    // Update course
    public Course updateCourse(Long id, Course updatedCourse) {
        Optional<Course> optionalCourse = courseRepository.findById(id);
        if (optionalCourse.isPresent()) {
            Course existingCourse = optionalCourse.get();
            existingCourse.setName(updatedCourse.getName());
            existingCourse.setFee(updatedCourse.getFee());
            existingCourse.setDuration(updatedCourse.getDuration());

            if (updatedCourse.getFacultyId() != null) {
                Optional<Faculty> faculty = facultyRepository.findById(updatedCourse.getFacultyId());
                if (faculty.isPresent()) {
                    existingCourse.setFacultyId(updatedCourse.getFacultyId());
                } else {
                    throw new RuntimeException("Faculty not found with ID: " + updatedCourse.getFacultyId());
                }
            }

            return courseRepository.save(existingCourse);
        } else {
            throw new RuntimeException("Course not found with ID: " + id);
        }
    }

    // Delete course
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}
