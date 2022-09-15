<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:url value="/entrada?acao=EditarEmpresa" var="linkServletEditarEmpresa"/>
<c:url value="/entrada?acao=ListaEmpresas" var="linkServletListaEmpresas"/>
<fmt:formatDate pattern="dd/MM/yyyy" var="data" value="${empresa.dataAbertura}"/>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Formulário para Editar uma Empresa</title>
</head>

<body>

	<h2>Formulário para editar uma Empresa</h2>

	<form action="${linkServletEditarEmpresa}" method="post">

		Nome: <input type="text" name="nome" value="${empresa.nome}">
		<br> <br/> 
		
		Data de Abertura: <input type="text" name="data" value="${data}" >
		
		<input type="hidden" name="id" value="${empresa.id}" >
		
		<input type="submit"/>

	</form>
	
	<p>Para listar/editar as empresas clique <a href="${linkServletListaEmpresas}">aqui</a>.</p>

</body>

</html>