package br.com.alura.loja.dao;

import static java.util.Collections.unmodifiableList;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import br.com.alura.loja.modelo.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

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
		final String JPQL = "SELECT p FROM Produto p JOIN FETCH p.categoria WHERE p.categoria.nome LIKE ?1";
		return this.entityManager.createQuery(JPQL, Produto.class).setParameter(1, "%" + nome + "%").getResultList();
	}

	public List<Produto> buscarTodos() {
		final String JPQL = "SELECT p FROM Produto p JOIN FETCH p.categoria";
		return this.entityManager.createQuery(JPQL, Produto.class).getResultList();
	}

	public List<Produto> buscarTodosComCriteriaAPI() {

		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Produto> cQuery = cb.createQuery(Produto.class);
		cQuery.from(Produto.class).fetch("categoria");

		return unmodifiableList(entityManager.createQuery(cQuery).getResultList());

	}
	
	public List<Produto> buscarTodosComCriteriaAPI(String nome, BigDecimal preco, LocalDate dataCadastro) {
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Produto> query = builder.createQuery(Produto.class);
		Root<Produto> p = query.from(Produto.class); p.fetch("categoria");
		
		
		Predicate eNome		=	builder.equal(p.get("nome"), nome);
		Predicate eData		=	builder.equal(p.get("dataCadastro"), dataCadastro);
		Predicate ePreco	= 	builder.equal(p.get("preco"), preco);
		
		
		Predicate filtros = builder.and();
		
		if (nome != null && !nome.trim().isEmpty()) 
			filtros = builder.and(filtros, eNome);
			
		if (preco != null)
			filtros = builder.and(filtros, ePreco);
		
		if (dataCadastro != null) 
			filtros = builder.and(filtros, eData);
		
		
		query.where(filtros);
		

		return unmodifiableList(entityManager.createQuery(query).getResultList());
		
		
	}

}
