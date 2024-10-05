package com.inkstudiomobile.demo.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.inkstudiomobile.demo.repository.OrcamentoRepository;

public class OrcamentoService {
	
	@Autowired
	OrcamentoRepository or;
	
	public OrcamentoService(OrcamentoRepository or) {
		this.or = or;
	}
	


}
