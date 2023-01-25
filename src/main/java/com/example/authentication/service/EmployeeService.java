package com.example.authentication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.authentication.Interface.EmployeeId;
import com.example.authentication.Repository.EmployeeRepository;
import com.example.authentication.entity.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	public Employee register(Employee employee) throws Exception {

		Employee employee2 = this.repository.findByEmailIgnoreCase(employee.getEmail());

		if (employee2 != null)
			throw new Exception("Record already exits");

		return this.repository.save(employee);

	}

	public List<EmployeeId> GetById(int id) {

		return this.repository.findById(id, EmployeeId.class);
	}

	public Employee Update(Employee employee) {
		return this.repository.save(employee);
	}

}
