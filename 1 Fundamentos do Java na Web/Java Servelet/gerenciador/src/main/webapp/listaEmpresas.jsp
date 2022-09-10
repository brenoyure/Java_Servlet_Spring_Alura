<%@page import="br.com.alura.gerenciador.servlet.Empresa"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/excluirEmpresa" var="excluir" />
<c:url value="/mostraEmpresa" var="mostra" />
<c:url value="/formNovaEmpresa.jsp" var="formNovaEmpresa" />
<fmt:formatDate var="dataDeAbertura" value="${dataDeAbertura}"/>

<html>
    <head>
    	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    	<meta charset="UTF-8">
        <title>Lista Empresas</title>
    </head>

		<body>
		
		
			<c:if test="${not empty empresa}">
				Empresa ${empresa} cadastrada com sucesso.
				<br>
				Cadastro realizado na data de: ${dataDeAbertura}
			</c:if>
               
            
            <h2>Lista de Empresas </h2>
			<ul>
				<c:forEach items="${empresas}" var="empresa">
					<li>${empresa.nome} - <fmt:formatDate value="${empresa.dataAbertura}"/> 
					
					
					<a href="${mostra}?id=${empresa.id}"> editar </a> 
					<a href="${excluir}?id=${empresa.id}"> excluir </a> 
					
					
					</li>	
							
				</c:forEach>
			</ul>
			
			<p> Para voltar para o formulário clique <a href="${formNovaEmpresa}">aqui</a>.</p>
			
		</body>


</html>