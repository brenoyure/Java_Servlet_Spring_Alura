package br.com.alura.loja.testes;

import br.com.alura.loja.dao.ClienteDao;
import br.com.alura.loja.dao.PedidoDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Cliente;
import br.com.alura.loja.modelo.ItemPedido;
import br.com.alura.loja.modelo.Pedido;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;
import jakarta.persistence.EntityManager;

public class CadastroDePedido {

	public static void main(String[] args) {
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao pDao = new ProdutoDao(em);
		PedidoDao pedidoDao = new PedidoDao(em);
		ClienteDao clienteDao = new ClienteDao(em);
		
		
		Produto produto = pDao.getProduto(1l);
		
		
		em.getTransaction().begin();
		
		Cliente cliente = new Cliente("Breno Yuri", "123456");
		clienteDao.cadastrar(cliente);
		
		Pedido pedido = new Pedido(cliente); 
		pedido.adicionarItem(new ItemPedido(2, produto, pedido));
		
		pedidoDao.cadastrar(pedido);

		em.getTransaction().commit();
		em.close();
		
	}

}
