package com.example.authentication.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.authentication.Responce.ErrorMessage;
import com.example.authentication.Responce.Success;
import com.example.authentication.entity.Role;
import com.example.authentication.service.RoleService;

@RestController
public class RoleController {

	@Autowired
	private RoleService roleService;

	@PostMapping("/role")
	public ResponseEntity<?> setrole(@RequestBody Role role) {
		try {

			Role role2 = this.roleService.setrole(role);

			return new ResponseEntity<>(new Success("Success", "Success", role2), HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(new ErrorMessage("Error", "Error"), HttpStatus.NOT_ACCEPTABLE);
		}
	}

}
