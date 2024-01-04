package com.duyhk.newswebsite.com.duyhk.newswebsite.models.entities;

import com.duyhk.newswebsite.com.duyhk.newswebsite.models.enums.ERole;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "role", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class RoleEntity extends CommonEntity {

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private ERole name;

	public RoleEntity(ERole name) {
		super();
		this.name = name;
	}

	public RoleEntity() {
	}

	// Getter Setter
	public ERole getName() {
		return name;
	}

	public void setName(ERole name) {
		this.name = name;
	}
}
