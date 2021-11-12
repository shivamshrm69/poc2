package com.poc2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc2.entity.Admin_User;
import com.poc2.entity.Student;
import com.poc2.response.ApiResponse;
import com.poc2.service.AdminService;
import com.poc2.service.StudentService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	StudentService studentService;
	@Autowired
	AdminService adminService;
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
		
	@GetMapping("/getAll")
	public ApiResponse getAllStudent()
	{
		ApiResponse response=new ApiResponse();
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		if(auth instanceof AnonymousAuthenticationToken)
		{
			response.getResult().put("Error", "Please Login First");
			response.setSuccess(false);
			return response;
		}
		List<Student> students=studentService.getAllStudent();
		if(students==null)
		{
			response.getResult().put("Error", "Something went wrong");
			response.setSuccess(false);
		}else if(students.isEmpty())
		{
			response.getResult().put("Success", "No Student Found!");
			response.setSuccess(true);
		}
		response.setSuccess(true);
		response.getResult().put("students", students);
		return response;
	}
	
	@GetMapping("/findByStudentId/{student_id}")
	public ApiResponse findByStudentId(@PathVariable int student_id)
	{
		ApiResponse response=new ApiResponse();
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		if(auth instanceof AnonymousAuthenticationToken)
		{
			response.getResult().put("Error", "Please Login First");
			response.setSuccess(false);
			return response;
		}
		Optional<Student> data=studentService.findByStudentId(student_id);
		Student student=data.get();
		if(student==null)
		{
			response.getResult().put("Error", "Something went wrong");
			response.setSuccess(false);
		}
		response.getResult().put("student", student);
		return response;
	}
}
