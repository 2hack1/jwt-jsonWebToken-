package com.jwt.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.rest.helper.JwtUtil;
import com.jwt.rest.model.ReqModel;
import com.jwt.rest.model.ResModel;
import com.jwt.rest.service.CustomerUserDetailsService;

@RestController
public class JwtController {
	
	@Autowired
	private AuthenticationManager  authenticationManager;
	
	@Autowired
	private JwtUtil util;
	
	@Autowired
	private CustomerUserDetailsService customer;	
	
  @RequestMapping(value = "/token",method=RequestMethod.POST)
	public ResponseEntity<?> generateToken(@RequestBody ReqModel reqModel) throws Exception{
		System.out.println(reqModel);
		try {
			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(reqModel.getUsername(), reqModel.getPassword()));
			
		} catch (UsernameNotFoundException e) {
			e.printStackTrace();
			throw new Exception("Bad credentials");
		}
		
	UserDetails userDetails=this.customer.loadUserByUsername(reqModel.getUsername());
		
   String token=this.util.generateToken(userDetails);
	
	System.out.println("JWT"+token);
	
	return ResponseEntity.ok(new ResModel(token));
	}
  
  
  
  
  
}
