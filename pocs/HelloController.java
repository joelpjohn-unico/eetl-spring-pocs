package org.sonusoft.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {
	
	//wish
	@RequestMapping("/wish/{name}")
	public String wish(@PathVariable String name) {
		System.out.println("Inside Hello controller wish method.");
		return "Hello "+name+" welocme to spring interceptor";
	}
	//logout
	@RequestMapping("/logout")
	public String logout() {
		System.out.println("inside the logout.");
		return "Logged out becouse of inactive";
	}

}
