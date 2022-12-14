package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.acoes.Acao;


//@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String paramAcao = request.getParameter("acao");

		boolean usuarioNaoEstiverLogado = (request.getSession().getAttribute("usuarioLogado") == null);
		boolean acaoProtegida = !(paramAcao.equals("Login") || paramAcao.equals("LoginForm"));
		
		if (acaoProtegida && usuarioNaoEstiverLogado) {
			response.sendRedirect("entrada?acao=LoginForm");
			return;
		}
		
		
		String nomeDaClasse = ("br.com.alura.gerenciador.acoes." + paramAcao);
		String nome;
		String[] tipoEEndereco;
		
		try {
			
			Acao acao = (Acao) Class.forName(nomeDaClasse).getDeclaredConstructor().newInstance();
			nome = acao.executa(request, response);		
			
			tipoEEndereco = nome.split(":");

			if (tipoEEndereco[0].equals("forward"))
				request.getRequestDispatcher("WEB-INF/view/" + tipoEEndereco[1]).forward(request, response);
			
			if (tipoEEndereco[0].equals("redirect"))
				response.sendRedirect(tipoEEndereco[1]);
			
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | SecurityException | ClassNotFoundException | NoSuchMethodException | InvocationTargetException e) {
			System.err.println(e.getLocalizedMessage());
			nome = "redirect:entrada?acao=ListaEmpresas";
		}
		
		
	}
	
}
