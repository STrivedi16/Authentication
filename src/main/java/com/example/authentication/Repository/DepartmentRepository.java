package com.example.authentication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.authentication.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
