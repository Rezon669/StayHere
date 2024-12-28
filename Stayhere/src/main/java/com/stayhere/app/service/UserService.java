package com.stayhere.app.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.stayhere.app.exceptions.CustomException;
import com.stayhere.app.model.UserDto;
import com.stayhere.app.repo.UserRepository;

@Service
public class UserService {

	private static final Logger log = LogManager.getLogger(UserService.class);
	private final UserRepository userRepo;

	public UserService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

	public UserDto addUser(UserDto user) {
		userRepo.findByUsernameOrEmail(user.getUsername(), user.getEmail()).ifPresent(existingUser -> {
			throw new CustomException("User already exists", "A user with the given username or email already exists.");
		});

		userRepo.save(user);
		log.info("Successfully added the user: {}", user.getUsername());
		return user;
	}

	public List<UserDto> getUsers() {
		List<UserDto> users = userRepo.findAll();
		log.info("Fetched all user details successfully.");
		return users;
	}

	public UserDto deleteUser(long id) {
		return userRepo.findById(id).map(user -> {
			userRepo.deleteById(id);
			log.info("User deleted successfully with ID: {}", id);
			return user;
		}).orElseThrow(() -> new CustomException("User not found", "No user exists with the given ID: " + id));
	}

	public UserDto updateUser(long id, @Validated UserDto updateuser) {
		return userRepo.findById(id).map(existinguser -> {
			existinguser.setUsername(updateuser.getUsername());
			existinguser.setFirstname(updateuser.getFirstname());
			existinguser.setLastname(updateuser.getLastname());
			existinguser.setEmail(updateuser.getEmail());
			existinguser.setPassword(updateuser.getPassword());
			existinguser.setPhonenumber(updateuser.getPhonenumber());
			existinguser.setRole(updateuser.getRole());

			UserDto updatedUser = userRepo.save(existinguser);
			log.info("User details updated successfully for ID: {}", id);
			return updatedUser;
		}).orElseThrow(() -> {
			log.error("User not found with ID: {}", id);
			return new CustomException("User not found", "No user exists with the given ID: " + id);
		});
	}
}
