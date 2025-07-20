package com.studentresult.repository;

import com.studentresult.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    // No custom methods needed here, JpaRepository's findAll() is sufficient.
}
