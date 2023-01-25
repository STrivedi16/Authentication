package com.example.authentication.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.authentication.Interface.EmployeeId;
import com.example.authentication.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	Employee findByEmailIgnoreCase(String email);

	List<EmployeeId> findById(int id, Class<EmployeeId> class1);

}
