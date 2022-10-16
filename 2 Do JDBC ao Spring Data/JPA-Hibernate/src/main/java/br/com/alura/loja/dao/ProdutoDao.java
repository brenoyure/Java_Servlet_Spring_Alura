package br.com.alura.loja.dao;

import java.math.BigDecimal;
import java.util.List;

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

	public Produto getProduto(Long id) {
		return this.entityManager.find(Produto.class, id);
	}

	public List<Produto> buscarPorNome(String nome) {
		final String JPQL = "SELECT p FROM Produto p WHERE p.nome LIKE ?1";
		return this.entityManager.createQuery(JPQL, Produto.class).setParameter(1, "%" + nome + "%").getResultList();
	}

	public BigDecimal buscarPrecoDoProdutoComNome(String nome) {
		final String JPQL = "SELECT p.preco FROM Produto p WHERE p.nome LIKE ?1";
		return this.entityManager.createQuery(JPQL, BigDecimal.class).setParameter(1, "%" + nome + "%")
				.getSingleResult();
	}

	public List<Produto> buscarPelaCategoria(String nome) {
		final String JPQL = "SELECT p FROM Produto p WHERE p.categoria.nome LIKE ?1";
		return this.entityManager.createQuery(JPQL, Produto.class).setParameter(1, "%" + nome + "%").getResultList();
	}

	public List<Produto> buscarTodos() {
		final String JPQL = "SELECT p FROM Produto p";
		return this.entityManager.createQuery(JPQL, Produto.class).getResultList();
	}

}
