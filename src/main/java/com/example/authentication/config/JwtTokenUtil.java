package com.example.authentication.config;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.example.authentication.Repository.EmployeeRepository;
import com.example.authentication.entity.Employee;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

// CLASS HAS METHOD TO GENEREATE TOKEN
// VALIDATE TOKEN ,
// IS EXPIRE OR NOT 
@Component
public class JwtTokenUtil implements Serializable {

	@Autowired
	private EmployeeRepository employeeRepository;

	private static final long serialVersionUID = -2550185165626007488L;

	private static final long JWT_TOEKN_VALIDITY = 5 * 60 * 60;

//	private String secret = "Java@2711";

	@Value("${jwt.secret}")
	private String secret;

	// get username from token

	public String getUsernameFromToken(String token) {
		return getClaimFromToken(token, Claims::getSubject);

	}

	// get expiration date from token
	public Date getExpirationDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getExpiration);
	}

//	public String getUseridFromToken(String token) {
//		return getClaimFromToken(token, Claims::getId);
//	}

	public <T> T getClaimFromToken(String token, Function<Claims, T> claimResolver)

	{
		final Claims claims = getAllClaimsFromToken(token);

		return claimResolver.apply(claims);
	}

	// FROM RETRIEVING ANY INFORMATION FROM TOKEN WE WILL NEED SECRET KEY

	private Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}

	// CHECK THE TOKEN IS EXPIRED OR NOT
	public boolean isTokenExpire(String token) {
		final Date expiration = getExpirationDateFromToken(token);

		return expiration.before(new Date());
	}

	public String generateToken(UserDetails details) {
		HashMap<String, Object> claims = new HashMap<>();

		Employee employee = this.employeeRepository.findByEmailIgnoreCase(details.getUsername());

		claims.put(employee.getName(), employee.getAuthorities());
		return doGenerate(claims, details.getUsername());
	}

	// while creating the token -
	// 1. Define claims of the token, like Issuer, Expiration, Subject, and the ID
	// 2. Sign the JWT using the HS512 algorithm and secret key.
	// 3. According to JWS Compact
	// Serialization(https://tools.ietf.org/html/draft-ietf-jose-json-web-signature-41#section-3.1)
	// compaction of the JWT to a URL-safe string

	private String doGenerate(Map<String, Object> claims, String object) {
		return Jwts.builder().setClaims(claims).setSubject(object).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + JWT_TOEKN_VALIDITY * 1000))
				.signWith(SignatureAlgorithm.HS512, secret).compact();

	}

	// TO CHECK VALIDATE TOKEN

	public boolean validateToken(String token, UserDetails details) {
		final String username = getUsernameFromToken(token);

		return (username.equals(details.getUsername()) && !isTokenExpire(token));
	}
}
