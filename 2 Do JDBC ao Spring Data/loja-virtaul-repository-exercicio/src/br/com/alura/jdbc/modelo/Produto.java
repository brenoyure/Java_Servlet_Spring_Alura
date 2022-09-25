package br.com.alura.jdbc.modelo;


/**
 * Classe para representar a tabela Produto da database.
 * @author byuri
 *
 */
public class Produto {

	private Integer id;
	private String nome;
	private String descricao;

	/**
	 * Construtor Utilizado para Cadastro de Novo Produto, Repare que não passamos a
	 * ID, visto que ela é a primary key na database.
	 * 
	 * @param nome
	 * @param descricao
	 */
	public Produto(String nome, String descricao) {
		if (nomeEmBranco(nome))
			throw new IllegalArgumentException("Nome do Produto não pode ficar em branco ou nulo.");

		this.nome = nome;
		this.descricao = descricao;

	}

	/**
	 * Construtor que será utilizado para criar um Produto a partir de um retorno da
	 * database.
	 * 
	 * @param id
	 * @param nome
	 * @param descricao
	 */
	public Produto(Integer id, String nome, String descricao) {
		if (idInvalido(id))
			throw new IllegalArgumentException("ID inválida.");

		if (nomeEmBranco(nome))
			throw new IllegalArgumentException("Nome do Produto não pode ficar em branco ou nulo.");

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

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		
		if (this.getId() == null) {
			return String.format("Produto Nome: %s, Descrição: %s", this.id, this.nome, this.descricao);
		}
		
		return String.format("Produto ID: %d, Nome: %s, Descrição: %s", this.id, this.nome, this.descricao);
	}

	/*
	 * Métodos Auxiliares
	 */
	private boolean nomeEmBranco(String nome) {
		return nome == "" || nome == null;
	}

	private boolean idInvalido(Integer id) {
		return (id == null || id < 1);
	}

}
