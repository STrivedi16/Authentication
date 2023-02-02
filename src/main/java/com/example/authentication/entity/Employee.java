package com.example.authentication.entity;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.authentication.service.EmployeeService;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@SQLDelete(sql = "update Employee set is_active=false where id=?")
@Where(clause = "is_active=true")
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

	private boolean is_active = true;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "employee")
//	@JoinTable(name = "employee_role", joinColumns = @JoinColumn(name = "Employee", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "Role", referencedColumnName = "id"))
	@JsonIgnore
	private List<EmployeeRoleentity> role;

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

//	@Autowired
//	private EmployeeController controller;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

//		EmployeeController controller = new EmployeeController();
//
		// ArrayList<SimpleGrantedAuthority> al = controller.al;

		// List<EmployeeToPermission> list = this.service.getemp();
		// java.util.List<SimpleGrantedAuthority> list = al.stream()
		// .map((role) -> new
		// SimpleGrantedAuthority(role.getPermission())).collect(Collectors.toList());

		EmployeeService employeeService = new EmployeeService();
//
//		// employeeService.getAutorities(id);

		// ArrayList<SimpleGrantedAuthority> al =employeeService.getAutorities(id);

//
//		al.forEach(e -> e.getAuthority());

		return null;
	}

	public Employee(int id, String name, String city, String email, String password, Department dept,
			Timestamp creationtime, Timestamp updationtime, List<EmployeeRoleentity> roles) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.email = email;
		this.password = password;
		this.dept = dept;
		this.creationtime = creationtime;
		this.updationtime = updationtime;
		this.role = roles;
	}

	public List<EmployeeRoleentity> getRole() {
		return role;
	}

	public void setRole(List<EmployeeRoleentity> role) {
		this.role = role;
	}

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

	public boolean isIs_active() {
		return is_active;
	}

	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}

//	Pattern p = Pattern.compile("((?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8-20})");
//	Matcher m = p.matcher(password);

}
