package br.com.alura.gerenciador.acoes;

import java.io.IOException;
import java.util.NoSuchElementException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;

public class RemoveEmpresa implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Integer id = Integer.valueOf(request.getParameter("id"));
			new Banco().remove(id);
			return "redirect:entrada?acao=ListaEmpresas";
			
		} catch (NumberFormatException | NoSuchElementException e) {
			System.out.println(e.getLocalizedMessage());
			return "redirect:entrada?acao=ListaEmpresas";
		}
		
		
	}

}
