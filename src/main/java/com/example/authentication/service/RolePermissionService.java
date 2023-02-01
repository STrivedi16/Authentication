package com.example.authentication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.authentication.Repository.PermissionRepository;
import com.example.authentication.Repository.RolePermissionRepository;
import com.example.authentication.Repository.RoleRepository;
import com.example.authentication.entity.Permissions;
import com.example.authentication.entity.Role;
import com.example.authentication.entity.RolePermissionDTO;
import com.example.authentication.entity.RolePermissionEntity;

@Service
public class RolePermissionService {

	@Autowired
	private RolePermissionRepository repository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PermissionRepository permissionRepository;

	public RolePermissionEntity setrolepermission(RolePermissionDTO dto) throws Exception {
		Role role = this.roleRepository.findById(dto.getRoleid()).orElseThrow(() -> new Exception("Role not Found"));

		Permissions permissions = this.permissionRepository.findById(dto.getPermissionid())
				.orElseThrow(() -> new Exception("Permission not Found"));

		RolePermissionEntity entity = new RolePermissionEntity();

		entity.setPermissions_pid(permissions);

		entity.setRole_rid(role);

		return this.repository.save(entity);

	}

	public java.util.List<RolePermissionEntity> getrolepermission() {

		return this.repository.findAll();
	}

}
