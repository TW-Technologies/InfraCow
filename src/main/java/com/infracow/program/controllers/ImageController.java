package com.infracow.program.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/imagem")
public class ImageController {

	@GetMapping("/cadastroImagem")
	public String imagemInsert() {
		return "imagemCadastro";
	}		
	
	@PostMapping("/addImagem")
	public String addImagem() {
		return "redirect:/imagem/cadastroImagem";
	}
}
