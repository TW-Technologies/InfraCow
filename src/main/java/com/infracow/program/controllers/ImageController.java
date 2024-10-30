package com.infracow.program.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/imagem")
public class ImageController {

	@GetMapping("/imageminsert")
	public String imagemInsert() {
		return "imagemCadastro";
	}		
}
