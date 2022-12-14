package br.com.alura.gerenciador.acoes;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class NovaEmpresa implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Banco banco = new Banco();
		
		try {
			String nome = request.getParameter("nome");
			Date dataDeAbertura = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("data"));

			Empresa empresa = new Empresa();
			empresa.setNome(nome);
			empresa.setDataDeAbertura(dataDeAbertura);

			banco.adiciona(empresa);
			return "redirect:entrada?acao=ListaEmpresas";

		} catch (NullPointerException | IllegalArgumentException | ParseException e) {
			System.err.println(e.getLocalizedMessage());
			
			if (banco.naoEstiverVazio())
				return "redirect:entrada?acao=ListaEmpresas";
			
			else 
				return "redirect:entrada?acao=NovaEmpresaForm";

		}

	}

}
