package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

/**
 * Servlet implementation class EditarEmpresa
 */
//@WebServlet("/obterDadosEmpresa")
public class ObterDadosEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			Empresa empresa = new Banco().buscaPeloID(Integer.valueOf(request.getParameter("id")));
			System.out.println("Obtendo dados da empresa: " + empresa.getNome() + " a partir do IP: " + request.getRemoteHost());
			request.setAttribute("empresa", empresa);
			request.getRequestDispatcher("/formEditarEmpresa.jsp").forward(request, response);
		
		} catch (NumberFormatException e) {
			System.err.println("Campo de Número em branco ou ID inválida.");
			response.sendRedirect("listaEmpresas");
		}
		
	}

}
