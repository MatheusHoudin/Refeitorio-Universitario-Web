<%-- 
    Document   : cadastrarOpcaoComida
    Created on : 06/06/2018, 17:25:45
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
        <fieldset title="Cadastro de ingrediente">
            <form method="post" action="FrontController">
                Nome Ingrediente: <input name="nome" type="text">
                Gramas: <input name="gramas" type="number">
                Proteinas: <input type="number" name="proteinas">
                Lipídios: <input type="number" name="lipidios">
                Lactose:
                Sim<input type="radio" name="lactose" value="sim">
                Não<input type="radio" name="lactose" value="nao">
                
                <button name="command" value="CadastrarIngredienteCommand">Cadastrar</button>
            </form>
        </fieldset>
    </body>
</html>