package com.example.authentication.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String department;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "dept")
	private Employee emp;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	public Department(int id, String department, Employee emp) {
		super();
		this.id = id;
		this.department = department;
		this.emp = emp;
	}

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

}
