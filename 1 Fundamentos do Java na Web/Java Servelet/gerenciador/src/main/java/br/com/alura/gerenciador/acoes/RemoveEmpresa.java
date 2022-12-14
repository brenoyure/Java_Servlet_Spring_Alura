package br.com.alura.gerenciador.acoes;

import java.io.IOException;
import java.util.NoSuchElementException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.modelo.Banco;

public class RemoveEmpresa implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			// Recebendo o parâmetro ID da Empresa, como String
		String parametroID = request.getParameter("id");

		try {
			
			// Fazendo parsing para Inteiro (Integer)
			Integer id = Integer.valueOf(parametroID);

			// Instanciando o Banco & Chamado o Método para Remover
			new Banco().remove(id);
			
			// Após a exclusão, redirecionando o usuário de volta para a lista (servlet Entrada).
			return "redirect:entrada?acao=ListaEmpresas";
			
		} catch (NumberFormatException | NoSuchElementException e) {
			/*
			 * Caso o número da ID venha numa formato inválido ou em branco, ou
			 * 
			 * Caso o método remove() não encontre a ID, 
			 *  
			 * Mostra uma msg de erro no console e redireciona o usuário de volta para a lista.
			 */

			System.err.println("Formato de Número Inválido.");
			System.out.println("Nenhuma Empresa Removida, registro do banco não afetado.");
			return "redirect:entrada?acao=ListaEmpresa";
		}

	}

}
