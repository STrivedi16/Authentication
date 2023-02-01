package com.example.authentication.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.authentication.Interface.EmployeeToPermission;
import com.example.authentication.Responce.ErrorMessage;
import com.example.authentication.Responce.Success;
import com.example.authentication.config.JwtFilter;
import com.example.authentication.entity.Employee;
import com.example.authentication.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@Autowired
	private PasswordRegax regax;

	public JwtFilter filter = new JwtFilter();

	@PostMapping("/register")
	public ResponseEntity<?> registeremp(@RequestBody Employee employee) {
		try {

			System.err.println(employee.getPassword());

			Pattern p = Pattern.compile("((?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20})");

			// Matcher matcher = regax.pattern.matcher(employee.getPassword());

			System.err.println("now we can get the password");

			Matcher matcher = p.matcher(employee.getPassword());

			System.err.println(matcher.matches());

			if (matcher.matches()) {

				System.err.println("in if condition");

				Employee employee2 = this.service.register(employee);

				return new ResponseEntity<>(new Success("Successfull", "Success", employee2), HttpStatus.OK);

			} else {
				return new ResponseEntity<>(new ErrorMessage(
						"Your Password is invalid ,Password Contain Atleast one Digit , one Letter, One Spcial Char, one Uppercase Leter",
						"Error"), HttpStatus.NOT_ACCEPTABLE);
			}

		} catch (Exception e) {

			return new ResponseEntity<>(new ErrorMessage("Email has already Stored	", "Error"), HttpStatus.NOT_FOUND);
		}
	}
//
//	@GetMapping("/employee/{id}")
//	public ResponseEntity<?> getinid(@PathVariable("id") int id) {
//		try {
//
//			int as = filter.id;
//
//			System.err.println(as);
//
//			if (as == id) {
//
//				System.err.println("123456789");
//				List<EmployeeId> list = this.service.GetById(id);
//
//				return new ResponseEntity<>(new Success("Success", "successfull", list), HttpStatus.OK);
//			} else {
//				return new ResponseEntity<>(
//						new ErrorMessage("please enter Your id , you cannot Access Other Details", "Not  "),
//						HttpStatus.NOT_FOUND);
//			}
//		} catch (Exception e) {
//
//			return new ResponseEntity<>(new ErrorMessage("User Not Foud", "Error"), HttpStatus.NOT_FOUND);
//		}
//	}

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

	@PutMapping("/forgetPassword/{email}")
	public ResponseEntity<?> Forgetpassword(@RequestBody Employee employee, @PathVariable("email") String email) {
		try {

			System.out.println(email);

			System.err.println(employee);

			Employee employee2 = this.service.forgotpass(employee);

			System.out.println(employee2);

			return new ResponseEntity<>(new Success("Password Change", "Success", employee2), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(
					new ErrorMessage("Your password is not change,You might have enter wrong email ", "Error"),
					HttpStatus.NOT_FOUND);
		}

	}

	public List<EmployeeToPermission> list;

	@GetMapping("/get")
	public ResponseEntity<?> getall() {
		try {

			list = this.service.getemp();

			return new ResponseEntity<>(new Success("Success", "success", list), HttpStatus.OK);
		} catch (Exception e) {

			return new ResponseEntity<>(new ErrorMessage("Error", "Error in Emp role list"), HttpStatus.NOT_FOUND);
		}
	}

	public ArrayList<SimpleGrantedAuthority> al;

	@GetMapping("/get/{id}")
	public ResponseEntity<?> getpermission(@PathVariable("id") int id) {
		try {

			al = this.service.getAutorities(id);

			return new ResponseEntity<>(new Success("Success", "success", al), HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(new ErrorMessage("Error in permission", "Error in  role list"),
					HttpStatus.NOT_FOUND);

		}
	}

}
