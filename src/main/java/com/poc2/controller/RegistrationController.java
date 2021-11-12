package com.poc2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.poc2.entity.Admin_User;
import com.poc2.entity.Student_User;
import com.poc2.response.ApiResponse;
import com.poc2.service.AdminService;
import com.poc2.service.StudentService;

@RestController
public class RegistrationController {
	@Autowired
	StudentService studentService;
	@Autowired
	AdminService adminService;
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@PostMapping("/adminRegistration")
	public ApiResponse saveStudent(@RequestBody Admin_User admin) {
		ApiResponse response = new ApiResponse();
		admin.setPassword(passwordEncoder.encode(admin.getPassword()));
		boolean isDone = adminService.saveAdmin(admin);
		if (isDone == false) {
			response.getResult().put("Error", "Something went wrong");
			response.setSuccess(isDone);
			return response;
		}
		response.getResult().put("Success", "Admin saved successfully!");
		response.setSuccess(isDone);
		return response;
	}

	@PostMapping("/studentRegistration")
	public ApiResponse saveStudent(@RequestBody Student_User student) {
		ApiResponse response = new ApiResponse();
		student.setPassword(passwordEncoder.encode(student.getPassword()));
		boolean isDone = studentService.studentRegistration(student);
		if (isDone == false) {
			response.getResult().put("Error", "Something went wrong");
			response.setSuccess(isDone);
			return response;
		}
		response.getResult().put("Success", "Student saved successfully!");
		response.setSuccess(isDone);
		return response;
	}

}
