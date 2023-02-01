package com.example.authentication.entity;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.example.authentication.Controller.EmployeeController;

public class Authority extends Employee {

	@Autowired
	private EmployeeController controller;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		ArrayList<SimpleGrantedAuthority> al = this.controller.al;

		return al;
	}

}
