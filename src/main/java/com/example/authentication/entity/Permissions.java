package com.example.authentication.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Permissions {

	@Id
	private int id;

	private String permission;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "permissions_pid")
	private List<RolePermissionEntity> roleid;

	@CreationTimestamp
	private Timestamp creationtime;

	@UpdateTimestamp
	private Timestamp updationtime;

	public Permissions(int id, String permission, List<RolePermissionEntity> roleid, Timestamp creationtime,
			Timestamp updationtime) {
		super();
		this.id = id;
		this.permission = permission;
		this.roleid = roleid;
		this.creationtime = creationtime;
		this.updationtime = updationtime;
	}

	public List<RolePermissionEntity> getRoleid() {
		return roleid;
	}

	public void setRoleid(List<RolePermissionEntity> roleid) {
		this.roleid = roleid;
	}

	public Timestamp getCreationtime() {
		return creationtime;
	}

	public void setCreationtime(Timestamp creationtime) {
		this.creationtime = creationtime;
	}

	public Timestamp getUpdationtime() {
		return updationtime;
	}

	public void setUpdationtime(Timestamp updationtime) {
		this.updationtime = updationtime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public Permissions() {
		super();
		// TODO Auto-generated constructor stub
	}

}
