package com.example.authentication.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class permission {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String actionname;

	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "permission_id")
	private List<RolePermissionEntity> role;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getActionname() {
		return actionname;
	}

	public void setActionname(String actionname) {
		this.actionname = actionname;
	}

	public List<RolePermissionEntity> getRole() {
		return role;
	}

	public void setRole(List<RolePermissionEntity> role) {
		this.role = role;
	}

	public permission(int id, String actionname, List<RolePermissionEntity> role) {
		super();
		this.id = id;
		this.actionname = actionname;
		this.role = role;
	}

	public permission() {
		super();
		// TODO Auto-generated constructor stub
	}

}
