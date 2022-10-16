package br.com.alura.loja.dao;

import br.com.alura.loja.modelo.Cliente;
import jakarta.persistence.EntityManager;

public class ClienteDao {

	private EntityManager em;
	
	public ClienteDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Cliente cliente) {
		this.em.persist(cliente);
	}
	
	public Cliente buscarPorId(Long id) {
		return this.em.find(Cliente.class, id);
	}
	
}
