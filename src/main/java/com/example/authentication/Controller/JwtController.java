package com.example.authentication.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.authentication.Responce.ErrorMessage;
import com.example.authentication.Responce.SuccessMessage;
import com.example.authentication.config.JwtRefreshToken;
import com.example.authentication.config.JwtTokenUtil;
import com.example.authentication.model.JwtRequest;
import com.example.authentication.service.CustomerUserDetailService;

@RestController
public class JwtController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private CustomerUserDetailService customerUserDetailService;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtRefreshToken refreshToken;

	@RequestMapping(value = "/token", method = RequestMethod.POST)
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
		System.out.println(jwtRequest);

		try {

			this.authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));

		} catch (Exception e) {
			e.printStackTrace();

			// throw new Exception("Bad creditaiol");

			return new ResponseEntity<>(new ErrorMessage("Bad creditaiol", "Did Not get"), HttpStatus.NOT_ACCEPTABLE);

		}

		UserDetails details = this.customerUserDetailService.loadUserByUsername(jwtRequest.getUsername());

		String token = this.jwtTokenUtil.generateToken(details);

		String reftoken = this.refreshToken.generatereftoken(details);

		System.out.println(token);

		System.out.println();

		System.out.println(reftoken);

		return new ResponseEntity<>(new SuccessMessage("Success", "success", token, reftoken), HttpStatus.OK);
	}

//	public ResponseEntity<?> setpassword(@RequestBody Employee employee) {
//		System.out.println(employee);
//		try {
//
//			this.authenticationManager
//			.authenticate(new Username)
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}

}
