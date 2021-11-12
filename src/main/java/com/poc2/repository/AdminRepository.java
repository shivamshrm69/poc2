package com.poc2.repository;

import org.springframework.data.repository.CrudRepository;

import com.poc2.entity.Admin_User;

public interface AdminRepository extends CrudRepository<Admin_User, Integer>{

	Admin_User findAllByEmail(String username);

}
