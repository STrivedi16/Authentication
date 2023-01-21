package com.example.authentication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.authentication.Repository.EmployeeRepository;
import com.example.authentication.entity.Employee;

@Service
public class CustomerUserDetailService implements UserDetailsService {

	@Autowired
	private EmployeeRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		try {
			Employee employee = this.repository.findByEmail(username);

			return employee;
		} catch (Exception e) {
			e.printStackTrace();

			throw new UsernameNotFoundException("User email is not valid and not found ");
		}
	}

}
