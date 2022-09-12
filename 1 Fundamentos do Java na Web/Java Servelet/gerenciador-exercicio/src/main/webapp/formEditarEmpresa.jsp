<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/EditarEmpresa" var="linkServletEditarEmpresa" />
<c:url value="/listaEmpresas" var="listarEmpresas" />
<fmt:formatDate value="${empresa.dataDeAbertura}" var="dataDeAbertura" pattern="dd/MM/yyyy"/>


<html> 
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	</head>

		<body>
		
			<h2>Formulário para Editar uma Empresa</h2>
		
				<form action="${linkServletEditarEmpresa}" method="post">
					
					Nome: <input name="nome" type="text" value="${empresa.nome}">
					
					<br><br>
							
					Nova Data: <input name="data" type="text" value="${dataDeAbertura}">
						  
						  <input name="id" type="hidden" value="${empresa.id}"> <!-- Input escondido, ID da Empresa -->
						  
						  <input type="submit"/>		
					
				</form>
				
					<h3>Outras Opções</h3>
						
							<p align="justify">Para voltar para lista, clique <a href="${listarEmpresas}">aqui</a></p>
		
		
		
		</body>
		
</html>