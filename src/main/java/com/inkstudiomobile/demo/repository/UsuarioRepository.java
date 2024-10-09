package com.inkstudiomobile.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inkstudiomobile.demo.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	@Query(value = "select * from usuario where email = :email and senha = :senha", nativeQuery = true)
	public Usuario login(String email, String senha);
	
	Optional<Usuario> findByEmailAndSenha(String email, String senha);
	
	boolean existsByEmail(String email);
	
	public Usuario findByEmail(String email);

}