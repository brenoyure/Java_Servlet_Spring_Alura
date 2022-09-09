package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
		String parametroDataDeAbertura = request.getParameter("data");
		Date dataDeAbertura = null;

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataDeAbertura = sdf.parse(parametroDataDeAbertura);
			
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		Empresa empresa = new Empresa();
		empresa.setNome(nomeDaEmpresa);
		empresa.setDataDeAbertura(dataDeAbertura);

		Banco banco = new Banco();
		banco.adiciona(empresa);

		request.setAttribute("nomeDaEmpresa", empresa.getNome());
		request.setAttribute("dataDeAbertura", dataDeAbertura);
		request.getRequestDispatcher("/novaEmpresaCriada.jsp").forward(request, response);

		System.out.println("Empresa " + nomeDaEmpresa + " cadastrada com sucesso.");

	}

}
