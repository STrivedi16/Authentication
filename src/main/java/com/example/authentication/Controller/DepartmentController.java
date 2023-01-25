package com.example.authentication.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.authentication.Responce.ErrorMessage;
import com.example.authentication.Responce.Success;
import com.example.authentication.entity.Department;
import com.example.authentication.service.DepartmentService;

@RestController
public class DepartmentController {

	@Autowired
	private DepartmentService service;

	@PostMapping("/DepartMent")
	public ResponseEntity<?> setdetail(Department department)

	{
		try {
			Department department2 = this.service.setRecord(department);

			return new ResponseEntity<>(new Success("success", "Successfull", department2), HttpStatus.OK);
		} catch (Exception e) {

			return new ResponseEntity<>(new ErrorMessage("Error ", "Not Stored"), HttpStatus.OK);
		}

	}

}
