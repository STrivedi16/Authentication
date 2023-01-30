package com.example.authentication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.authentication.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

	Role findById(int id);
}
