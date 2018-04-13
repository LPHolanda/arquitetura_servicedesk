package br.usjt.arqsw.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 
 * @author Leandro Pinheiro de Holanda 816113762
 *
 */

@Entity
public class Chamado implements Serializable{

private static final long serialVersionUID = 1L;
	
	public static final String ABERTO = "aberto";
	public static final String FECHADO = "fechado";
	
	@NotNull(message="O chamado não pode ser vaziao")
	@Size(max=100)
	@Id
	@Column(name="id_chamado")
	private int numero;
	
	@NotNull
	@Size(max=45)
	private String descricao;
	
	@NotNull
	@Size(min=5, max=10, message="O status dever ter entre 5 e 10 caracteres.")
	private String status;
	
	@Column(name="dt_abertura")
	private Date dataAbertura;
	
	@Column(name="dt_fechamento")
	private Date dataFechamento;
	
	@ManyToOne
	@JoinColumn(name = "id_fila")
	private Fila fila;

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public Date getDataFechamento() {
		return dataFechamento;
	}

	public void setDataFechamento(Date dataFechamento) {
		this.dataFechamento = dataFechamento;
	}

	public Fila getFila() {
		return fila;
	}

	public void setFila(Fila fila) {
		this.fila = fila;
	}
	
	public int getTempoDias(){
		//getTime e currentTimeMillis retornam o tempo em milisegundos
		//dividir por 1000 * 60 * 60 * 24 converte para dias
		int dias;
		if(dataFechamento == null){
			//considera o momento atual para calcular o tempo aberto
			dias =  (int)(System.currentTimeMillis() - dataAbertura.getTime())/(1000 * 60 * 60 * 24);
		} else {
			//considera a data de fechamento para calcular o tempo aberto
			dias = (int)(dataFechamento.getTime() - dataAbertura.getTime())/(1000 * 60 * 60 * 24);
		}
		return dias;
	}

	@Override
	public String toString() {
		return "Chamado [numero=" + numero + ", descricao=" + descricao + ", status=" + status + ", dataAbertura="
				+ dataAbertura + ", dataFechamento=" + dataFechamento + ", fila=" + fila + "]";
	}
}
