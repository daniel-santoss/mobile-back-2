package com.inkstudiomobile.demo.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.inkstudiomobile.demo.model.Funcionario;
import com.inkstudiomobile.demo.model.Orcamento;
import com.inkstudiomobile.demo.model.Usuario;
import com.inkstudiomobile.demo.repository.FuncionarioRepository;
import com.inkstudiomobile.demo.repository.OrcamentoRepository;
import com.inkstudiomobile.demo.service.FuncionarioService;
import com.inkstudiomobile.demo.service.OrcamentoService;
import org.springframework.ui.Model;

import jakarta.servlet.http.HttpSession;

public class FuncionarioController {
	
	
	@Autowired
	FuncionarioRepository fr;
	@Autowired
	FuncionarioService fs;

	@Autowired
	OrcamentoRepository or;
	@Autowired
	OrcamentoService os;
	
	
	// Login do funcionario
		@GetMapping("/login")
		public String login() {
			return "login";
		}

		@PostMapping("/login")
		public Funcionario efetuarLogin(Model model, Funcionario funcionario, HttpSession session) {
			Funcionario funcSession = this.fr.login(funcionario.getEmail(), funcionario.getSenha());

			if (funcSession != null) {
				// Verifica o status do usuário
				if ("INATIVO".equals(funcSession.getStatusUsuario())) {
					model.addAttribute("erro", "Essa conta foi deletada!");
					return null;
				}

				// Se o status for ativo, inicia a sessão do usuário
				session.setAttribute("funcSession", funcSession);
				model.addAttribute("funcionario", funcSession);
				return funcSession;
			}
			model.addAttribute("erro", "usuario ou senha inválidos");
			return null;
		}
		
		
		@GetMapping("/minha-agenda")
		public ModelAndView listarAgenda(HttpSession session) {
			Funcionario funcionarioLogado = (Funcionario) session.getAttribute("userSession");

			if (funcionarioLogado == null) {
				return new ModelAndView("redirect:/funcioarios/login");
			}

			Long idFuncionarioLogado = funcionarioLogado.getId();

			Iterable<Orcamento> orcamento = or.findByIdFuncionario(idFuncionarioLogado);

			List<Orcamento> orcamentos = StreamSupport.stream(orcamento.spliterator(), false)
					.filter(f -> "ATIVO".equals(f.getStatusOrcamento())).collect(Collectors.toList());

			// Cria a ModelAndView e passa os orçamentos filtrados
			ModelAndView mv = new ModelAndView("agenda-funcionario");
			mv.addObject("orcamento", orcamento);
			mv.addObject("orcamento", orcamentos);

			return mv;
		}

		@GetMapping("/logoff")
		public String efetuarLogoff(HttpSession session) {

			session.invalidate();

			return ("");
		}

}
