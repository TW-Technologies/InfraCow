package com.infracow.program.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	
	@Column(name = "email")
	private String email;
	private String senha;

	public Usuario() {
	}

	public Usuario(Long id, String nome, String email, String senha) {
		super();
		this.id = id;
		this.nome = nome;
				
		this.email = email;
		this.senha = senha;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getemail() {
		return email;
	}

	public void setemail(String email) {
		this.email = email;
	}

	public String getsenha() {
		return senha;
	}

	public void setsenha(String senha) {
		this.senha = senha;
	}

}
