package com.example.authentication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.authentication.entity.Permissions;

@Repository
public interface PermissionRepository extends JpaRepository<Permissions, Integer> {

}
