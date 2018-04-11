package br.usjt.arqsw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.usjt.arqsw.dao.LoginDAO;

/**
 * 
 * @author Leandro Pinheiro de Holanda 816113762
 *
 */

@Repository
public class LoginService {
	
	@Autowired
	private LoginDAO dao;
}
