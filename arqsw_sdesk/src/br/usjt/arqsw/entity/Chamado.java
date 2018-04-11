package br.usjt.arqsw.entity;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

/**
 * 
 * @author Leandro Pinheiro de Holanda 816113762
 *
 */

public class Chamado implements Serializable{

private static final long serialVersionUID = 1L;
	
	public static final String ABERTO = "aberto";
	public static final String FECHADO = "fechado";
	
	@NotNull(message="O chamado não pode ser vaziao")
	@Min(value=1, message="O chamado não pode ser vazio")
	private int numero;
	
	@NotNull
	@Size(min=5, max=100, message="A descricao deve ter entre 5 e 100 caracteres.")
	private String descricao;
	
	@NotNull
	@Size(min=5, max=10, message="O status dever ter entre 5 e 10 caracteres.")
	private String status;
	
	@Past
	private Date dataAbertura;
	
	@Past
	private Date dataFechamento;
	
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
