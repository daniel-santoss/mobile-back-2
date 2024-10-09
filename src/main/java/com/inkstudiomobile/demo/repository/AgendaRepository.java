package com.inkstudiomobile.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inkstudiomobile.demo.model.Agenda;
import com.inkstudiomobile.demo.model.Usuario;

public interface AgendaRepository  extends JpaRepository<Agenda, Long>{
	
	List<Agenda>findAllByUsuarioAndStatusAgenda(Usuario usuario, String statusAgenda);

}
