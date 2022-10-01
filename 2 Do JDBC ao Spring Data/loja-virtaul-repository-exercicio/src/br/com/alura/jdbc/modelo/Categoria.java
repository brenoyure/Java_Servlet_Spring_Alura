package br.com.alura.jdbc.modelo;

import static java.util.Collections.unmodifiableList;

import java.util.ArrayList;
import java.util.List;

public class Categoria {

	private Integer id;
	private String nome;
	private List<Produto> produtos;

	public Categoria(Integer id, String nome) {

		if (id == null || id < 1 || nome == null || nome == "")
			throw new IllegalArgumentException();

		this.id = id;
		this.nome = nome;
		this.produtos = new ArrayList<>();
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void adiciona(Produto produto) {

		if (produto == null)
			throw new NullPointerException("Null Reference");

		this.produtos.add(produto);

	}

	public List<Produto> getProdutos() {
		return unmodifiableList(produtos);
	}

	@Override
	public String toString() {
		return String.format("Categoria: ID: %d, %s", id, nome);
	}

};