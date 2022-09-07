<%@page import="br.com.alura.gerenciador.servlet.Empresa"%>
<%@page import="java.util.List"%>
<%

	List<Empresa> lista = (List<Empresa>) request.getAttribute("empresas");

%>


<html>
    <head>
        <title>Lista Empresas</title>
    </head>

		<body>
               
            <h2>Lista de Empresas </h2>
            
			<ul>	                
				<% 
					for (Empresa empresa : lista) { 
					
				%> 
					<li><%= empresa.getNome() %></li>
				<%
					} 
				%>
           </ul>   
                
                
                


		</body>


</html>