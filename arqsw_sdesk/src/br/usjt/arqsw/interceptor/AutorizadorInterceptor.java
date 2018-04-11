package br.usjt.arqsw.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author Leandro Pinheiro de Holanda 816113762
 *
 */

public class AutorizadorInterceptor {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object controller)
			throws Exception {
		if (request.getRequestURI().endsWith("login") || request.getRequestURI().endsWith("fazer_login")
				|| request.getRequestURI().contains("css") || request.getRequestURI().contains("js")
				|| request.getRequestURI().contains("img")) {
			return true;
		}
		if (request.getSession().getAttribute("usuarioLogado") != null) {
			return true;
		}
		response.sendRedirect("login");
		return false;
	}
}
