package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

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
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		String nomeDaEmpresa = req.getParameter("nome");
		
		out.println("<html>  <head> <title>Cadastro Realizado</title> </head>  <body> <h2> Empresa " + nomeDaEmpresa + " cadastrada com sucesso.</h2>  </body></html>");
		
		
		System.out.println("Empresa " + nomeDaEmpresa + " cadastrada com sucesso.");
		
	}

}
