package com.ex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class InlineEditApplication {
	
	
	 @GetMapping("/records") 
	 public String view() {
		 return "sorting"; 
		 }
	 
	 @GetMapping("/signin")
		public String login() {
			System.out.println("Sign in page coming.....");
			return "login";
		}
		
		@GetMapping("/userlogout")
		public String error() {
			System.out.println("logout page coming.....");
			return "logout";
		}
	

	public static void main(String[] args) {
		SpringApplication.run(InlineEditApplication.class, args);
	}

}
