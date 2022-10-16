package br.com.alura.loja.dao;

import java.math.BigDecimal;
import java.util.List;

import br.com.alura.loja.modelo.Pedido;
import jakarta.persistence.EntityManager;

public class PedidoDao {

	private EntityManager entityManager;

	public PedidoDao(EntityManager em) {
		this.entityManager = em;
	}

	public void cadastrar(Pedido pedido) {
		this.entityManager.persist(pedido);
	}

	public Pedido getProduto(Long id) {
		return this.entityManager.find(Pedido.class, id);
	}

	public List<Pedido> buscarTodos() {
		final String JPQL = "SELECT p FROM Pedido p";
		return this.entityManager.createQuery(JPQL, Pedido.class).getResultList();
	}

	public BigDecimal valorTotalVendido() {
		final String JPQL = "SELECT SUM(p.valorTotal) FROM Pedido p";
		return entityManager.createQuery(JPQL, BigDecimal.class).getSingleResult();
	}

}
