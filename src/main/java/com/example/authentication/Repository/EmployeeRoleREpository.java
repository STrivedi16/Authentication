package com.example.authentication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.authentication.entity.EmployeeRoleEntity;

@Repository
public interface EmployeeRoleREpository extends JpaRepository<EmployeeRoleEntity, Integer> {

}
