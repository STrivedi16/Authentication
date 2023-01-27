package com.example.authentication.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class EmployeeRoleEntity {

	@Id
	int id;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Employee> emp_id;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Role> role_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Employee> getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(List<Employee> emp_id) {
		this.emp_id = emp_id;
	}

	public List<Role> getRole_id() {
		return role_id;
	}

	public void setRole_id(List<Role> role_id) {
		this.role_id = role_id;
	}

	public EmployeeRoleEntity(int id, List<Employee> emp_id, List<Role> role_id) {
		super();
		this.id = id;
		this.emp_id = emp_id;
		this.role_id = role_id;
	}

	@Override
	public String toString() {
		return "EmployeeRoleEntity [id=" + id + ", emp_id=" + emp_id + ", role_id=" + role_id + "]";
	}

	public EmployeeRoleEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

}
