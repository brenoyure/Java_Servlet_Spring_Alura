package br.com.alura.loja.testes.buscas;

import static br.com.alura.loja.util.JPAUtil.getEntityManager;

import java.util.List;

import jakarta.persistence.EntityManager;

import br.com.alura.loja.dao.*;
import br.com.alura.loja.modelo.RelatorioVendasVO;

public class GeraRelatorioVO {

	public static void main(String[] args) {

		EntityManager em = getEntityManager();

		PedidoDao dao = new PedidoDao(em);

		List<RelatorioVendasVO> relatorio = dao.getRelatorio();

		relatorio.forEach(System.out::println);

		em.close();

	}

}
