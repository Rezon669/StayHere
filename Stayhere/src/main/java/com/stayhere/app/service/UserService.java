package com.stayhere.app.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.stayhere.app.exceptions.CustomException;
import com.stayhere.app.model.UserDto;
import com.stayhere.app.repo.UserRepository;
import com.stayhere.app.security.JwtUtil;

@Service
public class UserService {

    private static final Logger log = LogManager.getLogger(UserService.class);
    private final UserRepository userRepo;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepo, AuthenticationManager authenticationManager, JwtUtil jwtUtil,
                       PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    @CacheEvict(value = "usersCache", key = "'users'")
    @CachePut(value = "usersCache", key = "#result.userid")
    public UserDto addUser(UserDto user) {
        userRepo.findByUsernameOrEmail(user.getUsername(), user.getEmail()).ifPresent(existingUser -> {
            throw new CustomException("User already exists", "A user with the given username or email already exists.");
        });

        // Encode the password
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
     

        try {
            UserDto savedUser = userRepo.save(user);
            savedUser.setPassword("SECRET"); // Mask password in response
            log.info("User added successfully: {}", savedUser);
            return savedUser; // Cache the newly added user
        } catch (Exception e) {
            log.error("Error while saving user: {}", e.getMessage(), e);
            throw e;
        }
    }

    @Cacheable(value = "usersCache", key = "'users'")
    public List<UserDto> getUsers() {
        List<UserDto> users = userRepo.findAll();
        log.info("Fetched all user details successfully.");
        users.forEach(user -> user.setPassword("SECRET")); // Mask passwords
        return users;
    }

    @Caching(evict = {
    	    @CacheEvict(value = "usersCache", key = "'users'"), // Evict the list cache
    	    @CacheEvict(value = "usersCache", key = "#userId")  // Evict the individual user cache
    	})
    public UserDto deleteUser(long userId) {
        return userRepo.findById(userId).map(user -> {
            userRepo.deleteById(userId);
            log.info("User deleted successfully with ID: {}", userId);
            user.setPassword("SECRET");
            return user;
        }).orElseThrow(() -> new CustomException("User not found", "No user exists with the given ID: " + userId));
    }

    @CacheEvict(value = "usersCache", key = "'users'")
    @CachePut(value = "usersCache", key = "#userId")
//    @Caching(evict = {
//            @CacheEvict(value = "usersCache", key = "'users'") // Evict cached user list
//        },
//        put = {
//            @CachePut(value = "usersCache", key = "#updateUser.userId") // Update cache for specific user
//        }
//    )
    public UserDto updateUser(long userId, @Validated UserDto updateUser) {
        return userRepo.findById(userId).map(existingUser -> {
            // Update user details
            existingUser.setUsername(updateUser.getUsername());
            existingUser.setFirstname(updateUser.getFirstname());
            existingUser.setLastname(updateUser.getLastname());
            existingUser.setEmail(updateUser.getEmail());

            // Update password only if it has been changed
            if (!updateUser.getPassword().isEmpty() && !passwordEncoder.matches(updateUser.getPassword(), existingUser.getPassword())) {
                existingUser.setPassword(passwordEncoder.encode(updateUser.getPassword()));
            }

            existingUser.setPhonenumber(updateUser.getPhonenumber());
            existingUser.setRole(updateUser.getRole());

            UserDto updatedUser = userRepo.save(existingUser);
            log.info("User details updated successfully for ID: {}", userId);
            updatedUser.setPassword("SECRET"); // Mask password in response
            return updatedUser;
        }).orElseThrow(() -> new CustomException("User not found", "No user exists with the given ID: " + userId));
    }

    public String authenticateUser(String email, String password) {
        UserDto user = userRepo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found with email: " + email));

        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), password));

        if (authentication.isAuthenticated()) {
            return jwtUtil.generateToken(user.getUsername(), user.getRole(), user.getEmail());
        }

        throw new RuntimeException("Invalid username or password");
    }

	public Optional<UserDto> getUserById(Long userId) {
		Optional<UserDto> user = userRepo.findById(userId);
		return user;
	}

	
}
