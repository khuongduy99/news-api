package com.duyhk.newswebsite.com.duyhk.newswebsite.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.duyhk.newswebsite.com.duyhk.newswebsite.models.entities.UserEntity;
import com.duyhk.newswebsite.com.duyhk.newswebsite.repositories.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException(username + " not found"));
		return UserDetailsImpl.build(user);
	}

}
