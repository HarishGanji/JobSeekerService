package com.jobseeker.service.security;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.function.Function;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.jobseeker.service.model.CustomUserDetails;
import com.jobseeker.service.model.JobSeeker;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JwtUtil {

	private static final long EXPIRATION_TIME = 1000 * 60 * 24 * 7;

	private final SecretKey key;

	public JwtUtil() {
		String secretString = "94132897465132189646157894513299629R578RF8F984EFG4894FRG845FDE8R8JJ779984D64789";
		byte[] keyBytes = Base64.getDecoder().decode(secretString.getBytes(StandardCharsets.UTF_8));
		this.key = new SecretKeySpec(keyBytes, "HmacSHA256");
	}

	public String generateToken(UserDetails userDetails) {
		CustomUserDetails customUserDetails = (CustomUserDetails) userDetails;
		JobSeeker user = customUserDetails.getJobSeeker();
		return Jwts.builder().subject(userDetails.getUsername()).claim("userId", user.getJobSeekerId())
				.claim("email", user.getEmail()).claim("role", user.getRole())
				.issuedAt(new Date(System.currentTimeMillis()))
				.expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)).signWith(key).compact();
	}

	public String extractUser(String token) {
		return extractClaims(token, Claims::getSubject);
	}

	public String extractUserId(String token) {
		return extractClaims(token, claims -> claims.get("userId", String.class));
	}

	public String extractRole(String token) {
		String role = extractClaims(token, claims -> claims.get("role", String.class));

		if (role == null || role.trim().isEmpty()) {
			throw new IllegalArgumentException("Role is missing");
		}
		return role;
	}

	private <T> T extractClaims(String token, Function<Claims, T> claimsTFunction) {
		return claimsTFunction.apply(Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload());
	}

	public boolean isValidToken(String token, UserDetails userDetails) {
		final String username = extractUser(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpire(token));
	}

	private boolean isTokenExpire(String token) {
		return extractClaims(token, Claims::getExpiration).before(new Date());
	}
}
