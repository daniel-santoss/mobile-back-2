package com.inkstudiomobile.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "Usuario")
public class Usuario {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	
	private Long id;
	private String cpf;
	private String email;
	private String senha;
	private String nome;
	private String telefone;
	private String nascimento;
	private String statusUsuario;
	
	public String getStatusUsuario() {
		return statusUsuario;
	}
	public void setStatusUsuario(String statusUsuario) {
		this.statusUsuario = statusUsuario;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getNascimento() {
		return nascimento;
	}
	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}
}
