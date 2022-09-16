package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acoes.EditarEmpresa;
import br.com.alura.gerenciador.acoes.ListaEmpresas;
import br.com.alura.gerenciador.acoes.MostraEmpresa;
import br.com.alura.gerenciador.acoes.NovaEmpresa;
import br.com.alura.gerenciador.acoes.RemoveEmpresa;

@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String parametroAcao = request.getParameter("acao");
		String nome = null;

		switch (parametroAcao) {
		
		case "ListaEmpresas":
			nome = new ListaEmpresas().executa(request, response);
			break;

		case "NovaEmpresa":
			nome = new NovaEmpresa().executa(request, response);
			break;

		case "RemoveEmpresa":
			nome = new RemoveEmpresa().executa(request, response);
			break;

		case "MostraEmpresa":
			nome = new MostraEmpresa().executa(request, response);
			break;

		case "EditarEmpresa":
			nome = new EditarEmpresa().executa(request, response);
			break;

		default:
			response.sendRedirect("entrada?acao=ListaEmpresas");
			System.err.println("Parâmetro incorreto, voltando para a lista.");

			break;
		}

		/**
		 * Variável "nome" recebe o retorno dos métodos executa das Classes que implementam a interface Ação.
		 * 
		 * Utilizamos o método .split() para separar a String em duas partes, divisão essa que nos devolve um vetor com duas posições: 
		 * 
		 * No lado esquerdo String[0],  
		 * 		temos tipo => se é um DISPATCHER ou um REDIRECT
		 * 
		 * No lado direito String[1],
		 * 		temos o "endereço", por assim dizer, 
		 * 			que pode ser um JSP, ou alguma chamada para o servlet de entrada
		 * 
		 */
		
		String[] tipoEEndereco = nome.split(":");

		if (tipoEEndereco[0].equals("dispatcher"))
			request.getRequestDispatcher(tipoEEndereco[1]).forward(request, response);
		
		if (tipoEEndereco[0].equals("redirect"))
			response.sendRedirect(tipoEEndereco[1]);
		
		System.out.println("Teste TIPO & Redirect " + tipoEEndereco[0] + ":" + tipoEEndereco[1]);
		
		
	}

}
