package com.example.authentication.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomerUserDetailService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		if (username.equals("Rojer")) {
			return new User("Rojer", "Rojer@2711", new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("UserName is not found in CustomerUserDetailService");
		}
	}

}
