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
 * Servlet implementation class EditarEmpresa
 */
//@WebServlet("/EditarEmpresa")
public class EditarEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			Empresa empresa = new Banco().buscaPeloID(Integer.valueOf(request.getParameter("id")));
			empresa.setNome(request.getParameter("nome"));
			empresa.setDataDeAbertura(new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("data")));
			response.sendRedirect("listaEmpresas");
			System.out.println("Dados da Empresa Alterados para " + empresa.getNome() + " através do IP: "
					+ request.getRemoteHost());

		} catch (ParseException e) {
			System.err.println("Formato de Data não suportado.");
			response.sendRedirect("listaEmpresas");

		} catch (NumberFormatException e) {
			System.err.println("Campo ID em branco, ou formato não suportado.");
			response.sendRedirect("listaEmpresas");
		}

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.err.println(
				"IP: " + request.getRemoteHost() + " -> Acesso via método http-get não permitido ao servlet atual.");
		response.sendRedirect("listaEmpresas");

	}

}
