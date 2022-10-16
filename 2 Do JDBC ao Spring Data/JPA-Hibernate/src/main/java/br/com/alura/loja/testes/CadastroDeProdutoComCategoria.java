package br.com.alura.loja.testes;

import java.math.BigDecimal;

import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import static br.com.alura.loja.util.JPAUtil.getEntityManager;
import jakarta.persistence.EntityManager;

public class CadastroDeProdutoComCategoria {

	public static void main(String[] args) {
		
		EntityManager em = getEntityManager();
		ProdutoDao dao = new ProdutoDao(em);
		
		em.getTransaction().begin();
		
		try {
			
			
			Categoria celulares = em.getReference(Categoria.class, 1l);
			Produto celular = new Produto("Smartphone Teste", "Velha Guarda Raiz", new BigDecimal("0"), celulares);
			
			dao.cadastrar(celular);
			
			System.out.printf("Produto %s de ID %d, %s, R$%s cadastrado na categoria de %s. \n", 
					celular.getNome(), celular.getId(), celular.getDescricao(), celular.getPreco(), celular.getCategoria().getNome());
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			System.out.println("Fechando o EntityManager...");
			em.getTransaction().commit();
			em.clear();
			em.close();
			System.out.println("EntityManager fechado com sucesso.");
		}
		
	}

}
