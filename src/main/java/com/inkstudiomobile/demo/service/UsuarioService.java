package com.inkstudiomobile.demo.service;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inkstudiomobile.demo.model.Usuario;
import com.inkstudiomobile.demo.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository ur;

	public UsuarioService(UsuarioRepository ur) {
		this.ur = ur;
	}

    private UsuarioRepository usuarioRepository;

    public Optional<Usuario> findByEmailSenha(String email, String senha) {
        return usuarioRepository.findByEmailSenha(email, senha);
    }

    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }
    
    public Usuario login(String email, String senha) {
        // Verifica se o e-mail existe no banco de dados
        if (!usuarioRepository.existsByEmail(email)) {
            throw new NoSuchElementException("E-mail não cadastrado.");
        }

        // Tenta fazer login com e-mail e senha
        Optional<Usuario> usuarioOpt = usuarioRepository.findByEmailSenha(email, senha);
        if (usuarioOpt.isEmpty()) {
            throw new IllegalArgumentException("Senha inválida.");
        }

        // Retorna o usuário autenticado
        return usuarioOpt.get();
    
    
    }
}
