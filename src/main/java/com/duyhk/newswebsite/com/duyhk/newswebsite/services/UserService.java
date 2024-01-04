package com.duyhk.newswebsite.com.duyhk.newswebsite.services;

import com.duyhk.newswebsite.com.duyhk.newswebsite.models.dto.SignupDTO;
import com.duyhk.newswebsite.com.duyhk.newswebsite.models.entities.UserEntity;
import com.duyhk.newswebsite.com.duyhk.newswebsite.models.responses.ResponseService;


public interface UserService {
	
	ResponseService checkDataSignup(SignupDTO signupDto);
	void create(UserEntity user);
}
