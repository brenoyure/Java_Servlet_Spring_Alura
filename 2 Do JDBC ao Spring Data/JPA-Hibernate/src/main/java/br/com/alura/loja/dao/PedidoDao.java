package br.com.alura.loja.dao;

import static java.util.Collections.unmodifiableList;

import java.math.BigDecimal;
import java.util.List;

import br.com.alura.loja.modelo.Pedido;
import br.com.alura.loja.modelo.RelatorioVendasVO;
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
		return unmodifiableList(entityManager.createQuery(JPQL, Pedido.class).getResultList());
	}

	public BigDecimal valorTotalVendido() {
		final String JPQL = "SELECT SUM(p.valorTotal) FROM Pedido p";
		return entityManager.createQuery(JPQL, BigDecimal.class).getSingleResult();
	}

	public List<RelatorioVendasVO> getRelatorio() {

		final String JPQL = "SELECT new br.com.alura.loja.modelo"

				+ ".RelatorioVendasVO(produto.nome, SUM(item.quantidade), MAX(pedido.data)) FROM "
				+ "Pedido pedido "
				+ "JOIN pedido.itens item "
				+ "JOIN item.produto produto "
				+ "GROUP BY produto.nome "
				+ "ORDER BY item.quantidade DESC";

		return unmodifiableList(entityManager.createQuery(JPQL, RelatorioVendasVO.class).getResultList());

	}
	
	public Pedido buscarPedidoComCliente(Long clienteId) {
		return entityManager
				.createQuery("SELECT p FROM Pedido p JOIN FETCH p.cliente WHERE p.id = ?1", Pedido.class)
				.setParameter(1, clienteId)
				.getSingleResult();
	}

}
