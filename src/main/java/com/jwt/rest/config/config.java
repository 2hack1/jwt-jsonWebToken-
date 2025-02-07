package com.jwt.rest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.event.PublicInvocationEvent;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.AutoPopulatingList;

import com.jwt.rest.service.CustomerUserDetailsService;

@Configuration
@EnableWebSecurity
public class config extends WebSecurityConfigurerAdapter {
@Autowired
private	CustomerUserDetailsService cos;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
		       .csrf()
		       .disable()
		       .cors()
		       .disable()
		       .authorizeRequests()
		       .antMatchers("/token").permitAll()
		       .anyRequest().authenticated()
		       .and()
		       .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		       
		    
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(cos);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();}
				
		
@Bean
	
	public AuthenticationManager authenticationManagerBean() throws Exception {
				return super.authenticationManagerBean();
	}
	
}

	

