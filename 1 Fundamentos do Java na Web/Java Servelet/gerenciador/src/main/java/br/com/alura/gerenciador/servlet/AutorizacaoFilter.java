package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class AutorizacaoFilter
 */
//@WebFilter("/entrada")
public class AutorizacaoFilter extends HttpFilter implements Filter {

	private static final long serialVersionUID = 1L;

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)	throws IOException, ServletException {

		System.out.println("AutorizacaoFilter");

		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		String parametroAcao = request.getParameter("acao");

		boolean usuarioNaoEstiverLogado = request.getSession().getAttribute("usuarioLogado") == null;
		boolean acaoProtegida = !(parametroAcao.equals("Login") || parametroAcao.equals("LoginForm"));

		if (acaoProtegida && usuarioNaoEstiverLogado) {
			response.sendRedirect("entrada?acao=LoginForm");
			return;
		}

		chain.doFilter(servletRequest, servletResponse);
	}

}
