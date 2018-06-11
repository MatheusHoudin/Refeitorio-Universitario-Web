<%-- 
    Document   : opcoesNutricionista
    Created on : 06/06/2018, 17:16:51
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
                        <li><a href="FrontController?command=IncluirPaginaNaPrincipalCommand&opcaoEscolhida=cadastrarIngrediente.jsp">Cadastrar Ingrediente</a></li>
                        <li><a href="FrontController?command=IncluirPaginaNaPrincipalCommand&opcaoEscolhida=cadastrarOpcaoComida.jsp">Cadastrar Opcao Comida</a></li>
                        <li><a href="FrontController?command=IncluirPaginaNaPrincipalCommand&opcaoEscolhida=cadastrarOpcaoDiaria.jsp">Cadastrar Opcao Diaria</a></li>
                    </ul>	
            </div>	
        </div>
    </body>
</html>
