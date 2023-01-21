package com.example.authentication.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Department {

	@Id
	private int id;

	private String dept;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "dept")
	private Employee emp;
}
