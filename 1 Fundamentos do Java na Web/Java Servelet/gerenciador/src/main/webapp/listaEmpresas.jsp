<%@page import="br.com.alura.gerenciador.servlet.Empresa"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
    <head>
        <title>Lista Empresas</title>
    </head>

		<body>
               
            
            <h2>Lista de Empresas </h2>
			<ul>
				<c:forEach items="${empresas}" var="empresa">
					<li>${empresa.nome} - <fmt:formatDate value="${empresa.dataAbertura }" pattern="dd/MM/yyyy"/></li>			
				</c:forEach>
			</ul>
			
			
			
		</body>


</html>