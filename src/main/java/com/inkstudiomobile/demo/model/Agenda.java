package com.inkstudiomobile.demo.model;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="agenda")

public class Agenda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Auto incremento do SQL Server
	@Column(name = "id")
	
	private Long id;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate data;
	private LocalTime horas;
	private String servico;
	@ManyToOne
	@JoinColumn(name = "Id_funcionario")
	private Funcionario funcionario;
	@ManyToOne
	@JoinColumn(name = "Id_usuario")
	private Usuario usuario;
	@ManyToOne
	@JoinColumn(name = "Id_Orcamento")
	private Orcamento orcamento;
	private String statusAgenda;
	
	
	public String getStatusAgenda() {
		return statusAgenda;
	}
	public void setStatusAgenda(String statusAgenda) {
		this.statusAgenda = statusAgenda;
	}
	
	public LocalTime getHoras() {
		return horas;
	}
	public void setHoras(LocalTime horas) {
		this.horas = horas;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public String getServico() {
		return servico;
	}
	public void setServico(String servico) {
		this.servico = servico;
	}
	public Funcionario getProfissional() {
		return funcionario;
	}
	public void setProfissional(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	

}
