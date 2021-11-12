package com.poc2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc2.entity.Student;
import com.poc2.entity.Student_User;
import com.poc2.repository.StudentRegistrationRepository;
import com.poc2.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	@Autowired
	StudentRegistrationRepository studentRegistrationRepository;
	
	public boolean saveStudent(Student student) {
		try {
		studentRepository.save(student);
		return true;
		}catch (Exception e) {
			return false;
		}
		
	}
	public List<Student> getAllStudent() {
	try
	{
		List<Student> students=(List<Student>) studentRepository.findAll();
		return students;
	}catch (Exception e) {
		return null;
	}
		
	}
	public Optional<Student> findByStudentId(int student_id) {
		try
		{
		Optional<Student> student=studentRepository.findById(student_id);
		return student;
		}catch (Exception e) {
			return null;
		}
		
	}
	public boolean studentRegistration(Student_User student) {
		try {
			studentRegistrationRepository.save(student);
			return true;
			}catch (Exception e) {
				return false;
			}
	}

}
