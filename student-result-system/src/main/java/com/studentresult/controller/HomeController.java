package com.studentresult.controller;

import com.studentresult.entity.Student;
import com.studentresult.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public String redirectToLogin() {
        return "redirect:/login";
    }

    @GetMapping("/landing-page")
    public String landingPage(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUsername = authentication.getName();
        model.addAttribute("username", currentUsername);
        return "landing-page";
    }

    // Displays the read-only dashboard with ALL student results
    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUsername = authentication.getName();
        model.addAttribute("username", currentUsername);

        // Fetch ALL students
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);

        return "dashboard";
    }

    // Displays the "Manage Student Results" page (shows ALL existing students and the add form)
    @GetMapping("/manage-students")
    public String manageStudents(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUsername = authentication.getName();
        model.addAttribute("username", currentUsername);

        // Fetch ALL students
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students); // Existing students for the table

        model.addAttribute("newStudent", new Student()); // Empty student for the add form
        return "manage-students";
    }

    // Handles the form submission for adding a new student
    @PostMapping("/manage-students/add")
    public String addStudent(@ModelAttribute Student newStudent) {
        // No username logic here, as the column is removed from the DB and entity.

        // Calculate Total Marks
        int totalMarks = newStudent.getSubject1Marks() +
                         newStudent.getSubject2Marks() +
                         newStudent.getSubject3Marks() +
                         newStudent.getSubject4Marks() +
                         newStudent.getSubject5Marks();
        newStudent.setTotalMarks(totalMarks);

        // Calculate CGPA (assuming max 500 marks for 5 subjects, CGPA out of 10)
        double cgpa = (double) totalMarks / 500 * 10;
        newStudent.setCgpa(Math.round(cgpa * 100.0) / 100.0);

        studentService.saveStudent(newStudent); // Save the new student

        // Redirect back to the manage students page to show the updated list
        return "redirect:/manage-students";
    }
}
