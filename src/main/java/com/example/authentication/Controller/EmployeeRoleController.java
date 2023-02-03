package com.example.authentication.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.authentication.Responce.ErrorMessage;
import com.example.authentication.Responce.Success;
import com.example.authentication.entity.EmployeeRoleentity;
import com.example.authentication.entity.EmployeeroleDTO;
import com.example.authentication.service.EmployeeRoleService;

@RestController
public class EmployeeRoleController {

	@Autowired
	private EmployeeRoleService service;

	@PostMapping("/employeerole")
	@PreAuthorize("hasAuthority	('assignRole')")
	public ResponseEntity<?> Setroletoemployee(@RequestBody EmployeeroleDTO employeeRoleentity) {
		try {

			System.err.println(employeeRoleentity.getEmployeeid() + " " + employeeRoleentity.getRoleid());

			EmployeeRoleentity employeeRoleentity2 = this.service.addroleemployee(employeeRoleentity);

			return new ResponseEntity<>(new Success("Success", "Success",
					(employeeRoleentity2.getEmployee() + "" + employeeRoleentity2.getRole())), HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<>(new ErrorMessage("Error in creating", "Error"), HttpStatus.NOT_ACCEPTABLE);
		}
	}
}
