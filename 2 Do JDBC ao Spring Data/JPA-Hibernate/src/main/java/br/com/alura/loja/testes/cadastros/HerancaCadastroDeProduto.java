package br.com.alura.loja.testes.cadastros;

import java.math.BigDecimal;

import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Informatica;
import br.com.alura.loja.modelo.Livro;
import br.com.alura.loja.util.JPAUtil;
import jakarta.persistence.EntityManager;

public class HerancaCadastroDeProduto {

	EntityManager em = JPAUtil.getEntityManager();

	public static void main(String[] args) {
		
		cadastraPC();
		cadastraLivro();

	}
	
	private static void cadastraPC() {

		EntityManager em = JPAUtil.getEntityManager();
		
		ProdutoDao pDao = new ProdutoDao(em);
		CategoriaDao cDao = new CategoriaDao(em);

		em.getTransaction().begin();

		Categoria categoria = new Categoria("Informatica");
		Informatica p = new Informatica("Computador", "Core i5 8GB", new BigDecimal("1500"), "Dell", "Optplex", categoria);
		
		cDao.cadastrar(categoria);
		pDao.cadastrar(p);
		
		System.out.printf("Produto %s de ID %d, %s, R$%s cadastrado na categoria de %s. \n", 
				p.getNome(), p.getId(), p.getDescricao(), p.getPreco(), p.getCategoria().getNome());

		em.getTransaction().commit();
		em.close();

	}

	private static void cadastraLivro() {

		EntityManager em = JPAUtil.getEntityManager();
		
		ProdutoDao pDao = new ProdutoDao(em);
		CategoriaDao cDao = new CategoriaDao(em);

		em.getTransaction().begin();

		Categoria categoria = new Categoria("Livro");
		Livro p = new Livro("e-Book", "Sobre JPA", new BigDecimal("200"), "Paulo Silveira", 100, categoria);
		
		cDao.cadastrar(categoria);
		pDao.cadastrar(p);
		
		System.out.printf("Produto %s de ID %d, %s, R$%s cadastrado na categoria de %s. \n", 
				p.getNome(), p.getId(), p.getDescricao(), p.getPreco(), p.getCategoria().getNome());

		em.getTransaction().commit();
		em.close();

	}

}
