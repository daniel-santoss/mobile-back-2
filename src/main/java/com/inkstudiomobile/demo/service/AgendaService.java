package com.inkstudiomobile.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inkstudiomobile.demo.model.Agenda;
import com.inkstudiomobile.demo.repository.AgendaRepository;

@Service
public class AgendaService {
	
	@Autowired
	AgendaRepository ar;
	
	public AgendaService(AgendaRepository ar) {
		this.ar = ar;
	}
	
	public Agenda findById(long id) {
		return ar.findById(id).get();
	}

}
