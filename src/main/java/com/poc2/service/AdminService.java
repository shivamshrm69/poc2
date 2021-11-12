package com.poc2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc2.entity.Admin_User;
import com.poc2.repository.AdminRepository;

@Service
public class AdminService {
@Autowired
AdminRepository adminRepository;
	public boolean saveAdmin(Admin_User admin) {
		try {
			adminRepository.save(admin);
		return true;
		}catch (Exception e) {
			return false;
		}
		
	}
}
