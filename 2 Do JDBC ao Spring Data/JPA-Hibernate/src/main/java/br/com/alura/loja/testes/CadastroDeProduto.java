package br.com.alura.loja.testes;

import java.math.BigDecimal;

import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;
import jakarta.persistence.EntityManager;

public class CadastroDeProduto {

	public static void main(String[] args) {

		Categoria celulares = new Categoria("Video Game");
		Produto celular = new Produto("PlayStation 5", "2 Controles", new BigDecimal("4000"), celulares);

		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);
		
		em.getTransaction().begin();
		categoriaDao.cadastrar(celulares);
		produtoDao.cadastrar(celular);
		em.getTransaction().commit();
		em.close();

		
		System.out.printf("Produto %s, %s, R$%s cadastrado na categoria de %s.", 
				celular.getNome(), celular.getDescricao(), celular.getPreco(), celular.getCategoria().getNome());
		

	}

}
