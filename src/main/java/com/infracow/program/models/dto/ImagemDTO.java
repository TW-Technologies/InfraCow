package com.infracow.program.models.dto;

import org.springframework.web.multipart.MultipartFile;

public class ImagemDTO {
	private MultipartFile arquivo;
	private String comentarioExtra;

	public ImagemDTO() {
	}

	public ImagemDTO(MultipartFile arquivo, String comentarioExtra) {
		this.arquivo = arquivo;
		this.comentarioExtra = comentarioExtra;
	}

	public MultipartFile getArquivo() {
		return arquivo;
	}

	public void setArquivo(MultipartFile arquivo) {
		this.arquivo = arquivo;
	}

	public String getComentarioExtra() {
		return comentarioExtra;
	}

	public void setComentarioExtra(String comentarioExtra) {
		this.comentarioExtra = comentarioExtra;
	}

}
