package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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

		String nomeDaEmpresa = request.getParameter("nome");

		try {
			Empresa empresa = new Empresa();
			empresa.setNome(request.getParameter("nome"));
			empresa.setDataDeAbertura(new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("data")));

			new Banco().adiciona(empresa);

			request.setAttribute("nomeDaEmpresa", empresa.getNome());

			response.sendRedirect("listaEmpresas");

			System.out.println("Empresa " + nomeDaEmpresa + " cadastrada com sucesso.");

		} catch (NullPointerException | IllegalArgumentException e) {
			System.err.println(e.getLocalizedMessage());
			response.sendRedirect("formNovaEmpresa.jsp");

		} catch (ParseException e) {
			System.err.println("Formato de Data em branco ou não suportado: " + request.getParameter("data"));
			response.sendRedirect("formNovaEmpresa.jsp");
		}

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		System.err.println(
				"IP: " + request.getRemoteHost() + " -> Acesso ao servlet atual via método http-get não permitido.");
		response.sendRedirect("listaEmpresas");

	}

}
