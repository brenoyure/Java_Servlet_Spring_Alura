package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/oi")
public class OlaMundo extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Olá Mundo, meu primeiro ServLet Java!!!</h1>");
		out.println("<h2>Servlet foi chamado a partir do IP " + req.getRemoteAddr() + ".</h2>");
		out.println("</body>");
		out.println("</html>");
		
		
		System.out.println("Servlet foi chamado a partir do IP " + req.getRemoteAddr());
	}
	
}
