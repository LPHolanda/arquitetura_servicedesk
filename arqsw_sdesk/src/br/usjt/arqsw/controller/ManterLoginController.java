package br.usjt.arqsw.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.usjt.arqsw.entity.Login;
import br.usjt.arqsw.service.LoginService;

/**
 * 
 * @author Leandro Pinheiro de Holanda 816113762
 *
 */

@Controller
public class ManterLoginController {

	@Autowired
	private LoginService loginService;
	
	@RequestMapping("/fazer_login")
	public String login(@Valid Login login, BindingResult result, HttpSession session) {
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
}
