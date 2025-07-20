package com.studentresult.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "student")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "university_roll_number")
    private String universityRollNumber;

    @Column(name = "name")
    private String name;

    @Column(name = "semester")
    private String semester;

    @Column(name = "subject1_marks")
    private int subject1Marks;

    @Column(name = "subject2_marks")
    private int subject2Marks;

    @Column(name = "subject3_marks")
    private int subject3Marks;

    @Column(name = "subject4_marks")
    private int subject4Marks;

    @Column(name = "subject5_marks")
    private int subject5Marks;

    @Column(name = "total_marks")
    private int totalMarks;

    @Column(name = "cgpa")
    private double cgpa;

    // The 'username' field is intentionally excluded from this entity.
}
