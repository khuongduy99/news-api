package com.duyhk.newswebsite.com.duyhk.newswebsite.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestController {
	
	 @GetMapping("/all")
	  public String allAccess() {
	    return "Public Content.";
	  }

	  @PreAuthorize("hasRole('USER') or hasRole('MANAGER') or hasRole('ADMIN')")
	  @GetMapping("/user")
	  private String userAccess() {
	    return "User Content.";
	  }

	  @GetMapping("/mod")
	  @PreAuthorize("hasRole('MODERATOR')")
	  public String moderatorAccess() {
	    return "Moderator Board.";
	  }

	  @GetMapping("/admin")
	  @PreAuthorize("hasRole('ADMIN')")
	  public ResponseEntity<?> adminAccess() {
		  
		  
	    return null;
	  }
}
