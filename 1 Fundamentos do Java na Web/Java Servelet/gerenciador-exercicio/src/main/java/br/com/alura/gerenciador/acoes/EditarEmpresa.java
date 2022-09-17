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

public class EditarEmpresa implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {

		String nome = request.getParameter("nome");
		String parametroID = request.getParameter("id");
		
		try {

			Date dataDeAbertura = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("data"));
			
			Empresa empresa = new Banco().buscaPeloID(Integer.valueOf(parametroID));
			
			empresa.setNome(nome);
			empresa.setDataDeAbertura(dataDeAbertura);
			
			return "redirect:entrada?acao=ListaEmpresas";
			
		} catch (NullPointerException | IllegalArgumentException | ParseException e) {
			
			System.err.println(e.getLocalizedMessage());
			return "redirect:entrada?acao=MostraEmpresa&id=" + parametroID;
			
		}
		
		
		
	}

}
