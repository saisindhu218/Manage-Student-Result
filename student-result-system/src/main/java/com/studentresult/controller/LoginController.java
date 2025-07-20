package com.studentresult.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // Will render login.html from templates
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "admin"; // Will render admin.html from templates
    }
}
