package com.infracow.program.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infracow.program.models.Imagem;
import com.infracow.program.models.Usuario;
import com.infracow.program.repositories.ImagemRepository;

@Service
public class ImagemService {

	@Autowired
	private ImagemRepository repository;
	
	public Imagem addImagem(Imagem obj) {
		return repository.save(obj);
	}
}
