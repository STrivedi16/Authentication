package com.example.authentication.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.authentication.Responce.ErrorMessage;
import com.example.authentication.Responce.Success;
import com.example.authentication.entity.Employee;
import com.example.authentication.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@PostMapping("/register")
	public ResponseEntity<?> registeremp(@RequestBody Employee employee) {
		try {

			Employee employee2 = this.service.register(employee);

			return new ResponseEntity<>(new Success("Successfull", "Success", employee2), HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<>(new ErrorMessage("Error in Stored ", "Error"), HttpStatus.NOT_FOUND);
		}
	}
}
