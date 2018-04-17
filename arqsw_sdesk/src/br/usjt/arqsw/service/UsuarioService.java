package br.usjt.arqsw.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.arqsw.dao.UsuarioDAO;
import br.usjt.arqsw.entity.Usuario;

/**
 * 
 * @author Leandro Pinheiro de Holanda 816113762
 *
 */

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioDAO dao;
	
	public boolean fazerLogin(Usuario login) throws IOException{
		return dao.fazerLogin(login);
	}
}
