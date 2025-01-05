package com.stayhere.app.controller;

import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stayhere.app.model.UserDto;
import com.stayhere.app.service.UserService;

@RestController 
@RequestMapping("/stayhere/api/users")
public class UserController {

	private static final Logger log = LogManager.getLogger(UserController.class);

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/authenticate")
	public ResponseEntity<?> authenticateUser(@RequestParam String email, @RequestParam String password) {
	    try {
	        String token = userService.authenticateUser(email, password);
	        return ResponseEntity.ok(Collections.singletonMap("token", token)); // Return token in JSON format.
	    } catch (RuntimeException e) {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Collections.singletonMap("error", e.getMessage()));
	    }
	}


	@PostMapping
	public ResponseEntity<UserDto> addUser(@Validated @RequestBody UserDto user) {
		UserDto addedUser = userService.addUser(user);
		log.info("User added successfully: {}", user.getUsername());
		return new ResponseEntity<>(addedUser, HttpStatus.CREATED);
	}

	@GetMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<List<UserDto>> getUsers() {
		List<UserDto> users = userService.getUsers();
		log.info("Users information fetched successfully");
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@DeleteMapping("/{userId}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<UserDto> deleteUser(@PathVariable() long userId) {
		UserDto deletedUser = userService.deleteUser(userId);
		log.info("User deleted successfully with id: {}", userId);
		return new ResponseEntity<>(deletedUser, HttpStatus.OK);
	}
	
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@PathVariable long userId, @Validated @RequestBody UserDto updateuser) {
		UserDto updatedUser = userService.updateUser(userId, updateuser);
		log.info("User details are updated successfully");
		return new ResponseEntity<>(updatedUser, HttpStatus.ACCEPTED);
	}
}
