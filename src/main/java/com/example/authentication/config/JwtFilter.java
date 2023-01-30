package com.example.authentication.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.authentication.Repository.EmployeeRepository;
import com.example.authentication.Responce.ErrorMessage;
import com.example.authentication.entity.Employee;
import com.example.authentication.service.CustomerUserDetailService;

@Component
@ComponentScan
public class JwtFilter extends OncePerRequestFilter // It one type of filter
{

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private CustomerUserDetailService custmUserDetailService;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private JwtRefreshToken refreshToken;

	public static int id = 0;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		// FIRST GET JWT OR HEADER
		// BEARER START OR NOT
		// VALIDATE

		String requsetHeader = request.getHeader("Authorization");

		String username = null;

		String jwtToken = null;

		String reftoken = null;

		String str = null;

		// CHECKIN NULL AND FORMAT
		if (requsetHeader != null && requsetHeader.startsWith("Bearer ")) {
			jwtToken = requsetHeader.substring(7);
			try {

				username = this.jwtTokenUtil.getUsernameFromToken(jwtToken);

				str = this.refreshToken.getValidation(jwtToken);

				System.out.println(str);

				System.err.println(username);

				Employee employee = this.employeeRepository.findByEmailIgnoreCase(username);

				id = employee.getId();

				System.err.println(id);

			} catch (Exception e) {
				new ResponseEntity<>(new ErrorMessage("Error in Token or Your Token s invelid", "Error"),
						HttpStatus.UNAUTHORIZED);
			}
		} else {

			System.err.println("123- first in filter");
			System.out.println("Your token is not valid ");
		}

		// security

		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

			// GET USER DETAILS OF USER
			UserDetails details = this.custmUserDetailService.loadUserByUsername(username);

			UsernamePasswordAuthenticationToken upat = new UsernamePasswordAuthenticationToken(details, null,
					details.getAuthorities());

			upat.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

			// After setting the Authentication in the context, we specify
			// that the current user is authenticated. So it passes the
			// Spring Security Configurations successfully.
			SecurityContextHolder.getContext().setAuthentication(upat);
		} else {
			System.out.println("Username is not valid 12312 ");

//			response.sendError(401, "Your Token Is Not Valid");
		}

		filterChain.doFilter(request, response);

	}

}
