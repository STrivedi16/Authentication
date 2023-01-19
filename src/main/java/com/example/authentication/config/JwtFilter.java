package com.example.authentication.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.authentication.service.CustomerUserDetailService;

@Component
public class JwtFilter extends OncePerRequestFilter {

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private CustomerUserDetailService customerUserDetailService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		// FIRST GET THE JWT OR HEADER
		// BEARER START OR NOT
		// VALIDATE OR NOT

		String requestHeader = request.getHeader("Authorization");

		String username = null;
		String token = null;

		// CHECK TOKEN IS NULL AND ALSO START WITH BEARER
		if (requestHeader != null && requestHeader.startsWith("Bearer ")) {
			token = requestHeader.substring(7);

			try {

				username = this.jwtTokenUtil.getUsernameFromToken(token);

				System.out.println(username);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			System.out.println("Don't Have Token");
		}

		// Security

		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			// GEt User Details from user
			UserDetails details = this.customerUserDetailService.loadUserByUsername(username);

			UsernamePasswordAuthenticationToken upat = new UsernamePasswordAuthenticationToken(details, null,
					details.getAuthorities());
			upat.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			// After setting the Authentication in the context, we specify
			// that the current user is authenticated. So it passes the
			// Spring Security Configurations successfully.

			SecurityContextHolder.getContext().setAuthentication(upat);

		} else {
			System.out.println("UserName is not valid");
		}

		filterChain.doFilter(request, response);

	}

}
