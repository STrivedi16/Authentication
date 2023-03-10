package com.example.authentication.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.authentication.service.CustomerUserDetailService;

@Configuration // TO GENERATE BEAN AND WHILE EXCUTION TO ADD BEAN
@EnableWebSecurity // TO PROVIDE A SECURUTY
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebsecuityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomerUserDetailService customerUserDetailService;

	@Autowired
	private JwtFilter filter;

	@Autowired
	private JwtAuthEntryPoint entryPoint;

	@Override
	protected void configure(HttpSecurity http) throws Exception { // to permit the url

		http.csrf() // we don't need of csrf cross site request forgery cors cross origin resource
					// sharing
				.disable().cors().disable().authorizeRequests()// Don't authenticate this particular request

				// .antMatchers("/employee", "/Welcome/**",
				// "/role/**").hasRole("admin").antMatchers("/Welcome/**")
				// .hasRole("admin")
				.antMatchers("/token", "/register", "/forgetPassword/**").permitAll()

				// ALL OTHER REQUEST NEED TO BE AUTHENTICATE
				.anyRequest().authenticated().and().httpBasic().and()

				// MAKE SURE WE USE STATELESS SESSION ,, SESSION WANT BE USED TO STORE USER'S
				// STATE
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().exceptionHandling()
				.authenticationEntryPoint(entryPoint);

		System.err.println("3 in web config");

		// Add a filter to validate the tokens with every request
		http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(customerUserDetailService); // to know what aurthencate want to use;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {

		return NoOpPasswordEncoder.getInstance();
	}

	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
}
