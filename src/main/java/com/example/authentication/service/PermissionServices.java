package com.example.authentication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.authentication.Repository.PermissionRepository;
import com.example.authentication.entity.Permissions;

@Service
public class PermissionServices {

	@Autowired
	private PermissionRepository permissionRepository;

	public Permissions setpermission(Permissions permissions) {
		return this.permissionRepository.save(permissions);
	}

	public List<Permissions> getallpermission(Integer pagenumber, Integer pagesize) {
		org.springframework.data.domain.Pageable pageable = PageRequest.of(pagenumber, pagesize);

		Page<Permissions> page = this.permissionRepository.findAll(pageable);

		return page.getContent();
	}
}
