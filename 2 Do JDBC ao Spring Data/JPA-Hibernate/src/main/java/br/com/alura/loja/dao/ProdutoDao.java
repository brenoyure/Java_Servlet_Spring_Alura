package br.com.alura.loja.dao;

import br.com.alura.loja.modelo.Produto;
import jakarta.persistence.EntityManager;

public class ProdutoDao {

	private EntityManager entityManager;

	public ProdutoDao(EntityManager em) {
		this.entityManager = em;
	}
	
	public void cadastrar(Produto produto) {
		this.entityManager.persist(produto);
	}

}
