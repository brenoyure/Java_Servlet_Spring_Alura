package br.com.alura.gerenciador.servlet;

import java.util.Date;

public class Empresa {

	private Integer id;
	private String nome;
	private Date dataDeAbertura = new Date();
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setDataDeAbertura(Date dataDeAbertura) {
		this.dataDeAbertura = dataDeAbertura;
	}
	
	public Date getDataDeAbertura() {
		return this.dataDeAbertura;
	}
	
	@Override
	public String toString() {
		return this.nome;
	}
	
}
