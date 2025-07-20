package com.studentresult.controller;

// Removed unused imports: import com.studentresult.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    // The @Autowired UserService and the /login endpoint are no longer needed
    // because Spring Security's formLogin handles authentication.
    // This controller can be used for other authentication-related REST endpoints
    // if you decide to add them (e.g., user registration via API, password reset).

    /*
    // Original login method - now handled by Spring Security's formLogin
    @Autowired
    private UserService userService; // This dependency is also no longer needed for login

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        boolean isValid = userService.validateUser(username, password);
        return isValid ? "Login successful" : "Invalid username or password";
    }
    */

    // You can add new REST endpoints here for other authentication-related features.
    // For example:
    // @PostMapping("/register")
    // public String registerUser(@RequestBody AppUser newUser) {
    //     // Logic to register a new user, encoding their password
    //     return "User registered successfully";
    // }
}
// 