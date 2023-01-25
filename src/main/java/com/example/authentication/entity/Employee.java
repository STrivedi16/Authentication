package com.example.authentication.entity;

import java.sql.Timestamp;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Employee implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String name;

	private String city;

	@Column(unique = true)
	private String email;

	private String password;

	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Department dept;

	@CreationTimestamp
	private Timestamp creationtime;

	@UpdateTimestamp
	private Timestamp updationtime;

//	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@JoinTable(name = "employee_role", joinColumns = @JoinColumn(name = "Employee", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "Role", referencedColumnName = "id"))
//	@JsonIgnore
//	private List<Role> roles;

	public Timestamp getCreationtime() {
		return creationtime;
	}

	public void setCreationtime(Timestamp creationtime) {
		this.creationtime = creationtime;
	}

	public Timestamp getUpdationtime() {
		return updationtime;
	}

	public void setUpdationtime(Timestamp updationtime) {
		this.updationtime = updationtime;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

//		java.util.List<SimpleGrantedAuthority> list = this.roles.stream()
//				.map((role) -> new SimpleGrantedAuthority(role.getRole())).collect(Collectors.toList());

		return null;
	}

	public Employee(int id, String name, String city, String email, String password, Department dept,
			Timestamp creationtime, Timestamp updationtime /* List<Role> roles */) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.email = email;
		this.password = password;
		this.dept = dept;
		this.creationtime = creationtime;
		this.updationtime = updationtime;
		// this.roles = roles;
	}
//
//	public List<Role> getRoles() {
//		return roles;
//	}
//
//	public void setRoles(List<Role> roles) {
//		this.roles = roles;
//	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.email;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", city=" + city + ", email=" + email + ", password="
				+ password + ", dept=" + dept + "]";
	}

//	@ManyToMany(cascade = CascadeType.ALL)
	// private Role role;

}
