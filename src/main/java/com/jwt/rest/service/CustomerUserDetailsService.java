package com.jwt.rest.service;

import java.util.ArrayList;
import org.apache.tomcat.jni.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class CustomerUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		if(userName.equals("user")) {
       return new org.springframework.security.core.userdetails.User("User","kapil",new ArrayList<>());
		}else {
			throw new UsernameNotFoundException("User not found");
		}
		
		
	}
}
