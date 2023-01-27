package com.example.authentication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.authentication.entity.permission;

@Repository
public interface PermissionRepository extends JpaRepository<permission, Integer> {

}
