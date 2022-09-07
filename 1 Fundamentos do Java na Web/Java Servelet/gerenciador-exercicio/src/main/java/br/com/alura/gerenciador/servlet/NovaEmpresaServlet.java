package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NovaEmpresaServlet
 */
@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nomeDaEmpresa = request.getParameter("nome");

		Empresa empresa = new Empresa();
		empresa.setNome(nomeDaEmpresa);

		Banco banco = new Banco();
		banco.adiciona(empresa);

		request.setAttribute("nome-da-empresa", empresa.getNome());
		request.getRequestDispatcher("/novaEmpresaCadastrada.jsp").forward(request, response);

		System.out.println("Empresa " + nomeDaEmpresa + " cadastrada com sucesso.");

	}

}
