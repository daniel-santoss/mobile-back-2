package com.inkstudiomobile.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inkstudiomobile.demo.model.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{

	@Query(value = "select * from funcionario where email = :email and senha = :senha", nativeQuery = true)
	public Funcionario login(String email, String senha);
	
	Optional<Funcionario> findByEmailAndSenha(String email, String senha);
	
	boolean existsByEmail(String email);
}
