package com.inkstudiomobile.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inkstudiomobile.demo.model.Funcionario;
import com.inkstudiomobile.demo.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
	
	@Autowired
	FuncionarioRepository fr;

	public FuncionarioService(FuncionarioRepository fr) {
		this.fr = fr;
	}
	
	public Funcionario findById(long id) {
		return fr.findById(id).get();
	}

	public boolean existsById(Long id) {
		return fr.existsById(id);
	}
	
	
	
}
