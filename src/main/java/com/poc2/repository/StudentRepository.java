package com.poc2.repository;

import org.springframework.data.repository.CrudRepository;

import com.poc2.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Integer>{

	

}
