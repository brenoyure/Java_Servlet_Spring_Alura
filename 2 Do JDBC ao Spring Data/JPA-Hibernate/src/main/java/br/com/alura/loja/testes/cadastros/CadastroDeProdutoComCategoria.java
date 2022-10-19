package br.com.alura.loja.testes.cadastros;

import java.math.BigDecimal;

import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import static br.com.alura.loja.util.JPAUtil.getEntityManager;
import jakarta.persistence.EntityManager;

public class CadastroDeProdutoComCategoria {

	public static void main(String[] args) {
		
		EntityManager em = getEntityManager();
		CategoriaDao cDao = new CategoriaDao(em);
		ProdutoDao pDao = new ProdutoDao(em);
		
		em.getTransaction().begin();
		
		try {
			
			
			Categoria celulares = new Categoria("Celulares");
			Produto celular1 = new Produto("Smartphone Motorola", "Moto x4 Velha Guarda Raiz", new BigDecimal("1400"), celulares);
			Produto celular2 = new Produto("Smartphone SAMSUNG", "A52s 5G", new BigDecimal("2000"), celulares);
			
			cDao.cadastrar(celulares);
			pDao.cadastrar(celular1);
			pDao.cadastrar(celular2);
			
			System.out.printf("Produto %s de ID %d, %s, R$%s cadastrado na categoria de %s. \n", 
					celular1.getNome(), celular1.getId(), celular1.getDescricao(), celular1.getPreco(), celular1.getCategoria().getNome());
			
			System.out.printf("Produto %s de ID %d, %s, R$%s cadastrado na categoria de %s. \n", 
					celular1.getNome(), celular2.getId(), celular2.getDescricao(), celular2.getPreco(), celular2.getCategoria().getNome());
			
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			
		} finally {
			System.out.println("Fechando o EntityManager...");
			em.getTransaction().commit();
			em.clear();
			em.close();
			System.out.println("EntityManager fechado com sucesso.");
		}
		
	}

}
