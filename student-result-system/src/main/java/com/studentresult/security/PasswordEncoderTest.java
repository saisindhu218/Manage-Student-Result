package com.studentresult.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderTest {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "admin123";  // This is the plain-text password you want to hash
        String encodedPassword = encoder.encode(rawPassword); // This line performs the BCrypt hashing
        System.out.println("Encoded password: " + encodedPassword); // This line prints the generated hash to your console
    }
}
