package com.infracow.program.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.infracow.program.services.UserService;


@Controller
public class LoginController {

	@Autowired
	UserService service;
	
	@GetMapping("/")
	public String loginPage() {
		return "login";
	}
	
	@PostMapping("/newUsuario")
	public void newUser() {
		return service.insertUser();
	}
	
	
	
	
}
