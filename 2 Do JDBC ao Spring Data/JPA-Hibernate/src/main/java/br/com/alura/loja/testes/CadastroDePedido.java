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
		
//		clienteDao.cadastrar(cliente);
		
		
		em.getTransaction().begin();
		
		Cliente cliente = clienteDao.buscarPorId(1l);
		Pedido pedido = new Pedido(cliente);
		Produto produto = pDao.getProduto(3l);
		pedido.adicionarItem(new ItemPedido(2, produto, pedido));
		
		pedidoDao.cadastrar(pedido);

		em.getTransaction().commit();
		em.close();
		
	}

}
