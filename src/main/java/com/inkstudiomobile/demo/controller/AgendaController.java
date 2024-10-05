package com.inkstudiomobile.demo.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.inkstudiomobile.demo.model.Agenda;
import com.inkstudiomobile.demo.repository.AgendaRepository;

@Controller
@RequestMapping("/agenda")
public class AgendaController {
	
	@Autowired
	AgendaRepository ar;
	
	@GetMapping("/usuario/{id}")
	public ModelAndView cadastro(Model model) {
		
		ModelAndView mv = new ModelAndView("agenda-usuario");
		Iterable<Agenda> agenda = ar.findAll();
		
		List<Agenda> agendaAtiva = StreamSupport.stream(agenda.spliterator(), false)
				.filter(agend -> "ATIVO".equals(agend.getStatusAgenda())).collect(Collectors.toList());

		mv.addObject("agenda", agendaAtiva);
		
		return mv;
	}

}
