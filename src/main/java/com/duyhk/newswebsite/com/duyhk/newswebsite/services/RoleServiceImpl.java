package com.duyhk.newswebsite.com.duyhk.newswebsite.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duyhk.newswebsite.com.duyhk.newswebsite.models.entities.RoleEntity;
import com.duyhk.newswebsite.com.duyhk.newswebsite.models.enums.ERole;
import com.duyhk.newswebsite.com.duyhk.newswebsite.models.responses.ResponseService;
import com.duyhk.newswebsite.com.duyhk.newswebsite.repositories.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public ResponseService checkRole(String role) {
		return null;
	}

	@Override
	public RoleEntity findRole(ERole role) {
		return roleRepository.findByName(role);
	}

}
