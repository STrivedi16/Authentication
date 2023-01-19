package com.example.authentication.Controller;

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
}
