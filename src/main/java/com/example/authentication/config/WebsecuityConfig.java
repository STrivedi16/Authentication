package com.example.authentication.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.authentication.service.CustomerUserDetailService;

@Configuration
@EnableWebSecurity
public class WebsecuityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomerUserDetailService detailService;

	@Autowired
	private JwtFilter filter;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(detailService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf() // we don't need of cross site request forgery and cross origin resource sharing
				.disable().cors().disable().authorizeRequests()
				// Don't authenticate this request
				.antMatchers("/token", "/Hello").permitAll()

				// all other request need to be authenticate
				.anyRequest().authenticated().and()

				// we have to use session stateless , session want be used to store user's sate
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
	}

	@Bean
	public PasswordEncoder encoder() {

		return NoOpPasswordEncoder.getInstance();
	}

	@Bean
	public AuthenticationManager authManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
}
