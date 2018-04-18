package br.usjt.arqsw.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.arqsw.dao.ChamadoDAO;
import br.usjt.arqsw.entity.Chamado;
import br.usjt.arqsw.entity.Fila;

/**
 * 
 * @author Leandro Pinheiro de Holanda 816113762
 *
 */

@Service
public class ChamadoService {
	
	@Autowired
	private ChamadoDAO dao;
	
	public int criarChamado(Chamado chamado) throws IOException {
		return dao.criarChamado(chamado);
	}
	
	public List<Chamado> listarChamados(Fila fila) throws IOException{
		return dao.listarChamados(fila);
	}
	
	public List<Chamado> listarChamados() throws IOException{
		return dao.listarChamados();
	}
	
	public List<Chamado> listarChamadosAbertos(Fila fila) throws IOException {
		return dao.listarChamadosAbertos(fila);
	}
	
	public void fecharChamados(String[] chamados) throws IOException{
		dao.fecharChamado(chamados);
	}
}
