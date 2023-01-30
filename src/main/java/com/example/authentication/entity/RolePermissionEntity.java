package com.example.authentication.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class RolePermissionEntity {

	@Id
	private int id;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Role role_rid;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Permissions permissions_pid;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Role getRole_rid() {
		return role_rid;
	}

	public void setRole_rid(Role role_rid) {
		this.role_rid = role_rid;
	}

	public RolePermissionEntity(int id, Role role_rid, Permissions permissions_pid) {
		super();
		this.id = id;
		this.role_rid = role_rid;
		this.permissions_pid = permissions_pid;
	}

	public Permissions getPermissions_pid() {
		return permissions_pid;
	}

	public void setPermissions_pid(Permissions permissions_pid) {
		this.permissions_pid = permissions_pid;
	}

	public RolePermissionEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

}
