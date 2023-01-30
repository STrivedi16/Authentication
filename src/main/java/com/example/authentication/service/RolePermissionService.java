package com.example.authentication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.authentication.Repository.RolePermissionRepository;
import com.example.authentication.entity.RolePermissionEntity;

@Service
public class RolePermissionService {

	@Autowired
	private RolePermissionRepository repository;

	public RolePermissionEntity Setrolepermission(RolePermissionEntity entity) {
		return this.repository.save(entity);
	}
}
