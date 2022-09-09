<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
 
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
					<fmt:formatDate value="${empresa.dataDeAbertura}" pattern="dd/MM/yyyy" var="data"/>
					
						<li>${empresa} - ${data}</li>	
					
					
					</c:forEach>
				</ul>


		</body>
</html>