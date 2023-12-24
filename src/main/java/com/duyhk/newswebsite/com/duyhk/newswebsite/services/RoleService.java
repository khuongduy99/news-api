package com.duyhk.newswebsite.com.duyhk.newswebsite.services;

import com.duyhk.newswebsite.com.duyhk.newswebsite.models.entities.RoleEntity;
import com.duyhk.newswebsite.com.duyhk.newswebsite.models.enums.ERole;
import com.duyhk.newswebsite.com.duyhk.newswebsite.models.responses.ResponseService;

public interface RoleService {
	
	ResponseService checkRole(String role);
	RoleEntity findRole(ERole role);
}
