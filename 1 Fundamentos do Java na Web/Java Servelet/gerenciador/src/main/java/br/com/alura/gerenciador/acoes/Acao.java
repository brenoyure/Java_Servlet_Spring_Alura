package br.com.alura.gerenciador.acoes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

interface Acao {

	String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

}
