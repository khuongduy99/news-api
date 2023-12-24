package com.duyhk.newswebsite.com.duyhk.newswebsite.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duyhk.newswebsite.com.duyhk.newswebsite.models.dto.SignupDTO;
import com.duyhk.newswebsite.com.duyhk.newswebsite.models.entities.UserEntity;
import com.duyhk.newswebsite.com.duyhk.newswebsite.models.responses.ResponseService;
import com.duyhk.newswebsite.com.duyhk.newswebsite.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public ResponseService checkDataSignup(SignupDTO signupDto) {
		ResponseService response = new ResponseService();
		
		if (userRepository.existsByUsername(signupDto.getUsername())) {
			response.setValidData(false);
			response.addMessage("Username is already taken!");
		}
		
		if (userRepository.existsByEmail(signupDto.getPassword())) {
			response.setValidData(false);
			response.addMessage("Email is already in use!");
		}

		return response;
	}

	@Override
	public void save(UserEntity user) {
		userRepository.save(user);
		
	}

}
