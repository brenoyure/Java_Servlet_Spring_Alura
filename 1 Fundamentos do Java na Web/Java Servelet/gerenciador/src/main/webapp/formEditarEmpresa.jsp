<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:url value="/editarEmpresa" var="linkServletEditarEmpresa"/>
<fmt:formatDate pattern="dd/MM/yyyy" var="data" value="${empresa.dataAbertura}"/>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Formul�rio Nova Empresa</title>
</head>

<body>

	<h2>Formul�rio para editar uma Empresa</h2>

	<form action="${linkServletEditarEmpresa}" method="post">

		Nome: <input type="text" name="nome" value="${empresa.nome}">
		<br> <br/> 
		
		Data de Abertura: <input type="text" name="data" value="${data}" >
		
		<input type="hidden" name="id" value="${empresa.id}" >
		
		<input type="submit"/>


	</form>

</body>

</html>