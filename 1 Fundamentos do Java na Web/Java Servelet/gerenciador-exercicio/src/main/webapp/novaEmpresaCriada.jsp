<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:formatDate value="${dataDeAbertura}" var="data" pattern="dd/MM/yyyy"/>


<!DOCTYPE html>
<html>

	<head>
	<meta charset="UTF-8">

	<title>Nova Empresa Cadastrada</title>

	</head>

		<body>
		
			<h2>Cadastro de Nova Empresa</h2>
			
				<c:if test="${not empty nomeDaEmpresa}">
					<p> Empresa ${nomeDaEmpresa} cadastrada com sucesso. </p>
					<p>	Data de abertura, em ${data}	</p>
				</c:if>
				
				<c:if test="${empty nomeDaEmpresa}">
					<h2>ERRO!!!</h2>
						<p>Usuário tentou acessar o JSP NovaEmpresa diretamente.</p>
						<p>Nenhuma empresa cadastrada.</p>
				</c:if>				
		
		</body>
</html>