package com.stayhere.app.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.stayhere.app.model.UserDto.Role; // Import the Role enum

@Component
public class JwtUtil {

    @Value("${jwt_secret}")
    private String secret;

    @Value("${token_expire_time}")
    private String expirationTime;

    // Convert expirationTime to long for calculations
    private long getExpirationTime() {
        try {
            return Long.parseLong(expirationTime);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Invalid token expiration time configuration.");
        }
    }

    // Method to generate JWT token
    public String generateToken(String username, Role role, String email) {
        long expireTime = getExpirationTime();

        return JWT.create()
        		.withSubject("Authentication Token")  // Generic subject
                .withIssuer("StayHere")  // The issuer
                .withClaim("username", username)  // Add username as a claim
                .withClaim("email", email)  // Add email as a claim
                .withClaim("role", role.name())  // Store the role as a String (e.g., "USER", "ADMIN")
                .withIssuedAt(new Date())  // Issue date
                .withExpiresAt(new Date(System.currentTimeMillis() + expireTime))  // Expiration date
                .sign(Algorithm.HMAC256(secret));  // Sign the token using the secret key
    }

    // Method to validate JWT token
    public String validateToken(String token) throws JWTVerificationException {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret))
                .withIssuer("StayHere")  // Ensure the issuer matches
                .build();

        DecodedJWT jwt = verifier.verify(token);  // Verify and decode the token

        // Extract the username from the claims
        String username = jwt.getClaim("username").asString();
        if (username == null || username.isEmpty()) {
            throw new JWTVerificationException("Invalid token: username claim is missing or empty.");
        }

        return username;  // Return the username for further processing
    }


}
