package br.com.alura.gerenciador.acoes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginForm implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean usuarioNaoEstiverLogado = (request.getSession().getAttribute("usuarioLogado") == null);
		
		if (usuarioNaoEstiverLogado)
			return "forward:formLogin.jsp";
		
		return "redirect:entrada?acao=ListaEmpresas";
		
	}

}
