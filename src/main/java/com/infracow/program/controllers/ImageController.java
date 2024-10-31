package com.infracow.program.controllers;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDateTime;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.infracow.program.models.Imagem;
import com.infracow.program.models.dto.ImagemDTO;
import com.infracow.program.services.ImagemService;

@Controller
@RequestMapping("/imagem")
public class ImageController {

	@Autowired
	private ImagemService service;

	@GetMapping("/cadastroImagem")
	public String imagemInsert() {
		return "imagemCadastro";
	}

	@PostMapping("/addImagem")
	public String addImagem(@ModelAttribute ImagemDTO imagemDTO) throws IOException {

		MultipartFile imageFile = imagemDTO.getArquivo(); // Captura o arquivo de imagem do DTO
		String comentarioExtra = imagemDTO.getComentarioExtra();

		if (imageFile == null) {
			return "redirect:/imagem/cadastroImagem";
		}

		if (!imageFile.isEmpty()) {

			String fileName = imageFile.getOriginalFilename();
			String contentType = imageFile.getContentType();
			String extensao = imageFile.getOriginalFilename()
					.substring(imageFile.getOriginalFilename().lastIndexOf(".") + 1);
			long fileSize = imageFile.getSize();
			LocalDateTime dataCaptura = LocalDateTime.now();
			// Metadados - Width and Height
			BufferedImage bfImage = ImageIO.read(imageFile.getInputStream());
			int largura = 0;
			int altura = 0;
			if (bfImage != null) {
				largura = bfImage.getWidth();
				altura = bfImage.getHeight();
			}

			System.out.println();

			Imagem imagem = new Imagem();
			imagem.setNome(fileName);
			imagem.setExtensao(extensao);
			imagem.setDataCaptura(dataCaptura);
			imagem.setInformacoesAdicionaisAnimal(comentarioExtra);
			imagem.setMetadados("width: " + String.valueOf(largura) + "heigh: " + String.valueOf(altura));

			service.addImagem(imagem);
		} else {
			return "redirect:/imagem/cadastroImagem";
		}
		return "redirect:/imagem/cadastroImagem";

	}
}
