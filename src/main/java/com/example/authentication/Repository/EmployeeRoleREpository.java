package com.example.authentication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.authentication.entity.EmployeeRoleentity;

@Repository
public interface EmployeeRoleRepository extends JpaRepository<EmployeeRoleentity, Integer> {

}
