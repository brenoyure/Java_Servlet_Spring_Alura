package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acoes.Acao;


/**
 * Servlet Filter implementation class ControladorFilter
 */
//@WebFilter("/entrada")
@SuppressWarnings("deprecation")
public class ControladorFilter implements Filter {

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)	throws IOException, ServletException {

		System.out.println("ControladorFilter");
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		String parametroAcao = request.getParameter("acao");

		String nomeDaClasse = ("br.com.alura.gerenciador.acoes." + parametroAcao);

		String nome;

		try {
			Class<?> classe = Class.forName(nomeDaClasse);
			Acao acao = (Acao) classe.newInstance();
			nome = acao.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException
				| IOException e) {
			System.err.println(e.getLocalizedMessage());
			nome = "redirect:entrada?acao=ListaEmpresas";
		}

		String[] tipoEEndereco = nome.split(":");

		if (tipoEEndereco[0].equals("dispatcher"))
			request.getRequestDispatcher("WEB-INF/view/" + tipoEEndereco[1]).forward(request, response);

		if (tipoEEndereco[0].equals("redirect"))
			response.sendRedirect(tipoEEndereco[1]);
		
		// Não possui o chain.doFilter() pois o Controller é o último filtro

	}

}
