package com.studentresult.service;

import com.studentresult.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private AppUserRepository userRepository;

    // The validateUser method is insecure as it performs a plain text password comparison.
    // With Spring Security configured, authentication (including password validation)
    // is handled by MyUserDetailsService and the BCryptPasswordEncoder.
    // Therefore, this method is no longer necessary for the login process.

    /*
    // Original validateUser method - now handled by Spring Security
    public boolean validateUser(String username, String password) {
        return userRepository.findById(username)
                .map(user -> user.getPassword().equals(password)) // THIS IS INSECURE FOR PRODUCTION!
                .orElse(false);
    }
    */

    // You can add other user-related service methods here that don't involve
    // direct password validation for login. For example:
    // public AppUser findUserByUsername(String username) {
    //     return userRepository.findByUsername(username).orElse(null);
    // }
    // public void saveUser(AppUser user) {
    //     userRepository.save(user);
    // }
}
