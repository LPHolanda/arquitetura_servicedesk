package br.usjt.arqsw.entity;

import java.io.Serializable;

import javax.persistence.Entity;

import com.sun.istack.internal.NotNull;

/**
 * 
 * @author Leandro Pinheiro de Holanda 816113762 
 *
 */

@Entity
public class Login implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@NotNull
	private String usuario;
	
	@NotNull
	private String senha;
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	@Override
	public String toString() {
		return "Login [usuario=" + usuario + ", senha=" + senha + "]";
	}
}