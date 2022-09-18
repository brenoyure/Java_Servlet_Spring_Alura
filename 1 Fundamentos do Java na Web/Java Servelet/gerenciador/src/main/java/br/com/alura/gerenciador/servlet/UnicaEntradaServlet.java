package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acoes.Acao;


@WebServlet("/entrada")
@SuppressWarnings("deprecation")
public class UnicaEntradaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String parametroAcao = request.getParameter("acao");
		
		boolean usuarioNaoEstiverLogado = request.getSession().getAttribute("usuarioLogado") == null;
		boolean acaoProtegida = !(parametroAcao.equals("Login") || parametroAcao.equals("LoginForm"));
		
		if (acaoProtegida && usuarioNaoEstiverLogado) {
			response.sendRedirect("entrada?acao=LoginForm");
			return;
		}
			
		
		String nomeDaClasse = ("br.com.alura.gerenciador.acoes." + parametroAcao);
		
		String nome;
		
		try {
			Class<?> classe = Class.forName(nomeDaClasse);
			Acao acao = (Acao) classe.newInstance();
			nome = acao.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException | IOException e) {
			System.err.println(e.getLocalizedMessage());
			nome = "redirect:entrada?acao=ListaEmpresas";
		}

		String[] tipoEEndereco = nome.split(":");

		if (tipoEEndereco[0].equals("dispatcher"))
			request.getRequestDispatcher("WEB-INF/view/" + tipoEEndereco[1]).forward(request, response);
		
		if (tipoEEndereco[0].equals("redirect"))
			response.sendRedirect(tipoEEndereco[1]);

		/**
		 * Variável "nome" recebe o retorno dos métodos executa das Classes que implementam a interface Ação.
		 * 
		 * Utilizamos o método .split() para separar a String em duas partes, divisão essa que nos devolve um vetor com duas posições: 
		 * 
		 * No lado esquerdo String[0],  
		 * 		temos tipo => se é um DISPATCHER ou um REDIRECT
		 * 
		 * No lado direito String[1],
		 * 		temos o "endereço", por assim dizer, 
		 * 			que pode ser um JSP, ou alguma chamada para o servlet de entrada
		 * 
		 */
		
		
	}

}
