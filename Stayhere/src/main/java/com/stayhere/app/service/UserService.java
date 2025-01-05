package com.stayhere.app.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.CacheEvict;

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

	@CachePut(value = "usersCache", key = "#user.id")
	public UserDto addUser(UserDto user) {
		// Check if user already exists by username or email
		userRepo.findByUsernameOrEmail(user.getUsername(), user.getEmail()).ifPresent(existingUser -> {
			throw new CustomException("User already exists", "A user with the given username or email already exists.");
		});

		// Encode the password and save the user
		String userPassword = user.getPassword();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		log.info("Encoded password: {}", encodedPassword);

		try {
			userRepo.save(user);
			user.setPassword(userPassword);
			log.info("User added successfully: {}", user);
			return user;
		} catch (Exception e) {
			log.error("Error while saving user: {}", e.getMessage(), e);
			throw e;
		}
	}

	@Cacheable(value = "usersCache", key = "'users'")
	public List<UserDto> getUsers() {
		List<UserDto> users = userRepo.findAll();
		log.info("Fetched all user details successfully.");
		users.forEach(user -> user.setPassword(""));
		return users;
	}

	@CacheEvict(value = "usersCache", key = "#userId")
	public UserDto deleteUser(long id) {
		// Delete the user if it exists, else throw exception
		return userRepo.findById(id).map(user -> {
			userRepo.deleteById(id);
			log.info("User deleted successfully with ID: {}", id);
			return user;
		}).orElseThrow(() -> new CustomException("User not found", "No user exists with the given ID: " + id));
	}

	@CachePut(value = "usersCache", key = "#userId")
	public UserDto updateUser(long id, @Validated UserDto updateUser) {
		// Find the existing user and update their details
		return userRepo.findById(id).map(existingUser -> {
			existingUser.setUsername(updateUser.getUsername());
			existingUser.setFirstname(updateUser.getFirstname());
			existingUser.setLastname(updateUser.getLastname());
			existingUser.setEmail(updateUser.getEmail());

			String userPassword = updateUser.getPassword();
			// Update password only if it's different
			if (!updateUser.getPassword().equals(existingUser.getPassword())) {
				existingUser.setPassword(passwordEncoder.encode(updateUser.getPassword()));
			}

			existingUser.setPhonenumber(updateUser.getPhonenumber());
			existingUser.setRole(updateUser.getRole());

			// Save updated user
			UserDto updatedUser = userRepo.save(existingUser);
			log.info("User details updated successfully for ID: {}", id);
			updatedUser.setPassword(userPassword);
			return updatedUser;
		}).orElseThrow(() -> {
			log.error("User not found with ID: {}", id);
			return new CustomException("User not found", "No user exists with the given ID: " + id);
		});
	}

	public String authenticateUser(String email, String password) {
		// Find user by email
		UserDto user = userRepo.findByEmail(email)
				.orElseThrow(() -> new RuntimeException("User not found with email: " + email));

		// Authenticate the user using the provided password
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), password));

		// If authentication is successful, generate JWT token
		if (authentication.isAuthenticated()) {
			return jwtUtil.generateToken(user.getUsername(), user.getRole(), user.getEmail());
		}

		throw new RuntimeException("Invalid username or password");
	}
}
