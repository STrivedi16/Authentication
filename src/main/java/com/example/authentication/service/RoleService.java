package com.example.authentication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.authentication.Repository.RoleRepository;
import com.example.authentication.entity.Role;

@Service
public class RoleService {

	@Autowired
	private RoleRepository repository;

	public Role setrole(Role role) {
		return this.repository.save(role);
	}

}
