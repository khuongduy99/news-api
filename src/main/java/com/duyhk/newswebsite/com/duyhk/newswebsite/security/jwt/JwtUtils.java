package com.duyhk.newswebsite.com.duyhk.newswebsite.security.jwt;

import java.security.Key;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.duyhk.newswebsite.com.duyhk.newswebsite.security.services.UserDetailsImpl;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

	private String jwtSecret = "======================DuyHK=Spring===========================";
	private int jwtExpiration = 86400000;

	public String generateJwtToken(Authentication authentication) {
		UserDetailsImpl user = (UserDetailsImpl) authentication.getPrincipal();
		
		return Jwts.builder().setSubject(user.getUsername())
							 .setIssuedAt(new Date())
							 .setExpiration(new Date((new Date()).getTime() + jwtExpiration))
							 .signWith(key(), SignatureAlgorithm.HS256)
							 .compact();
	}
	
	private Key key() {
		return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
	}
	
	public String getUserNameFromJwtToken(String token) {
		return Jwts.parserBuilder()
				   .setSigningKey(key()).build()
				   .parseClaimsJws(token)
				   .getBody()
				   .getSubject();
	}
	
	public boolean validateToken(String authToken) {
		try {
			Jwts.parserBuilder().setSigningKey(key()).build().parse(authToken);
			return true;
		} catch (Exception e) {
			logger.error("Invalid JWT token: {}", e.getMessage());
		}
		
		return false;
	}

}
