package com.inkstudiomobile.demo.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.inkstudiomobile.demo.model.Orcamento;
import com.inkstudiomobile.demo.model.Usuario;
import com.inkstudiomobile.demo.repository.OrcamentoRepository;
import com.inkstudiomobile.demo.repository.UsuarioRepository;
import com.inkstudiomobile.demo.service.UsuarioService;

import jakarta.servlet.http.HttpSession;

@RestController
@CrossOrigin
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	UsuarioService usuarioService;

	@Autowired
	OrcamentoRepository or;

	@GetMapping("/{id}")
	public Usuario getUsuario(@PathVariable Long id) {
		return usuarioService.findById(id).get();
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@PostMapping("/login")
	public String efetuarLogin(Model model, Usuario usuario, HttpSession session) {
		Usuario userSession = this.usuarioRepository.login(usuario.getEmail(), usuario.getSenha());

		if (userSession != null) {
			// Verifica o status do usuário
			if ("INATIVO".equals(userSession.getStatusUsuario())) {
				model.addAttribute("erro", "Essa conta foi deletada!");
				return "";
			}

			// Se o status for ativo, inicia a sessão do usuário
			session.setAttribute("userSession", userSession);
			model.addAttribute("usuario", userSession);
			return "activity_agenda";
		}

		model.addAttribute("erro", "usuario ou senha inválidos!");
		return "login";

	}

	@GetMapping("/minha-agenda")
	public ModelAndView listarAgenda(HttpSession session) {
		Usuario usuarioLogado = (Usuario) session.getAttribute("userSession");

		if (usuarioLogado == null) {
			return new ModelAndView("redirect:/usuarios/login");
		}

		Long idUsuarioLogado = usuarioLogado.getId();

		Iterable<Orcamento> orcamento = or.findByIdUsuario(idUsuarioLogado);

		List<Orcamento> orcamentos = StreamSupport.stream(orcamento.spliterator(), false)
				.filter(f -> "ATIVO".equals(f.getStatusOrcamento())).collect(Collectors.toList());

		// Cria a ModelAndView e passa os orçamentos filtrados
		ModelAndView mv = new ModelAndView("agenda-usuario");
		mv.addObject("orcamento", orcamento);
		mv.addObject("orcamento", orcamentos);

		return mv;
	}

}
