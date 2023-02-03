package com.example.authentication.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {

	@RequestMapping(value = "/Welcome", method = RequestMethod.GET)
	public String welcome() {
		return "Welcome User to this page , this page is authenticate to other user so for that we need to give username and password  perfect";
	}

	@RequestMapping(value = "/Hello", method = RequestMethod.GET)
	public String Hello() {
		return "Hello";
	}

	@RequestMapping(value = "/Welcome/admin", method = RequestMethod.GET)
	public String New() {
		return "This is only for admin";
	}

	@RequestMapping(value = "/Welcome/new", method = RequestMethod.GET)
	public String New1() {
		return "Only Admin can use it";
	}

	@GetMapping("/admins")
	@PreAuthorize("hasAuthority	('getall')")
	public String adminaccess() {
		return "Hello page is get then it means You have Access if Not Then You Don't Have Access ";
	}

}
