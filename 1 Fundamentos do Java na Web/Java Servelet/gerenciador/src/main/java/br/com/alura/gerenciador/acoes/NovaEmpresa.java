package br.com.alura.gerenciador.acoes;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class NovaEmpresa implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sessao = request.getSession();
		if (sessao.getAttribute("usuarioLogado") == null)
			return "redirect:entrada?acao=LoginForm";
		
		String nome = request.getParameter("nome");
		String paramData = request.getParameter("data");
		Date dataAbertura = null;
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(paramData);
			
			Empresa empresa = new Empresa();
			empresa.setNome(nome);
			empresa.setDataAbertura(dataAbertura);
			
			new Banco().adiciona(empresa);
			
			return "redirect:entrada?acao=ListaEmpresas";
			
			
		} catch (IllegalArgumentException | ParseException | NullPointerException e) {
			System.err.println(e.getLocalizedMessage());
			return "redirect:entrada?acao=ListaEmpresas";
		}
		
		
	}

}
