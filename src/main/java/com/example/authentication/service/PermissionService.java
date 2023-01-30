package com.example.authentication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.authentication.Repository.PermissionRepository;
import com.example.authentication.entity.Permissions;

@Service
public class PermissionService {

	@Autowired
	private PermissionRepository repository;

	public Permissions setpermission(Permissions permissions) {
		return this.repository.save(permissions);
	}

}
