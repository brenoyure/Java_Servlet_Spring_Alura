<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/novaEmpresa" var="linkServletNovaEmpresa"/>
<c:url value="/listaEmpresas" var="linkServletListaEmpresas"/>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Formulário Nova Empresa</title>
</head>

<body>

	<h2>Formulário para abertura de nova Empresa</h2>

	<form action="${linkServletNovaEmpresa}" method="post">

		Nome: <input type="text" name="nome">
		<br> <br/> 
		Data de Abertura: <input type="text" name="data" >
		
		<input type="submit"/>


	</form>

	<p>Para listar/editar as empresas clique <a href="${linkServletListaEmpresas}">aqui</a>.</p>


</body>

</html>