package com.stayhere.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.stayhere.app.security.JwtFilter;
import com.stayhere.app.service.UserDetailsServiceImpl;

@Configuration
public class SecurityConfig {

	@Autowired
	private JwtFilter jwtFilter;

	@SuppressWarnings("removal")
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().requestMatchers("/stayhere/api/users/authenticate").permitAll()
				.requestMatchers("/actuator/**").permitAll().requestMatchers("/**").hasRole("ADMIN")
				.requestMatchers(HttpMethod.GET, "/**").hasAnyRole()
				.requestMatchers(HttpMethod.GET, "/stayhere/api/properties/**").hasAnyRole("BUYER", "TENANT", "SELLER")
				.requestMatchers(HttpMethod.POST, "/stayhere/api/properties/**").hasRole("SELLER")
				.requestMatchers(HttpMethod.DELETE, "/stayhere/api/properties/**").hasRole("SELLER")

				.anyRequest().authenticated()// Public endpoint for login/authentication
				// .anyRequest().authenticated() // All other endpoints require authentication
				.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); // Stateless session

		// Add JWT filter to the security chain
		http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(); // Use BCrypt for password encoding
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
			throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}
}
