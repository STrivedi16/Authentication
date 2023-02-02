package com.example.authentication.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
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

	@Autowired
	private EmployeeService employeeService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		try {
			Employee employee = this.repository.findByEmailIgnoreCase(username);

			ArrayList<SimpleGrantedAuthority> arrayList = this.employeeService.getAutorities(employee.getId());

			// System.err.println("Premission are" + arrayList.toString());

			// ArrayList<String> al = new ArrayList<>();

			// al.add(arrayList.toString());

			// System.out.println(al);

			System.out.println("All permission=" + arrayList);

//			Collection<? extends GrantedAuthority> list = arrayList;
//
//			System.out.println(list);

			return new User(employee.getEmail(), employee.getPassword(), arrayList);

		} catch (Exception e) {
			e.printStackTrace();

			throw new UsernameNotFoundException("User email is not valid and not found ");
		}
	}

}
