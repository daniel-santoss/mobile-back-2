package com.inkstudiomobile.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inkstudiomobile.demo.model.Agenda;

public interface AgendaRepository  extends JpaRepository<Agenda, Long>{

}
