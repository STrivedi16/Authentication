package com.example.authentication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.authentication.Repository.EmployeeRoleREpository;
import com.example.authentication.entity.EmployeeRoleEntity;

@Service
public class EmployeeRoleService {

	@Autowired
	private EmployeeRoleREpository employeeRoleREpository;

	public EmployeeRoleEntity Setrole(EmployeeRoleEntity employeeRoleEntity) {
		return this.employeeRoleREpository.save(employeeRoleEntity);
	}

}
