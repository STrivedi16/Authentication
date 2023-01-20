package com.example.authentication.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aurthenticate.Response.Success;
import com.example.authentication.entity.Student;

@RestController
//@RequestMapping("/student")
public class StudentCantroller {

	@Autowired
	private com.example.authentication.service.StudentService service;

	@PostMapping("/register")
	public ResponseEntity<?> insert(@RequestBody Student student) {

		System.err.println("238472392395235823hggddgsdghd");

		System.out.println(student);

		Student student2 = this.service.register(student);

		return new ResponseEntity<>(new Success("Success", "Success stored", student2), HttpStatus.OK);

	}

}
