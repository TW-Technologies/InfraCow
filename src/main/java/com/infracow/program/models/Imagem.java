package com.infracow.program.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Imagem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int[][] mapaDeCalor;
	private String nome;
	private String localRegistro;
	private String extensao;
	private String metadados;
	private LocalDateTime dataCaptura;
	
	private String informacoesAdicionaisAnimal;
	
	private String resultadosAnalise;
	
	public Imagem() {		
	}
	

	public Imagem(Long id, int[][] mapaDeCalor, String nome, String localRegistro, String extensao, String metadados,
			LocalDateTime dataCaptura, String informacoesAdicionaisAnimal, String resultadosAnalise) {
		this.id = id;
		this.mapaDeCalor = mapaDeCalor;
		this.nome = nome;
		this.localRegistro = localRegistro;
		this.extensao = extensao;
		this.metadados = metadados;
		this.dataCaptura = dataCaptura;
		this.informacoesAdicionaisAnimal = informacoesAdicionaisAnimal;
		this.resultadosAnalise = resultadosAnalise;
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


	public String getLocalRegistro() {
		return localRegistro;
	}


	public void setLocalRegistro(String localRegistro) {
		this.localRegistro = localRegistro;
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


	public String getResultadosAnalise() {
		return resultadosAnalise;
	}


	public void setResultadosAnalise(String resultadosAnalise) {
		this.resultadosAnalise = resultadosAnalise;
	}

	


}
