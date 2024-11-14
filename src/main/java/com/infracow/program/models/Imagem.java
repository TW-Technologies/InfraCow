package com.infracow.program.models;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "imagens")
public class Imagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String metadados;
    private LocalDateTime dataCaptura;
    private String extensao;
    private String informacoesAdicionaisAnimal;
    private String localCaptura;
    private int[][] mapaDeCalor;


    @ManyToOne
    @JoinColumn(name = "id_animal")
    private Animal animal;

    @OneToMany(mappedBy = "imagem", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Analise> analises;

    public Imagem() {
    }


    public Imagem(Long id, int[][] mapaDeCalor, String nome, String localCaptura, String extensao, String metadados,
                  LocalDateTime dataCaptura, String informacoesAdicionaisAnimal) {
        this.id = id;
        this.mapaDeCalor = mapaDeCalor;
        this.nome = nome;
        this.localCaptura = localCaptura;
        this.extensao = extensao;
        this.metadados = metadados;
        this.dataCaptura = dataCaptura;
        this.informacoesAdicionaisAnimal = informacoesAdicionaisAnimal;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public int[][] getMapaDeCalor() {
        return mapaDeCalor;
    }


    public void setMapaDeCalor(int[][] mapaDeCalor) {
        this.mapaDeCalor = mapaDeCalor;
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getlocalCaptura() {
        return localCaptura;
    }


    public void setlocalCaptura(String localCaptura) {
        this.localCaptura = localCaptura;
    }


    public String getExtensao() {
        return extensao;
    }


    public void setExtensao(String extensao) {
        this.extensao = extensao;
    }


    public String getMetadados() {
        return metadados;
    }


    public void setMetadados(String metadados) {
        this.metadados = metadados;
    }


    public LocalDateTime getDataCaptura() {
        return dataCaptura;
    }


    public void setDataCaptura(LocalDateTime dataCaptura) {
        this.dataCaptura = dataCaptura;
    }


    public String getInformacoesAdicionaisAnimal() {
        return informacoesAdicionaisAnimal;
    }


    public void setInformacoesAdicionaisAnimal(String informacoesAdicionaisAnimal) {
        this.informacoesAdicionaisAnimal = informacoesAdicionaisAnimal;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}
