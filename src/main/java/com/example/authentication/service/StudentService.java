package com.example.authentication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	@Autowired
	private com.example.authenticate.Repository.StudentRepository repository;

	public com.example.authentication.entity.Student register(com.example.authentication.entity.Student student) {

		System.err.println("123456");

		return repository.save(student);

	}

}
