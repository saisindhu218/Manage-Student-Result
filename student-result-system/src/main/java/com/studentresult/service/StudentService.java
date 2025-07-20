package com.studentresult.service;

import com.studentresult.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> getAllStudents();
    Optional<Student> getStudentById(Long id);
    void saveStudent(Student student);
    void deleteStudent(Long id);
}
