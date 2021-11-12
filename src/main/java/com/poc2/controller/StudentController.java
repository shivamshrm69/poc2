package com.poc2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc2.entity.Student;
import com.poc2.entity.Student_User;
import com.poc2.response.ApiResponse;
import com.poc2.security.StudentAuth;
import com.poc2.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
@Autowired
BCryptPasswordEncoder passwordEncoder;
	@Autowired
	StudentService studentService;
	
	@PostMapping("/saveStudent")
	public ApiResponse saveStudent(@RequestBody Student student)
	{
		ApiResponse response=new ApiResponse();
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		if(auth instanceof AnonymousAuthenticationToken)
		{
			response.getResult().put("Error", "Please Login First");
			response.setSuccess(false);
			return response;
		}
		 Object principal = null;
	     
		    if (auth != null) {
		        principal = auth.getPrincipal();
		    }
		    if(principal instanceof StudentAuth)
		    {
		    	StudentAuth studAuth= (StudentAuth) auth.getPrincipal();
		    	Student_User stud= studAuth.getStudentUser();
		    	student.setEmail(stud.getEmail());
		    	student.setStudent_id(stud.getStudent_id());
		    }
		boolean isDone=studentService.saveStudent(student);
		if(isDone==false)
		{
			response.getResult().put("Error", "Something went wrong");
			response.setSuccess(isDone);
			return response;
		}
		response.getResult().put("Success", "Student saved successfully!");
		response.setSuccess(isDone);
		return response;
	}
	
	
}
