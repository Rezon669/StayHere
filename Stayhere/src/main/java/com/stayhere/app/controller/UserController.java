package com.stayhere.app.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.hateoas.EntityModel;
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
	public ResponseEntity<?> addUser(@Validated @RequestBody UserDto user) {
		UserDto addedUser = userService.addUser(user);
		log.info("User added successfully: {}", user.getUsername());
		EntityModel<UserDto> userResource = EntityModel.of(addedUser,
		        linkTo(methodOn(UserController.class).getUserById(addedUser.getUserid())).withSelfRel(),
		        linkTo(methodOn(UserController.class).getUsers()).withRel("all-users"));
		return new ResponseEntity<>(userResource, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<?> getUsers() {
		List<UserDto> users = userService.getUsers();
		log.info("Users information fetched successfully");
		List<EntityModel<UserDto>> userDetails = users.stream()
				.map(user -> EntityModel.of(user,
						linkTo(methodOn(UserController.class).getUserById(user.getUserid())).withSelfRel(),
						linkTo(methodOn(UserController.class).updateUser(user.getUserid(),null)).withRel("update"),
				linkTo(methodOn(UserController.class).deleteUser(user.getUserid())).withRel("delete")))
				.collect(Collectors.toList());
				
				
		return new ResponseEntity<>(userDetails, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getUserById(@PathVariable("id") Long userId) {
	    java.util.Optional<UserDto> user = userService.getUserById(userId);

	    if (user.isPresent()) {
	        log.info("User information fetched successfully");
	        user.get().setPassword(null);
	        EntityModel<java.util.Optional<UserDto>> userDetails = EntityModel.of(user,
	        linkTo(methodOn(UserController.class).updateUser(user.get().getUserid(),null)).withRel("update"),
			linkTo(methodOn(UserController.class).deleteUser(user.get().getUserid())).withRel("delete"));
	        return new ResponseEntity<>(userDetails, HttpStatus.OK);
	    } else {
	        log.info("No users found with the given id: {}", userId);
	        return new ResponseEntity<>("No Users are found", HttpStatus.NO_CONTENT);
	    }
	}


	@DeleteMapping("/{userId}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> deleteUser(@PathVariable() long userId) {
		UserDto deletedUser = userService.deleteUser(userId);
		EntityModel<?> userDetails = EntityModel.of(deletedUser,
				linkTo(methodOn(UserController.class).getUsers()).withRel("all-users"));
		log.info("User deleted successfully with id: {}", userId);
		return new ResponseEntity<>(userDetails, HttpStatus.OK);
	}
	
	@PutMapping("/{userId}")
	public ResponseEntity<?> updateUser(@PathVariable long userId, @Validated @RequestBody UserDto updateuser) {
		UserDto updatedUser = userService.updateUser(userId, updateuser);
		log.info("User details are updated successfully");
		EntityModel<UserDto> userDetails = EntityModel.of(updatedUser,
						linkTo(methodOn(UserController.class).getUserById(updatedUser.getUserid())).withSelfRel(),
				linkTo(methodOn(UserController.class).deleteUser(updatedUser.getUserid())).withRel("delete"));
				
		return new ResponseEntity<>(userDetails, HttpStatus.ACCEPTED);
	}
}
