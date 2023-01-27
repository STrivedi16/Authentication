package com.example.authentication.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class RolePermissionEntity {

	@Id
	private int id;

	@ManyToMany(cascade = CascadeType.ALL)
	private List<Role> role_id;

	@ManyToMany(cascade = CascadeType.ALL)
	private List<permission> permission_id;
}
