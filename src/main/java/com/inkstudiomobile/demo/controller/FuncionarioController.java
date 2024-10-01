package com.inkstudiomobile.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.inkstudiomobile.demo.model.Funcionario;
import com.inkstudiomobile.demo.repository.FuncionarioRepository;
import com.inkstudiomobile.demo.repository.OrcamentoRepository;
import com.inkstudiomobile.demo.service.FuncionarioService;
import com.inkstudiomobile.demo.service.OrcamentoService;
import org.springframework.ui.Model;

import jakarta.servlet.http.HttpSession;

public class FuncionarioController {
	
	
	@Autowired
	FuncionarioRepository funcionarRepository;
	@Autowired
	FuncionarioService funcionarioService;

	@Autowired
	OrcamentoRepository or;
	@Autowired
	OrcamentoService os;
	
	
	// Login do funcionario
		@GetMapping("/login")
		public String login() {
			return "";
		}

		@PostMapping("/login")
		public String efetuarLogin(Model model, Funcionario funcionario, HttpSession session) {
			Funcionario funcSession = this.funcionarRepository.login(funcionario.getEmail(), funcionario.getSenha());

			if (funcSession != null) {
				// Verifica o status do usuário
				if ("INATIVO".equals(funcSession.getStatusUsuario())) {
					model.addAttribute("erro", "Essa conta foi deletada!");
					return "";
				}

				// Se o status for ativo, inicia a sessão do usuário
				session.setAttribute("funcSession", funcSession);
				model.addAttribute("usuario", funcSession);
				return "pag-principal-func";
			}
			model.addAttribute("erro", "usuario ou senha inválidos");
			return "";
		}

		@GetMapping("/logoff")
		public String efetuarLogoff(HttpSession session) {

			session.invalidate();

			return ("");
		}

}
