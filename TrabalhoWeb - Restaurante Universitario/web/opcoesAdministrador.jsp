<%-- 
    Document   : opcoesAdministrador
    Created on : 01/06/2018, 15:29:08
    Author     : mathe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div id="corpo">
            <br><br>
            <div id="servicos"> 
                    <ul>
                        <li><a href="FrontController?command=IncluirPaginaNaPrincipalCommand&opcaoEscolhida=cadastrarCliente.jsp">Cadastrar cliente</a></li>
                        <li><a href="FrontController?command=IncluirPaginaNaPrincipalCommand">Manter administrador</a></li>
                        <li><a href="FrontController?command=IncluirPaginaNaPrincipalCommand">Vender Credito</a></li>
                    </ul>	
            </div>	
        </div>
    </body>
</html>
