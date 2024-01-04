package com.duyhk.newswebsite.com.duyhk.newswebsite.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duyhk.newswebsite.com.duyhk.newswebsite.models.dto.SignupDTO;
import com.duyhk.newswebsite.com.duyhk.newswebsite.models.entities.RoleEntity;
import com.duyhk.newswebsite.com.duyhk.newswebsite.models.entities.UserEntity;
import com.duyhk.newswebsite.com.duyhk.newswebsite.models.enums.ERole;
import com.duyhk.newswebsite.com.duyhk.newswebsite.models.responses.ResponseService;
import com.duyhk.newswebsite.com.duyhk.newswebsite.repositories.RoleRepository;
import com.duyhk.newswebsite.com.duyhk.newswebsite.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public ResponseService checkDataSignup(SignupDTO signupDto) {
		ResponseService response = new ResponseService();
		
		if (userRepository.existsByUsername(signupDto.getUsername())) {
			response.setValidData(false);
			response.addError("username","Username is already taken!");
		}
		
		if (userRepository.existsByEmail(signupDto.getEmail())) {
			response.setValidData(false);
			response.addError("email","Email is already in use!");
		}

		return response;
	}

	@Override
	public void create(UserEntity user) {

		Set<RoleEntity> roles = new HashSet<>();
		RoleEntity userRole = roleRepository.findByName(ERole.ROLE_USER);
		roles.add(userRole);
		user.setRoles(roles);
		userRepository.save(user);
		
	}

}
