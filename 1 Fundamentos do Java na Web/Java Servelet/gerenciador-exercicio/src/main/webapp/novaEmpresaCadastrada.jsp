<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%

	String nomeDaEmpresa = (String) request.getAttribute("nome-da-empresa");


%>    
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nova Empresa Cadastrada</title>
</head>
<body>

	<h2>Cadastro de Nova Empresa</h2>
	
		<p> Empresa <%=nomeDaEmpresa %> cadastrada com sucesso. </p>


</body>
</html>