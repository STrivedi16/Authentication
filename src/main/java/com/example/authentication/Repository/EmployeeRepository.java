package com.example.authentication.Repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.authentication.Interface.EmployeeToPermission;
import com.example.authentication.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	Employee findByEmailIgnoreCase(String email);

	// List<EmployeeId> findById(int id, Class<EmployeeId> class1);

	@Query(value = "select  emp.id, r.role, p.permission from employee emp\r\n"
			+ "join employee_roleentity emr on emp.id = emr.employee_id\r\n" + "join role r on emr.role_id= r.id\r\n"
			+ "join role_permission_entity rpe on r.id= rpe.role_rid_id\r\n"
			+ "join permissions p on p.id= rpe.permissions_pid_id  where emp.id= :idnumber", nativeQuery = true)
	List<EmployeeToPermission> findById(@Param("idnumber") int id, Class<EmployeeToPermission> class1);

	Employee save(String employee);

	Employee findById(int id);

	@Query(value = "select emp.name , emp.id, r.role, p.permission from employee emp\r\n"
			+ "join employee_roleentity emr on emp.id = emr.employee_id\r\n" + "join role r on emr.role_id= r.id\r\n"
			+ "join role_permission_entity rpe on r.id= rpe.role_rid_id\r\n"
			+ "join permissions p on p.id= rpe.permissions_pid_id", nativeQuery = true)
	List<EmployeeToPermission> findAll(Class<EmployeeToPermission> class1);

	ArrayList<String> getPermissionById(int id);

}
