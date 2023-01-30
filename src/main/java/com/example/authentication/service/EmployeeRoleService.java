package com.example.authentication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.authentication.Repository.EmployeeRepository;
import com.example.authentication.Repository.EmployeeRoleRepository;
import com.example.authentication.Repository.RoleRepository;
import com.example.authentication.entity.Employee;
import com.example.authentication.entity.EmployeeRoleentity;
import com.example.authentication.entity.EmployeeroleDTO;
import com.example.authentication.entity.Role;

@Service
public class EmployeeRoleService {

	@Autowired
	private EmployeeRoleRepository employeeRoleRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private RoleRepository repository;

	public EmployeeRoleentity addroleemployee(EmployeeroleDTO dto) throws Exception {
		Employee employee = this.employeeRepository.findById(dto.getEmployeeid())
				.orElseThrow(() -> new Exception("User not found"));

		Role role = this.repository.findById(dto.getRoleid()).orElseThrow(() -> new Exception("Role is not found"));

		EmployeeRoleentity roleentity = new EmployeeRoleentity();

		roleentity.setEmployee(employee);
		roleentity.setRole(role);

		this.employeeRoleRepository.save(roleentity);

		return roleentity;
	}
}
