package com.infracow.program.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ImageController {

	@GetMapping("/cadastro")
	public String cadatro() {
		return "index";
	}
	
	
}
