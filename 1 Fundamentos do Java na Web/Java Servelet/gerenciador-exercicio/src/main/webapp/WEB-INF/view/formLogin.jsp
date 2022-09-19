<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada?acao=Login" var="linkLogin"/>

<!DOCTYPE html>

<html lang="pt-br">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Formul�rio de Login</title>
	</head>
			<body>
			
				<form action="${linkLogin}" method="post">
				
					<h3>Formul�rio de Login</h3>
					
					Login: <input type="text" name="login" placeholder="Nome de Usu�rio">
					
					<br><br/>
					
					Senha: <input type="password" name="senha" placeholder="Senha" />
					
					<input type="hidden" value="acao">
					
					<input type="submit"/>
				
				</form>
				
			
			</body>
</html>