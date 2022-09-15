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
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String parametroAcao = request.getParameter("acao");

		switch (parametroAcao) {
		case "ListaEmpresas":
			new ListaEmpresas().executa(request, response);
			break;
			
		case "NovaEmpresa":
			new NovaEmpresa().executa(request, response);
			break;
			
		case "RemoveEmpresa":
			new RemoveEmpresa().executa(request, response);
			break;

		case "MostraEmpresa":
			new MostraEmpresa().executa(request, response);
			break;
			
		case "EditarEmpresa":
			new EditarEmpresa().executa(request, response);
			break;
			
		default:
			response.sendRedirect("entrada?acao=ListaEmpresas");
			System.err.println("Parâmetro incorreto, voltando para a lista.");
			
			break;
		}
		
		
		
		
		
		
		
//		if (parametroAcao.equalsIgnoreCase("ListaEmpresas")) {
//			ListaEmpresas acao = new ListaEmpresas();
//			acao.executa(request, response);
//		}
//		
//		if (parametroAcao.equalsIgnoreCase("RemoveEmpresa")) {
//			RemoveEmpresa acao = new RemoveEmpresa();
//			acao.executa(request, response);
//			
//		}
//
//		if (parametroAcao.equalsIgnoreCase("MostraEmpresa")) {
//			MostraEmpresa acao = new MostraEmpresa();
//			acao.executa(request, response);
//		}
		
	}

}