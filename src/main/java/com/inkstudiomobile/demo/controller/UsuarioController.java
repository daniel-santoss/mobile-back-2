package com.inkstudiomobile.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inkstudiomobile.demo.model.Usuario;
import com.inkstudiomobile.demo.repository.UsuarioRepository;
import com.inkstudiomobile.demo.service.UsuarioService;

@RestController
@CrossOrigin
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/login")
    public Usuario login(@RequestParam String email, @RequestParam String senha) {
        return usuarioService.findByEmailAndSenha(email, senha).get();
    }
    
    @GetMapping("/{id}")
    public Usuario getUsuario(@PathVariable Long id) {
        return usuarioService.findById(id).get();
    }
}
