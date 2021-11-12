package com.poc2.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.poc2.entity.Admin_User;
import com.poc2.entity.Student_User;
import com.poc2.repository.AdminRepository;
import com.poc2.repository.StudentRegistrationRepository;

@Service
public class UserAuthServiceImpl implements UserDetailsService {
	@Autowired
	AdminRepository adminRepo;
	@Autowired
	StudentRegistrationRepository studentRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Student_User student = studentRepo.findAllByEmail(username);
		if (student == null) {
			Admin_User admin = adminRepo.findAllByEmail(username);
			if (admin == null) {
				throw new UsernameNotFoundException("user not found");
			} else {
				AdminAuth admin_user = new AdminAuth(admin);
				return admin_user;
			}

		}

		StudentAuth studentAuth = new StudentAuth(student);

		return studentAuth;
	}

}
