package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

//WebFilter configurado no web.xml
public class MonitoramentoFilter implements Filter {

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) servletRequest;
		
		System.out.println("MonitoramentoFilter");
		
		long antes = System.currentTimeMillis();
		
		chain.doFilter(servletRequest, servletResponse);

		long depois = System.currentTimeMillis();
		long tempo = (depois - antes);
		
		System.out.println("Tempo da Ação " + request.getParameter("acao") + tempo + "ms" );
		
	}

}
