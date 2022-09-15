package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

/**
 * Servlet implementation class NovaEmpresaServlet
 */
//@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nomeDaEmpresa = request.getParameter("nome"); 		// Recebendo o Nome da Empresa via request HTTP
		String paramDataDeAbertura = request.getParameter("data");	// Recebendo a Data de Abertura via request HTTP
		Date dataDeAbertura = null; 								// Inicializando uma Date como null

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataDeAbertura = sdf.parse(paramDataDeAbertura);

			Empresa empresa = new Empresa();
			empresa.setNome(nomeDaEmpresa);
			empresa.setDataAbertura(dataDeAbertura);

			new Banco().adiciona(empresa);

			System.out.println("Cadastrando nova empresa");
			request.setAttribute("empresa", empresa.getNome());
			request.setAttribute("dataDeAbertura", empresa.getDataAbertura());

			response.sendRedirect("listaEmpresas");

		} catch (NullPointerException | IllegalArgumentException | ParseException e) {
			System.err.println(e.getLocalizedMessage());
			response.sendRedirect("listaEmpresas");
		}

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.sendRedirect("listaEmpresas");

	}

}
