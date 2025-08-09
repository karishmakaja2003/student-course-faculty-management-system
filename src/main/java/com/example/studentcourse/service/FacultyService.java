package com.example.studentcourse.service;

import com.example.studentcourse.entity.Faculty;
import com.example.studentcourse.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    public Faculty createFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public List<Faculty> getAllFaculties() {
        return facultyRepository.findAll();
    }

    public Faculty getFacultyById(Long id) {
        return facultyRepository.findById(id).orElse(null);
    }

    public Faculty updateFaculty(Long id, Faculty updatedFaculty) {
        Optional<Faculty> optionalFaculty = facultyRepository.findById(id);
        if (optionalFaculty.isPresent()) {
            Faculty faculty = optionalFaculty.get();
            faculty.setFacultyName(updatedFaculty.getFacultyName());
            faculty.setDob(updatedFaculty.getDob());
            faculty.setQualifications(updatedFaculty.getQualifications());
            faculty.setDesignation(updatedFaculty.getDesignation());
            return facultyRepository.save(faculty);
        }
        return null;
    }

    public void deleteFaculty(Long id) {
        facultyRepository.deleteById(id);
    }
}
