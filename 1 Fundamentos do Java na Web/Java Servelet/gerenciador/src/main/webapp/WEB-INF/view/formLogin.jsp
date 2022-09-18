<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/entrada" var="linkServletEntrada"/>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Formulário Login</title>
</head>

<body>

	<h2>Formulário de Login</h2>

	<form action="${linkServletEntrada}" method="post">

		Login: <input type="text" name="login">
		<br> <br/> 
		Senha: <input type="password" name="senha">
		<input type="hidden" name="acao" value="Login">
		
		<br> <br/> 
		
		<input type="submit" value="Entrar" />


	</form>


</body>

</html>