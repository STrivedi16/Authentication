package com.example.authentication.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.authentication.Responce.ErrorMessage;
import com.example.authentication.Responce.Success;
import com.example.authentication.entity.Permissions;
import com.example.authentication.service.PermissionServices;

@RestController
public class PermissionController {

	@Autowired
	private PermissionServices service;

	@PostMapping("/permission")
	public ResponseEntity<?> setpermission(@RequestBody Permissions permissions) {

		try {

			Permissions permissions2 = this.service.setpermission(permissions);

			return new ResponseEntity<>(new Success("Success", "Successfull", permissions2), HttpStatus.CREATED);
		} catch (Exception e) {

			return new ResponseEntity<>(new ErrorMessage("Error  in Permission", "Error"), HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("/page")
	public ResponseEntity<?> getpermission(
			@RequestParam(name = "pagenumber", defaultValue = "1", required = false) Integer pagenumber,
			@RequestParam(name = "pagesize", defaultValue = "5", required = false) Integer pagesize

	) {

		try {

			List<Permissions> list = this.service.getallpermission(pagenumber, pagesize);

			return new ResponseEntity<>(new Success("Success", "success", list), HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(new ErrorMessage("Error in permission", "Error"), HttpStatus.NOT_FOUND);
		}

	}

}
