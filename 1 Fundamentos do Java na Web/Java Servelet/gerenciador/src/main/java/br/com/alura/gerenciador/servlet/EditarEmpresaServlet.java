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

/**
 * Servlet implementation class EditarEmpresaServlet
 */
//@WebServlet("/editarEmpresa")
public class EditarEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer id = Integer.valueOf(request.getParameter("id"));
		String nomeDaEmpresa = (String) request.getParameter("nome");
		String paramDataDeAbertura = (String) request.getParameter("data");

		try {

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date dataDeAbertura = sdf.parse(paramDataDeAbertura);

			new Banco().editarEmpresaPeloID(id, nomeDaEmpresa, dataDeAbertura);

			response.sendRedirect("listaEmpresas");

		} catch (ParseException e) {

			response.sendRedirect("listaEmpresas");

		}

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.err.println("IP: " + request.getRemoteHost() + " -> "
				+ "Acesso via método http-get não permitido ao servlet atual.");
		response.sendRedirect("listaEmpresas");

	}

}
