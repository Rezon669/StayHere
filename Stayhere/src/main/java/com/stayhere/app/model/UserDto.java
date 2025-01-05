package com.stayhere.app.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "user")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class UserDto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userid;

	@NotNull(message = "Provide the username")
	private String username;

	@NotNull(message = "Provide the first name")
	private String firstname;

	@NotNull(message = "Provide the last name")
	private String lastname;

	@Email(message = "Provide a valid email address")
	@NotNull(message = "Provide the email")
	private String email;

	@NotNull(message = "Provide the phone number")
	@Pattern(regexp = "^[6-9]\\d{9}$", message = "Phone number must be 10 digits")
	private String phonenumber;

	@NotNull(message = "Provide the password")
	//@Size(min = 8, max = 30, message = "Password must be between 8 and 20 characters")
	@Column(nullable = false, length = 255)
	private String password;

	@Enumerated(EnumType.STRING) // Stores enum as a String in the database
	@Column(nullable = false)
	private Role role = Role.USER; // Default value

	public enum Role {
		BUYER, SELLER, TENANT, ADMIN, USER
	}
	// Getters and Setters

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
