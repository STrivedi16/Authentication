package com.example.authentication.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.authentication.Responce.ErrorMessage;
import com.example.authentication.Responce.Success;
import com.example.authentication.entity.RolePermissionDTO;
import com.example.authentication.entity.RolePermissionEntity;
import com.example.authentication.service.RolePermissionService;

@RestController
public class RolePermissionController {

	@Autowired
	private RolePermissionService service;

	public ResponseEntity<?> rolepermission(@RequestBody RolePermissionDTO dto) {
		try {
			RolePermissionEntity entity = this.service.setrolepermission(dto);

			return new ResponseEntity<>(new Success("Success", "success", entity), HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<>(new ErrorMessage("Error", "Error"), HttpStatus.NOT_FOUND);
		}
	}
}
