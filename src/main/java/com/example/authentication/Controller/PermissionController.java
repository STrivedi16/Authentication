package com.example.authentication.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.authentication.Responce.ErrorMessage;
import com.example.authentication.Responce.Success;
import com.example.authentication.entity.Permissions;
import com.example.authentication.service.PermissionService;

@RestController
public class PermissionController {

	@Autowired
	private PermissionService service;

	@PostMapping("/permission")
	public ResponseEntity<?> setpermission(@RequestBody Permissions permissions) {

		try {

			Permissions permissions2 = this.service.setpermission(permissions);

			return new ResponseEntity<>(new Success("Success", "Successfull", permissions2), HttpStatus.CREATED);
		} catch (Exception e) {

			return new ResponseEntity<>(new ErrorMessage("Error  in Permission", "Error"), HttpStatus.BAD_REQUEST);
		}

	}

}
