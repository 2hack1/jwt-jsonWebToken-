package com.jwt.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Mycontroller {

	@RequestMapping("/chek")
	public String check() {
		
		String text="this is check";
		return text;
	}
}
