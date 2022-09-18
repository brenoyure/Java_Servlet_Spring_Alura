package br.com.alura.gerenciador.acoes;

import static br.com.alura.gerenciador.modelo.Banco.usuarioExiste;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {

		String login = request.getParameter("login");
		String senha = request.getParameter("senha");

		if (usuarioExiste(login, senha))
			return "redirect:entrada?acao=ListaEmpresas";

		else {
			System.err.println("Falha na Autenticação. Usuário ou Senha Incorretos.");
			return "redirect:entrada?acao=LoginForm";
		}

	}

}
