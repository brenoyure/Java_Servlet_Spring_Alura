<%@page import="br.com.alura.gerenciador.modelo.Empresa"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/entrada?acao=RemoveEmpresa" var="excluir" />
<c:url value="/entrada?acao=MostraEmpresa" var="mostra" />
<c:url value="/entrada?acao=NovaEmpresaForm" var="formNovaEmpresa" />
<c:url value="/entrada?acao=Logout" var="logout" />

<fmt:formatDate var="dataDeAbertura" value="${dataDeAbertura}"/>

<html>
    <head>
    	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    	<meta charset="UTF-8">
        <title>Lista Empresas</title>
    </head>

		<body>
		    
		    <c:if test="${not empty usuarioLogado.login}">
		    	Usu?rio logado: ${usuarioLogado.login} 
		    </c:if>         

		    <c:if test="${empty usuarioLogado.login}">
		    	Nenhum Usu?rio Logado. 
		    </c:if>         
            
            
            <h2>Lista de Empresas </h2>
			<ul>
				
				<c:forEach items="${empresas}" var="empresa">
					
					<li>${empresa.nome} - <fmt:formatDate value="${empresa.dataAbertura}"/> 
					
					<a href="${mostra}&id=${empresa.id}"> editar </a> 
					<a href="${excluir}&id=${empresa.id}"> excluir </a> 					
					
					</li>	
							
				</c:forEach>
				
			</ul>
			
			<c:if test="${not empty empresas}"> 
				
				<h3>Outras Op??es</h3>
				<p> Para voltar para o formul?rio clique <a href="${formNovaEmpresa}">aqui</a>.</p>
				<p> Para sair clique <a href="${logout}">aqui</a>.</p>
			
			</c:if>
			
			
			<c:if test="${empty empresas}"> 
				
				<p> Nenhuma Empresa encontrada.</p>
				<p> Para cadastrar uma nova clique <a href="${formNovaEmpresa}">aqui</a>.</p>
				<p> Para sair clique <a href="${logout}">aqui</a>.</p>
			
			</c:if>
			
		</body>


</html>