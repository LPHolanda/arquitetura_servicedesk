package br.usjt.arqsw.dao;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.usjt.arqsw.entity.Usuario;

/**
 * 
 * @author Leandro Pinheiro de Holanda 816113762 
 *
 */

@Repository
public class UsuarioDAO {

	@PersistenceContext
	EntityManager manager;
	
	public String fazerLogin(Usuario login) throws IOException{
		Query query = manager.createQuery("select u from Usuario u where u.usuario = :usuario and u.senha = :senha");
		query.setParameter("usuario", login.getUsuario());
		query.setParameter("senha", login.getSenha());
		return query.getSingleResult() != null ? "Valido" : "Invalido";
	}
}
