package br.com.alura.gerenciador.acoes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class MostraEmpresa implements Acao {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Integer id = Integer.valueOf(request.getParameter("id"));
		Empresa empresa = new Banco().buscaEmpresaPelaID(id);
		
		request.setAttribute("empresa", empresa);
		request.getRequestDispatcher("/formEditarEmpresa.jsp").forward(request, response);
		
		
	}

}
