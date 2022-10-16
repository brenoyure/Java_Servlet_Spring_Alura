package br.com.alura.loja.testes;

import static br.com.alura.loja.util.JPAUtil.getEntityManager;

import java.math.BigDecimal;
import java.util.List;

import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Produto;
import jakarta.persistence.EntityManager;

public class TesteQuery {

	public static void main(String[] args) {

		EntityManager em = getEntityManager();
		ProdutoDao dao = new ProdutoDao(em);

		List<Produto> produtos = dao.buscarPelaCategoria("celular");
		produtos.forEach(p -> System.out.println(p.getNome()));

		BigDecimal preco = dao.buscarPrecoDoProdutoComNome("Samsung");
		System.out.println(preco);

	}

}
