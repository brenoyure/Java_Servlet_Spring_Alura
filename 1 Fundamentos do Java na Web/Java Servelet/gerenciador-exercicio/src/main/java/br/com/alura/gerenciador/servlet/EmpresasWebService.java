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

@WebServlet("/empresas")
public class EmpresasWebService extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {

		List<Empresa> empresas = new Banco().getEmpresas();
		
		String cabecalhoDaRequisicao = request.getHeader("Accept");
		
		if (cabecalhoDaRequisicao.contains("application/xml")) {
			XStream xStream = new XStream();
			xStream.alias("Empresa", Empresa.class);
			String xml = xStream.toXML(empresas);
			response.setContentType("application/xml");
			response.getWriter().print(xml);
		}
		
		else if (cabecalhoDaRequisicao.contains("application/json")) {
			String json = new Gson().toJson(empresas);
			response.setContentType("application/json");
			response.getWriter().print(json);
		}
		
		else 
			response.getWriter().print("[{'message':'no content'}]");
		
	}

}
