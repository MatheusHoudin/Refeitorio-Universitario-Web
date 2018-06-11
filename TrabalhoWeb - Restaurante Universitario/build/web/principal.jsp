<%-- 
    Document   : principal
    Created on : 31/05/2018, 17:50:55
    Author     : mathe
--%>

<%@page import="modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página principal</title>

        <link rel="stylesheet" href="Style/style1.css" type="text/css">
    </head>

    <body>

    <div id="premenu">

	<ul>
		<li id="Ru"> <img src="Imagens/logo.png" id="logoRu" alt="logo Ru" height="80" width="160"></li>
			
		<img src="Imagens/perfil3.png" id="logoPerfil" alt="logo Perfil" height="80" width="80" >
				
		
	</ul>
    </div>
        <jsp:include page="${sessionScope.permissao}"/>
        
        <%
            if(request.getParameter("opcaoEscolhida")!=null){
        %>
            <jsp:include page="${param.opcaoEscolhida}"/>
        <%
            }
        %>
        
    </body>

</html>
