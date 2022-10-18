package br.com.alura.loja.testes;

import br.com.alura.loja.dao.PedidoDao;
import br.com.alura.loja.modelo.Cliente;
import br.com.alura.loja.modelo.Pedido;
import br.com.alura.loja.util.JPAUtil;
import jakarta.persistence.EntityManager;

public class PerformanceConsulta {

	public static void main(String[] args) {

		EntityManager em = JPAUtil.getEntityManager();
		
		PedidoDao dao = new PedidoDao(em);
		
		Pedido pedido = dao.buscarPedidoComCliente(1l);
		
		em.close();
		
		Cliente c = pedido.getCliente();
		
		System.out.printf("Cliente %s de CPF %s \n", c.getNome(), c.getCpf());
		
		
	}

}
