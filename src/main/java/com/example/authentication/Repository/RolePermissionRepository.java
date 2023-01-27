package com.example.authentication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.authentication.entity.RolePermissionEntity;

@Repository
public interface RolePermissionRepository extends JpaRepository<RolePermissionEntity, Integer> {

}
