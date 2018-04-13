package br.usjt.arqsw.dao;

import static java.sql.Date.valueOf;
import static java.time.LocalDate.now;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

	private Connection conn;
	
	@Autowired
	public ChamadoDAO(DataSource dataSource) throws IOException{
		try {
			this.conn = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int criarChamado(Chamado chamado) throws IOException {
		String query = "insert into chamado(descricao, status, dt_abertura, id_fila) values (?, ?, ?, ?)";
		int numeroChamado = -1;
		try {
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, chamado.getDescricao());
			pst.setString(2, Chamado.ABERTO);
			pst.setDate(3, valueOf(now()));
			pst.setInt(4, chamado.getFila().getId());
			pst.execute();
			query = "select id_chamado from chamado order by id_chamado desc limit 1";
			pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				numeroChamado = rs.getInt("id_chamado");
			}
		} catch (SQLException e) {
			throw new IOException(e);
		}
		return numeroChamado;
	}

	public ArrayList<Chamado> listarChamados(Fila fila) throws IOException{
		ArrayList<Chamado> lista = new ArrayList<>();
		String query = "select c.id_chamado, c.descricao, c.dt_abertura, f.nm_fila "+
				"from chamado c, fila f where c.id_fila = f.id_fila and c.id_fila=?";
		
		try(PreparedStatement pst = conn.prepareStatement(query);){
			pst.setInt(1, fila.getId());
			
			try(ResultSet rs = pst.executeQuery();){
				while(rs.next()){
					Chamado chamado = new Chamado();
					chamado.setNumero(rs.getInt("id_chamado"));
					chamado.setDescricao(rs.getString("descricao"));
					chamado.setDataAbertura(rs.getDate("dt_abertura"));
					fila.setNome(rs.getString("nm_fila"));
					chamado.setFila(fila);
					lista.add(chamado);
				}
			} catch(SQLException e){
				e.printStackTrace();
				throw new IOException(e);
			}
		} catch(SQLException e){
			e.printStackTrace();
			throw new IOException(e);
		}
		return lista;
	}

}
