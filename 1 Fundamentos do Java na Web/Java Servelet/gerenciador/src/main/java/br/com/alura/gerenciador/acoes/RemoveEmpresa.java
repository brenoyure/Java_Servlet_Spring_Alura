package br.com.alura.gerenciador.acoes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;

public class RemoveEmpresa implements Acao {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			// Recebendo o parâmetro ID da Empresa, como String
		String parametroID = request.getParameter("id");

		try {
			
			// Fazendo parsing para Inteiro (Integer)
			Integer id = Integer.valueOf(parametroID);

			// Instanciando o Banco & Chamado o Método para Remover
			new Banco().remove(id);
			
			// Após a exclusão, redirecionando o usuário de volta para a lista.
			response.sendRedirect("entrada?acao=ListaEmpresas");
			
		} catch (NumberFormatException e) {
			/*
			 * Caso o número da ID venha numa formato inválido ou em branco, Mostra uma msg
			 * de erro no console e redireciona o usuário de volta para a lista.
			 */

			System.err.println("Formato de Número Inválido.");
			System.out.println("Nenhuma Empresa Removida, registro do banco não afetado.");
			response.sendRedirect("entrada?acao=ListaEmpresas");
		}

	}

}
