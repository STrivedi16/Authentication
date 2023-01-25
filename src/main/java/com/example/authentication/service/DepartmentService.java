package com.example.authentication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.authentication.Repository.DepartmentRepository;
import com.example.authentication.entity.Department;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository repository;

	public Department setRecord(Department department) {
		return this.repository.save(department);
	}

}
