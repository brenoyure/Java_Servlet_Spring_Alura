package br.com.alura.jdbc.modelo;

public class Produto {

	private Integer id;
	private String nome;
	private String descricao;

	public Produto(String nome, String descricao) {
		if(nome == "" || nome == null)
			throw new IllegalArgumentException("Campo Nome do Produto não pode ficar vazio.");
		
		this.nome = nome;
		this.descricao = descricao;
	}
	
	public Produto(Integer id, String nome, String descricao) {
		if (id == null || id < 1)
			throw new IllegalArgumentException("ID Inválido");
		
		if (nome == "" || nome == null)
			throw new IllegalArgumentException("Campo Nome do Produto não pode ficar vazio.");
		
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}


	public String getNome() {
		return this.nome;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return String.format("Produto ID: %d, Nome: %s, Descrição: %s", 
				this.id, this.nome, this.descricao);
	}
	
}
