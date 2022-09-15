package br.com.alura.gerenciador.acoes;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class EditarEmpresa implements Acao {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String parametroID = request.getParameter("id");

		try {
			
//			Recebendo os Dados do Formulário, como String
			String nomeEmpresa = request.getParameter("nome");
			String parametroData = request.getParameter("data");

//			Fazendo Parsing e Format de String -> Inteiro ID e Data tipo Date
			Integer id = Integer.valueOf(parametroID);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
			Date dataAbertura = sdf.parse(parametroData);

//			Retornando a empresa, via busca por ID, e editando os dados
			Empresa empresa = new Banco().buscaEmpresaPelaID(id);
			empresa.setNome(nomeEmpresa);
			empresa.setDataAbertura(dataAbertura);
			
//			Redirecionando para a lista após a edição
			response.sendRedirect("entrada?acao=ListaEmpresas");
			
			
		} catch (NullPointerException | ParseException | NoSuchElementException | IllegalArgumentException e) {
			System.err.println(e.getLocalizedMessage());
			response.sendRedirect("entrada?acao=MostraEmpresa&id=" + parametroID);
		}
		
		
	}

}
