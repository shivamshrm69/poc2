package com.poc2.repository;

import org.springframework.data.repository.CrudRepository;

import com.poc2.entity.Student_User;

public interface StudentRegistrationRepository extends CrudRepository<Student_User, Integer> {
	Student_User findAllByEmail(String username);
}
