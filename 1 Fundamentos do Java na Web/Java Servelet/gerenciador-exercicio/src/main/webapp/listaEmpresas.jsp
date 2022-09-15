<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/RemoveEmpresa" var="remove" />
<c:url value="/entrada?acao=MostraEmpresa" var="mostrar" />
<c:url value="/formNovaEmpresa.jsp" var="formularioNovaEmpresa" />
 
<!DOCTYPE html>
<html lang="pt-br">
	
	<head>
	
	<meta charset="UTF-8">
	<title>Lista de Empresas</title>
	
	</head>
		<body>
			

			<h2>Lista das Empresas</h2>
				<ul>
					<c:forEach items="${empresas}" var="empresa" >
					<fmt:formatDate value="${empresa.dataDeAbertura}" var="data"/>
					
						<li>${empresa} - ${data} - 
						
						 <p align="justify"><a href="${mostrar}&id=${empresa.id}">Editar</a> 
						 <a href="${remove}?id=${empresa.id}">Remover</a> </p> 
						
						
						
						</li>
					
					</c:forEach>
				</ul>
				
				<c:if test="${not empty empresas}">
					<h3>Outras Opções</h3>
						<p>Para voltar ao Formulário de Nova Empresa clique <a href="${formularioNovaEmpresa}">aqui</a></p>
				</c:if>
				
				<c:if test="${empty empresas}">
					<p> Nenhuma Empresa Encontrada. </p>
					<p> Cadastre uma nova clicando <a href="${formularioNovaEmpresa}">aqui</a></p>
				</c:if>
		

		</body>
</html>