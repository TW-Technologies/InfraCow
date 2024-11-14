package com.infracow.program.models;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "analises")
public class Analise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date dataAnalise;
    private String resultadosAnalise;

    @ManyToOne
    @JoinColumn(name = "id_imagem")
    private Imagem imagem;

    public Analise() {

    }

    public Analise(Long id, Date dataAnalise, String resultadosAnalise, Imagem imagem) {
        this.id = id;
        this.dataAnalise = dataAnalise;
        this.resultadosAnalise = resultadosAnalise;
        this.imagem = imagem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataAnalise() {
        return dataAnalise;
    }

    public void setDataAnalise(Date dataAnalise) {
        this.dataAnalise = dataAnalise;
    }

    public String getResultadosAnalise() {
        return resultadosAnalise;
    }

    public void setResultadosAnalise(String resultadosAnalise) {
        this.resultadosAnalise = resultadosAnalise;
    }

    public Imagem getImagem() {
        return imagem;
    }

    public void setImagem(Imagem imagem) {
        this.imagem = imagem;
    }
}
