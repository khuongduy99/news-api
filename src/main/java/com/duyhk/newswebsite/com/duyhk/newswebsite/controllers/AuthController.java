package com.duyhk.newswebsite.com.duyhk.newswebsite.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duyhk.newswebsite.com.duyhk.newswebsite.models.dto.SigninDTO;
import com.duyhk.newswebsite.com.duyhk.newswebsite.models.dto.SignupDTO;
import com.duyhk.newswebsite.com.duyhk.newswebsite.models.entities.UserEntity;
import com.duyhk.newswebsite.com.duyhk.newswebsite.models.responses.ResponseJwt;
import com.duyhk.newswebsite.com.duyhk.newswebsite.models.responses.ResponseMessage;
import com.duyhk.newswebsite.com.duyhk.newswebsite.models.responses.ResponseService;
import com.duyhk.newswebsite.com.duyhk.newswebsite.security.jwt.JwtUtils;
import com.duyhk.newswebsite.com.duyhk.newswebsite.security.services.UserDetailsImpl;
import com.duyhk.newswebsite.com.duyhk.newswebsite.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@PostMapping("/signin")
	public ResponseEntity<?> signin(@Valid @RequestBody SigninDTO signinDto) {
		Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signinDto.getUsername(), signinDto.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(auth);
		
		String jwt = jwtUtils.generateJwtToken(auth);
		
		 UserDetailsImpl userDetails = (UserDetailsImpl) auth.getPrincipal();    
		    List<String> roles = userDetails.getAuthorities().stream()
		        .map(item -> item.getAuthority())
		        .collect(Collectors.toList());
		
		return ResponseEntity.ok(new ResponseJwt(jwt, 
                userDetails.getId(), 
                userDetails.getUsername(), 
                userDetails.getEmail(), 
                roles));
	}
	
	@PostMapping("/signup")
	public ResponseEntity<?> signup(@Valid @RequestBody SignupDTO signupDto) {
		
		ResponseService validDataSignUp = userService.checkDataSignup(signupDto);
		
		if (validDataSignUp.isValidData() == false) {
			return ResponseEntity
			          .badRequest()
			          .body(validDataSignUp.getErrors());
		}
		
		UserEntity user = new UserEntity();
		user.setUsername(signupDto.getUsername());
		user.setPassword(encoder.encode(signupDto.getPassword()));
		user.setEmail(signupDto.getEmail());
		
		userService.create(user);
		
		return ResponseEntity.ok(new ResponseMessage("User registered successfully!"));
	}

}
