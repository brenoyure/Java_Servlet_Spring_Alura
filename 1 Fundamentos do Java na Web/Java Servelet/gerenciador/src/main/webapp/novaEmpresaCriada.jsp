<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:formatDate value="${dataDeAbertura }" var="data"/>

<html>

	<body>
		
		<c:if test="${not empty empresa}">
			Empresa ${empresa} cadastrada com sucesso.
			<br>
			Cadastro realizado na data de: ${data}
		</c:if>
		
		<c:if test="${empty empresa}">
			<h2>Usuário tentou acessar o JSP Nova Empresa diretamente</h2>
				Nenhuma empresa cadastrada.
		</c:if>
		
		
	</body>

</html>

















