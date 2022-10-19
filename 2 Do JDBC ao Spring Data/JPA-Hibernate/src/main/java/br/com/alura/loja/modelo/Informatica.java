package br.com.alura.loja.modelo;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "produtos_informatica")
public class Informatica extends Produto {

	@Column(nullable = false)
	private String marca;

	@Column(nullable = false)
	private String modelo;

	public Informatica() {

	}

	public Informatica(String nome, String descricao, BigDecimal preco, String marca, String modelo, Categoria categoria) {
		super(nome, descricao, preco, categoria);
		this.marca = marca;
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

}
