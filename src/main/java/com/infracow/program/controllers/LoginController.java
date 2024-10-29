package com.infracow.program.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.infracow.program.models.Usuario;
import com.infracow.program.services.UserService;


@Controller
@RequestMapping("/user")
public class LoginController {

	@Autowired
	private UserService service;
	
	@GetMapping("")
	public String loginPage() {
		return "userLogin";
	}	
	@GetMapping("/cadastroUser")
	public String cadastroPage(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "userCadastro";
	}
	@PostMapping("/addUser")
	public String addUser(@Validated Usuario usuario, BindingResult result, Model model) {				
        if (result.hasErrors()) {
        	return "userCadastro";
        }
       
		service.addUser(usuario);
		return "redirect:/user";
	}
}
