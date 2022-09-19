package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//WebFilter configurado no web.xml
public class AutenticacaoFilter implements Filter {

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("AutenticacaoFilter");
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		String paramAcao = request.getParameter("acao");

		boolean usuarioNaoEstiverLogado = (request.getSession().getAttribute("usuarioLogado") == null);
		boolean acaoProtegida = !(paramAcao.equals("Login") || paramAcao.equals("LoginForm"));
		
		if (acaoProtegida && usuarioNaoEstiverLogado) {
			response.sendRedirect("entrada?acao=LoginForm");
			return;
		}
	
		chain.doFilter(request, response);
		
	}

}
