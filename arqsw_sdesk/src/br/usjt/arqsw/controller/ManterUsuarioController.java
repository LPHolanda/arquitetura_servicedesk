package br.usjt.arqsw.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.usjt.arqsw.entity.Usuario;
import br.usjt.arqsw.service.UsuarioService;

/**
 * 
 * @author Leandro Pinheiro de Holanda 816113762
 *
 */

@Controller
@Transactional
public class ManterUsuarioController {

	@Autowired
	private UsuarioService loginService;
	
	@RequestMapping("/fazer_login")
	public String login(@Valid Usuario login, BindingResult result, HttpSession session) {
		try {
			if (result.hasFieldErrors()) {
				System.out.println("Deu erro " + result.toString());
				return "Login";
			}
			boolean isValidLogin = loginService.fazerLogin(login);
			session.setAttribute("usuarioLogado", isValidLogin);
			if (!isValidLogin) {
				return "Login";
			}
			return "index";

		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}

	@RequestMapping("/login")
	public String login() {
		return "Login";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "Login";
	}
}
