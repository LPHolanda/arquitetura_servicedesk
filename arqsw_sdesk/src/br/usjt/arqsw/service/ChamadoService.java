package br.usjt.arqsw.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import br.usjt.arqsw.dao.ChamadoDAO;
import br.usjt.arqsw.entity.Chamado;
import br.usjt.arqsw.entity.Fila;

/**
 * 
 * @author Leandro Pinheiro de Holanda 816113762
 *
 */

public class ChamadoService {
	
	private ChamadoDAO dao;
	
	public ChamadoService() {
		dao = new ChamadoDAO();
	}
	
	public int criarChamado(Chamado chamado) {
		chamado.setStatus(chamado.ABERTO);
		chamado.setDataAbertura(new Date());
		chamado.setDataFechamento(new Date());
		return dao.criarChamado(chamado);
	}
	
	public ArrayList<Chamado> listarChamados(Fila fila) throws IOException{
		return dao.listarChamados(fila);
	}
}
