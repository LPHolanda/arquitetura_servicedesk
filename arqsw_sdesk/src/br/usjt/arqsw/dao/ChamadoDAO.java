package br.usjt.arqsw.dao;

import static java.sql.Date.valueOf;
import static java.time.LocalDate.now;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.usjt.arqsw.entity.Chamado;
import br.usjt.arqsw.entity.Fila;

/**
 * 
 * @author Leandro Pinheiro de Holanda 816113762
 *
 */

@Repository
public class ChamadoDAO {

	@PersistenceContext
	EntityManager manager;
	
	public int criarChamado(Chamado chamado) throws IOException {
		manager.persist(chamado);
		return chamado.getNumero();
	}

	public List<Chamado> listarChamados(Fila fila) throws IOException{

		fila = manager.find(Fila.class, fila.getId());
		String jpql = "select c from Chamado c where c.fila = :fila";
		
		Query query = manager.createQuery(jpql);
		query.setParameter("fila", fila);
		
		@SuppressWarnings("unchecked")
		List<Chamado> result = query.getResultList();
		return result;
	}

}
