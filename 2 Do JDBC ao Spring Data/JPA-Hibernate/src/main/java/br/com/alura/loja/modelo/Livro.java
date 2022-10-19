package br.com.alura.loja.modelo;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "produtos_livros")
public class Livro extends Produto {

	@Column(nullable = false)
	private String autor;

	@Column(name = "numero_de_paginas", nullable = false)
	private Integer numeroDePaginas;

	public Livro() {

	}

	public Livro(String nome, String descricao, BigDecimal preco, String autor, Integer numeroDePaginas, Categoria categoria) {
		super(nome, descricao, preco, categoria);
		this.autor = autor;
		this.numeroDePaginas = numeroDePaginas;
	}

	public String getAutor() {
		return autor;
	}

	public Integer getNumeroDePaginas() {
		return numeroDePaginas;
	}

}
