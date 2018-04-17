package br.usjt.arqsw.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.usjt.arqsw.entity.Usuario;

/**
 * 
 * @author Leandro Pinheiro de Holanda 816113762 
 *
 */

@Repository
public class UsuarioDAO {

	private Connection conn;
	
	@Autowired
	public UsuarioDAO(DataSource dataSource) throws IOException{
		try {
			this.conn = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean fazerLogin(Usuario login) throws IOException{
		String query = "select * from usuario where usuario = ? and senha = ?";
		
		try(PreparedStatement pst = conn.prepareStatement(query)){
			pst.setString(1, login.getUsuario());
			pst.setString(2, login.getSenha());
			
			try(ResultSet rs = pst.executeQuery()){
				if(rs.next())
					return true;
				else
					return false;
			} catch(SQLException e) {
				throw new IOException();
			}
		} catch (SQLException e) {
			throw new IOException();
		}
	}
}
