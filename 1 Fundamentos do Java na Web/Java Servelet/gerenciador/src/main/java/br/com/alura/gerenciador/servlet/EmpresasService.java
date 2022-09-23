package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

/**
 * Servlet implementation class EmpresasService
 */
@WebServlet("/empresas")
public class EmpresasService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Empresa> empresas = new Banco().getEmpresas();
		
		String valor = request.getHeader("Accept");
		
		if (valor.contains("application/xml")) {
			XStream xStream = new XStream();
			
			xStream.alias("Empresa", Empresa.class);
			
			String xml = xStream.toXML(empresas);
			
			response.setContentType("application/xml");
			response.getWriter().print(xml);
		}
		
		else if (valor.contains("application/json")) {
			Gson gson = new Gson();
			
			String json = gson.toJson(empresas);
			
			response.setContentType("application/json");
			response.getWriter().print(json);
		}
		
		else {
			response.getWriter().print("[{'message:no content'}]");
		}
		
		
		
	}

}
