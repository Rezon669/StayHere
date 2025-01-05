package com.stayhere.app.service;

import java.util.Collections;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.stayhere.app.model.UserDto;
import com.stayhere.app.repo.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepo;

    public UserDetailsServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Fetch user details from the database
        UserDto user = userRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        // Ensure that the role has the prefix "ROLE_"
        String role = "ROLE_" + user.getRole(); // Convert to uppercase and add prefix

        // Return Spring Security's User object with granted authorities
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(), // Email used as username
                user.getPassword(), // Encoded password
                Collections.singletonList(new SimpleGrantedAuthority(role)) // Authorities with role prefixed
        );
    }
}
