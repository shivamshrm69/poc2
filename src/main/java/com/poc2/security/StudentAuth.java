package com.poc2.security;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.poc2.entity.Student_User;

public class StudentAuth implements UserDetails{
	
Student_User studentUser;


	public StudentAuth(Student_User studentUser) {
	this.studentUser = studentUser;
}

	public Student_User getStudentUser() {
	return studentUser;
}

public void setStudentUser(Student_User studentUser) {
	this.studentUser = studentUser;
}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority simpleGrantedAuthority = null;
		if (studentUser != null) {
			simpleGrantedAuthority = new SimpleGrantedAuthority("student");
		}
		return Arrays.asList(simpleGrantedAuthority);
	}

	@Override
	public String getPassword() {
		
		return studentUser.getPassword();
	}

	@Override
	public String getUsername() {
		
		return studentUser.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((studentUser == null) ? 0 : studentUser.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentAuth other = (StudentAuth) obj;
		if (studentUser == null) {
			if (other.studentUser != null)
				return false;
		} else if (!studentUser.equals(other.studentUser))
			return false;
		return true;
	}

	
}
