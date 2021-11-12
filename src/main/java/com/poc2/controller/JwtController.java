package com.poc2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.poc2.request.JwtRequest;
import com.poc2.response.ApiResponse;
import com.poc2.security.UserAuthServiceImpl;
import com.poc2.util.JwtUtil;

@RestController
public class JwtController {

	@Autowired
	UserAuthServiceImpl authServiceImpl;

	@Autowired
	JwtUtil jwtUtil;

	@Autowired
	AuthenticationManager authenticationManager;

	@PostMapping("/token")
	public ApiResponse generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
		ApiResponse response=new ApiResponse();
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
		} catch (Exception e) {
			response.getResult().put("Error", "Bad Credential");
			response.setSuccess(false);
			return response;
		}
		UserDetails userDetails=this.authServiceImpl.loadUserByUsername(jwtRequest.getUsername());
		String token=this.jwtUtil.generateToken(userDetails);
		response.getResult().put("token", token);
		response.setSuccess(true);
		return response;
	}

}
