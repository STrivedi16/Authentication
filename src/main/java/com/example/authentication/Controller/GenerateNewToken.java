package com.example.authentication.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.authentication.Repository.EmployeeRepository;
import com.example.authentication.Responce.ErrorMessage;
import com.example.authentication.Responce.Successtoken;
import com.example.authentication.config.JwtRefreshToken;
import com.example.authentication.config.JwtTokenUtil;
import com.example.authentication.entity.Employee;
import com.example.authentication.service.CustomerUserDetailService;

@RestController
public class GenerateNewToken {

	@Autowired
	private JwtRefreshToken jwtRefreshToken;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private CustomerUserDetailService detailService;

	@GetMapping("/genratetoken")
	public ResponseEntity<?> genratenewtoken(
			@RequestParam(name = "refreshtoken", defaultValue = "", required = false) String token) throws Exception {

		String type = this.jwtRefreshToken.getTypeFromToken(token);
		String username = this.jwtRefreshToken.getUsernameFromToken(token);

		Employee employee = this.employeeRepository.findByEmailIgnoreCase(username);

		if (employee == null)
			throw new Exception("User details not found");

		System.out.println(type);
		if (type.equalsIgnoreCase("refresh")) {

			System.err.println("Useranem get from token  " + username);

			UserDetails details = this.detailService.loadUserByUsername(employee.getEmail());

			String gettoken = this.jwtTokenUtil.generateToken(details);

			System.out.println(gettoken);

			return new ResponseEntity<>(new Successtoken("Success", "Success", gettoken), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new ErrorMessage("Invalid token", "Invaid token "), HttpStatus.NOT_FOUND);
		}

	}
}
