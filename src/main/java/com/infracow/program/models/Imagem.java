package com.infracow.program.models;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Imagem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String nome;
	private String metadados;
	private Date data_captura;
	private String extensao;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMetadados() {
		return metadados;
	}

	public void setMetadados(String metadados) {
		this.metadados = metadados;
	}

	public Date getData_captura() {
		return data_captura;
	}

	public void setData_captura(Date data_captura) {
		this.data_captura = data_captura;
	}

	public String getExtensao() {
		return extensao;
	}

	public void setExtensao(String extensao) {
		this.extensao = extensao;
	}
	
	

}
