package com.studentresult.security;

import com.studentresult.entity.AppUser;
import com.studentresult.repository.AppUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
// Removed: import org.springframework.security.crypto.password.PasswordEncoder; // No longer needed here

import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private final AppUserRepository userRepository;

    // Removed the PasswordEncoder field entirely, as MyUserDetailsService
    // does not need to directly interact with it. The DaoAuthenticationProvider
    // (configured in SecurityConfig) will use the PasswordEncoder.
    // @Autowired
    // private PasswordEncoder passwordEncoder; // THIS LINE IS REMOVED

    @Autowired
    public MyUserDetailsService(AppUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        // The password retrieved from appUser.getPassword() MUST be BCrypt encoded.
        // Spring Security's DaoAuthenticationProvider will use the PasswordEncoder
        // to compare the submitted password with this stored, encoded password.
        return User.withUsername(appUser.getUsername())
                .password(appUser.getPassword()) // Password must already be BCrypt encoded in the DB
                .roles("USER") // Assign a default role. Consider fetching roles from AppUser if you add them.
                .build();
    }
}
