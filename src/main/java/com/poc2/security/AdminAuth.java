package com.poc2.security;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.poc2.entity.Admin_User;
import com.poc2.entity.Student;

public class AdminAuth implements UserDetails{
	
	Admin_User admin;

	public AdminAuth(Admin_User admin) {
		this.admin = admin;
	}

	public Admin_User getAdmin() {
		return admin;
	}

	public void setAdmin(Admin_User admin) {
		this.admin = admin;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority simpleGrantedAuthority = null;
		if (admin != null) {
			simpleGrantedAuthority = new SimpleGrantedAuthority("admin");
		}
		return Arrays.asList(simpleGrantedAuthority);
	}

	@Override
	public String getPassword() {
		
		return admin.getPassword();
	}

	@Override
	public String getUsername() {
		
		return admin.getEmail();
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
		result = prime * result + ((admin == null) ? 0 : admin.hashCode());
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
		AdminAuth other = (AdminAuth) obj;
		if (admin == null) {
			if (other.admin != null)
				return false;
		} else if (!admin.equals(other.admin))
			return false;
		return true;
	}

	

}
