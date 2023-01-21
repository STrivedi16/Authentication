package com.example.authentication.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.authentication.service.CustomerUserDetailService;

@Component
@ComponentScan
public class JwtFilter extends OncePerRequestFilter // It one type of filter
{

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private CustomerUserDetailService custmUserDetailService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		// FIRST GET JWT OR HEADER
		// BEARER START OR NOT
		// VALIDATE

		String requsetHeader = request.getHeader("Authorization");

		String username = null;

		String jwtToken = null;

		// CHECKIN NULL AND FORMAT
		if (requsetHeader != null && requsetHeader.startsWith("Bearer ")) {
			jwtToken = requsetHeader.substring(7);
			try {
				System.err.println("123- first in filter");
				username = this.jwtTokenUtil.getUsernameFromToken(jwtToken);
				System.err.println("Token is get");
				System.out.println(username);

			} catch (Exception e) {
				e.printStackTrace();
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
			System.out.println("Username is not valid  ");
		}

		filterChain.doFilter(request, response);

	}

}
