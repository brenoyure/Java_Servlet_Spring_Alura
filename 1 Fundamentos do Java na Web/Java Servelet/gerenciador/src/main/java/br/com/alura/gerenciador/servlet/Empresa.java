package br.com.alura.gerenciador.servlet;

public class Empresa {

	private Integer id;
	private String nome;

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

	public String toString() {
		return this.nome;
	}
	
}
