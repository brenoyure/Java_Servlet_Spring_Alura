package br.com.alura.loja.testes;

import br.com.alura.loja.dao.PedidoDao;
import br.com.alura.loja.util.JPAUtil;
import jakarta.persistence.EntityManager;

public class ValorTotalPedidos {

	public static void main(String[] args) {

		EntityManager em = JPAUtil.getEntityManager();

		PedidoDao dao = new PedidoDao(em);

		System.out.printf("Valor total R$%s", dao.valorTotalVendido());

	}

}
