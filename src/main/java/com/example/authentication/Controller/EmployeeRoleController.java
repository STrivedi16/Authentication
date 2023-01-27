package com.example.authentication.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.authentication.Responce.ErrorMessage;
import com.example.authentication.Responce.Success;
import com.example.authentication.config.JwtFilter;
import com.example.authentication.entity.EmployeeRoleEntity;
import com.example.authentication.service.EmployeeRoleService;

@RestController
public class EmployeeRoleController {

	@Autowired
	private EmployeeRoleService roleService;

	JwtFilter filter = new JwtFilter();

	@PostMapping("/role/{id}")
	public ResponseEntity<?> setemprole(@RequestBody EmployeeRoleEntity employeeRoleEntity,
			@PathVariable("id") int id) {
		try {
			if (filter.id == id) {
				EmployeeRoleEntity entity = this.roleService.Setrole(employeeRoleEntity);
				return new ResponseEntity<>(new Success("Succcess", "Success", entity), HttpStatus.OK);
			}

			else {

				return new ResponseEntity<>(new ErrorMessage("You Have No Access", "Error"), HttpStatus.NOT_ACCEPTABLE);
			}

		} catch (Exception e) {

			return new ResponseEntity<>(new ErrorMessage("Error", "error"), HttpStatus.NOT_FOUND);

		}
	}

}
