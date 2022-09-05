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
	
		System.out.println("Cadastrando nova empresa");
		
		
		String nomeDaEmpresa = req.getParameter("nome");
		Empresa empresa = new Empresa();
		empresa.setNome(nomeDaEmpresa);
		
		Banco banco = new Banco();
		banco.adiciona(empresa);
		String empresas = banco.getEmpresas().toString();
		
		
		PrintWriter out = resp.getWriter();
		out.println("<html><body> Empresa " + nomeDaEmpresa + " cadastrada com sucesso. <p>" + empresas + "</p> </body></html>");
		
		
	}

}
