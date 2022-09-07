<%@page import="br.com.alura.gerenciador.servlet.Empresa"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%

	List<Empresa> lista = (List<Empresa>)request.getAttribute("empresas");

%>   
 
<!DOCTYPE html>
<html lang="pt-br">
	
	<head>
	
	<meta charset="UTF-8">
	<title>Lista de Empresas</title>
	
	</head>
		<body>

				<ul>
					<%
						for (Empresa empresa : lista) {
					%>		
						<li><%=empresa.getNome() %>	</li>
					<%	
						}
					%>
				</ul>


		</body>
</html>