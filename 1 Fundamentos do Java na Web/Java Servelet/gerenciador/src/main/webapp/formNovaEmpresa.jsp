<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/novaEmpresa" var="linkServletNovaEmpresa"/>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Formul�rio Nova Empresa</title>
</head>

<body>

	<h2>Formul�rio para abertura de nova Empresa</h2>

	<form action="${linkServletNovaEmpresa}" method="post">

		Nome: <input type="text" name="nome">
		<br> <br/> 
		Data de Abertura: <input type="text" name="data" >
		
		<input type="submit"/>


	</form>

</body>

</html>