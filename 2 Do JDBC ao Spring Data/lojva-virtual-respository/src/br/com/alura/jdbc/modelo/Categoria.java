package br.com.alura.jdbc.modelo;

import static java.util.Collections.unmodifiableList;

import java.util.ArrayList;
import java.util.List;

public class Categoria {

	private Integer id;
	private String nome;
	private List<Produto> produtos = new ArrayList<>();
	
	public Categoria (String nome) {
		this.nome = nome;
	}

	public Categoria (Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return String.format("Categoria: ID: %d, %s", this.id, this.nome);
	}

	public List<Produto> getProdutos() {
	    return unmodifiableList(this.produtos);
	}
	
    public void adicionar(Produto produto) {
        this.produtos.add(produto);
        
    }
	
}
