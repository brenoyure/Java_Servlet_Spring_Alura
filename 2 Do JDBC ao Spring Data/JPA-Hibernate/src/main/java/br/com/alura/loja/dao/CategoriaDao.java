package br.com.alura.loja.dao;

import br.com.alura.loja.modelo.Categoria;
import jakarta.persistence.EntityManager;

public class CategoriaDao {

	private EntityManager entityManager;

	public CategoriaDao(EntityManager em) {
		this.entityManager = em;
	}
	
	public void cadastrar(Categoria categoria) {
		this.entityManager.persist(categoria);
	}

}
