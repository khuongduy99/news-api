package com.duyhk.newswebsite.com.duyhk.newswebsite.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.duyhk.newswebsite.com.duyhk.newswebsite.models.entities.RoleEntity;
import com.duyhk.newswebsite.com.duyhk.newswebsite.models.enums.ERole;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long>{
	RoleEntity findByName(ERole name);
	
}
