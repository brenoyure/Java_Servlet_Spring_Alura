<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada?acao=NovaEmpresa" var="linkServletNovaEmpresa"/>
<c:url value="/entrada?acao=ListaEmpresas" var="listaEmpresas"/>

<!DOCTYPE html>

<html lang="pt-br">
	<head>
		<meta charset="UTF-8">
		<title>Cadastro de Nova Empresa</title>
	</head>
			<body>
			
				<form action="${linkServletNovaEmpresa}" method="post">
				
					<h3>Formulário para Abertura de Nova Empresa</h3>
					
					Nome: <input type="text" name="nome">
					
					<br><br/>
					
					Data de Abertura: <input type="text" name="data"/>
					
					<input type="submit"/>
				
				</form>
				
				
				<h3>Outras Opções</h3>
				
					<p align="justify">Para listar as Empresas clique <a href="${listaEmpresas}">aqui</a></p>
				
				
			
			</body>
</html>