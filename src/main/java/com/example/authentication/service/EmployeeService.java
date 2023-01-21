package com.example.authentication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.authentication.Repository.EmployeeRepository;
import com.example.authentication.entity.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	public Employee register(Employee employee) {
		return this.repository.save(employee);
	}
}
