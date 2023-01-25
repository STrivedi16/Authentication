package com.example.authentication.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.authentication.Interface.EmployeeId;
import com.example.authentication.Responce.ErrorMessage;
import com.example.authentication.Responce.Success;
import com.example.authentication.config.JwtFilter;
import com.example.authentication.entity.Employee;
import com.example.authentication.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	public JwtFilter filter = new JwtFilter();

	@PostMapping("/register")
	public ResponseEntity<?> registeremp(@RequestBody Employee employee) {
		try {

			Employee employee2 = this.service.register(employee);

			return new ResponseEntity<>(new Success("Successfull", "Success", employee2), HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<>(new ErrorMessage("Email has already Stored", "Error"), HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/employee/{id}")
	public ResponseEntity<?> getinid(@PathVariable("id") int id) {
		try {

			int as = filter.id;

			System.err.println(as);

			if (as == id) {

				List<EmployeeId> list = this.service.GetById(id);

				return new ResponseEntity<>(new Success("Success", "successfull", list), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(
						new ErrorMessage("please enter Your id , you cannot Access Other Details", "Not  "),
						HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {

			return new ResponseEntity<>(new ErrorMessage("User Not Foud", "Error"), HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/id")
	public ResponseEntity<?> update(@RequestBody Employee employee, @PathVariable("id") int id) {

		try {

			int newid = filter.id;

			System.out.println(newid);

			if (id == newid) {
				Employee employee1 = this.service.Update(employee);

				return new ResponseEntity<>(new Success("Success", "Successsfull", employee1), HttpStatus.OK);

			} else {
				return new ResponseEntity<>(new ErrorMessage("Invelid id Please Enter Your id", "Error"),
						HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			return new ResponseEntity<>(new ErrorMessage("Error", "Error"), HttpStatus.NOT_FOUND);
		}

	}
}
