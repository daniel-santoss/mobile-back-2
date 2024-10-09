package com.inkstudiomobile.demo.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.inkstudiomobile.demo.model.Agenda;
import com.inkstudiomobile.demo.repository.AgendaRepository;
import com.inkstudiomobile.demo.repository.UsuarioRepository;

@RestController
@RequestMapping("/agenda")
public class AgendaController {
	
	@Autowired
	AgendaRepository ar;
	
	@Autowired
	UsuarioRepository ur;
	
	@GetMapping("/usuario/{email}")
	public List<Agenda> visualizar(@PathVariable String email) {
		
		
		List<Agenda> agenda = ar.findAllByUsuarioAndStatusAgenda(ur.findByEmail(email), "ATIVO");
		System.out.println(agenda);
		return agenda;
	}

}
