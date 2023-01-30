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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Role {

	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String role;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "role")
	@JsonIgnore
	private List<EmployeeRoleentity> emp;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "role_rid")
	@JsonIgnore
	private List<RolePermissionEntity> permisionid;

	@CreationTimestamp
	private Timestamp creationtime;

	@UpdateTimestamp
	private Timestamp updationtime;

	public Role(int id, String role, List<EmployeeRoleentity> emp, List<RolePermissionEntity> permisionid,
			Timestamp creationtime, Timestamp updationtime) {
		super();
		this.id = id;
		this.role = role;
		this.emp = emp;
		this.permisionid = permisionid;
		this.creationtime = creationtime;
		this.updationtime = updationtime;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Role(int id, String role) {
		super();
		this.id = id;
		this.role = role;
	}

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", role=" + role + ", emp=" + emp + "]";
	}

	public List<EmployeeRoleentity> getEmp() {
		return emp;
	}

	public void setEmp(List<EmployeeRoleentity> emp) {
		this.emp = emp;
	}

	public List<RolePermissionEntity> getPermisionid() {
		return permisionid;
	}

	public void setPermisionid(List<RolePermissionEntity> permisionid) {
		this.permisionid = permisionid;
	}

}
