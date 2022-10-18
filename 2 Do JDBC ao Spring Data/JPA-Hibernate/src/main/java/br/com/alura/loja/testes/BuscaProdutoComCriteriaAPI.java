package br.com.alura.loja.testes;

import static br.com.alura.loja.util.JPAUtil.getEntityManager;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import jakarta.persistence.EntityManager;

import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Produto;

public class BuscaProdutoComCriteriaAPI {

	public static void main(String[] args) {
		
		EntityManager em = getEntityManager();
		
		ProdutoDao dao = new ProdutoDao(em);
		
		List<Produto> produtos = dao
				.buscarTodosComCriteriaAPI(
						"PlayStation 5", new BigDecimal("4000"), LocalDate.of(2022, Month.OCTOBER, 17));
		
		produtos.forEach(p -> System.out.printf("%s \n", p.getNome()));
//		produtos.forEach(p -> System.out.printf("%s, %s, %s \n", p.getNome(), p.getDescricao(), p.getCategoria().getNome()));
		
		

	}

}
