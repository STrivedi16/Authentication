package com.example.authentication.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import com.example.authentication.Interface.EmployeeToPermission;
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

//	public List<EmployeeId> GetById(int id) {
//
//		System.err.println(id + "this is id ");
//
//		return this.repository.findById(id, EmployeeId.class);
//	}

	public Employee Update(Employee employee) {
		return this.repository.save(employee);
	}

	public Employee forgotpass(Employee employee) throws Exception {

		Employee employee2 = this.repository.findByEmailIgnoreCase(employee.getEmail());

		employee2.setPassword(employee.getPassword());

		System.err.println(employee2);

		if (employee2 == null)
			throw new Exception("Your email is invalid ");

		return this.repository.save(employee2);
	}

	public List<EmployeeToPermission> getemp() {
		return this.repository.findAll(EmployeeToPermission.class);
	}

	public ArrayList<SimpleGrantedAuthority> getAutorities(int id) {

		ArrayList<SimpleGrantedAuthority> auth = new ArrayList<>();
		if (id + "permission" != null) {

			ArrayList<SimpleGrantedAuthority> auth1 = new ArrayList<>();
			List<EmployeeToPermission> al = this.repository.findById(id, EmployeeToPermission.class);

			ArrayList<String> authorities = new ArrayList<>();

			authorities.add(al.toString());

			System.err.println(authorities);

			al.forEach(e -> {
				auth1.add(new SimpleGrantedAuthority("ROLE_" + e.getPermission()));
			});

			auth = auth1;

		}
		return auth;

	}
}
