package br.com.alura.gerenciador.servlet;

import java.util.Date;

public class Empresa {

	private Integer id;
	private String nome;
	private Date dataAbertura = new Date();

	public int getId() {
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

	public Date getDataAbertura() {
		return this.dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public String toString() {
		return this.nome;
	}

}
