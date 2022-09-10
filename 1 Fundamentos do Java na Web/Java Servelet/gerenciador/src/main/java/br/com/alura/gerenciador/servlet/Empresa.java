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
		if (vazioOuNulo(nome))
			throw new NullPointerException("Nome da Empresa não pode ser Nulo ou Vazio");
		if(comecaComLetraMinuscula(nome))
			throw new IllegalArgumentException("Nome da Empresa deve começar com letra maiúscula.");
		
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
	
	private boolean comecaComLetraMinuscula(String nome) {
		return nome.charAt(0) == nome.toLowerCase().charAt(0);
	}

	private boolean vazioOuNulo(String nome) {
		return (nome == "" || nome == null);
	}
	
}
