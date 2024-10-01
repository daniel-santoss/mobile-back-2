package com.inkstudiomobile.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.inkstudiomobile.demo.model.Orcamento;


public interface OrcamentoRepository extends JpaRepository<Orcamento, Long>{
	
	// Método para buscar orçamentos pelo ID do funcionário
		@Query(value = "select * from orcamento where id_funcionario = :id_funcionario", nativeQuery = true)
	    Iterable<Orcamento> findByIdFuncionario(Long id_funcionario);
		
		@Query(value = "select * from orcamento where id_usuario = :id_usuario", nativeQuery = true)
	    Iterable<Orcamento> findByIdUsuariorio(Long id_usuario);

}
