package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/secured")
	public Object secured(Authentication authentication){
		return authentication.getPrincipal();
	}

	@GetMapping("/secured-admin")
	@PreAuthorize("hasRole('ROLE_admin')")
	public String securedAdmin(){
		return "Only admin can see this";
	}
	
	@GetMapping("/public")
	public String pub(){
		
		return "This is public endpoint";
	}
}
