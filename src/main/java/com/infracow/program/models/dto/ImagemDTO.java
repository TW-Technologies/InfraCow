package com.infracow.program.models.dto;

import org.springframework.web.multipart.MultipartFile;

public class ImagemDTO {
    private MultipartFile arquivo;
    private String comentarioExtra;
    private Long idAnimal;

    public ImagemDTO() {
    }

    public ImagemDTO(MultipartFile arquivo, String comentarioExtra, Long idAnimal) {
        this.arquivo = arquivo;
        this.comentarioExtra = comentarioExtra;
        this.idAnimal = idAnimal;
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

    public Long getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(Long idAnimal) {
        this.idAnimal = idAnimal;
    }
}
