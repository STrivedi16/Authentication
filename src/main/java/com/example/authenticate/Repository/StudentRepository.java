package com.example.authenticate.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<com.example.authentication.entity.Student, Integer> {

}
