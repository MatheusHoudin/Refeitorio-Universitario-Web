<%-- 
    Document   : cadastrarOpcaoComida
    Created on : 07/06/2018, 08:23:30
    Author     : mathe
--%>

<%@page import="modelo.bean.IngredienteBean"%>
<%@page import="dao.IngredienteDAO"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Ingrediente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="get" action="FrontController" >
            Nome: <input name="nome" type="text">
            Categoria:
            <select name="categoria">
                <option value="principal" >Principal</option>
                <option value="sobremesa">Sobremesa</option>
                <option value="secundario" >Secundário</option>
                <option value="acompanhamento">Acompanhamento</option>
                <option value="guarnicao" >Guarnição</option>
                <option value="bebida" >Bebida</option>
                <option value="vegetariano">Vegetariano</option>
            </select>
            Ingredientes:
            <%
                List<IngredienteBean> ingredientes = IngredienteDAO.obterIngredientes();
                for(IngredienteBean ingBean:ingredientes){
            %>
            <h5><%= ingBean.getNome() %></h5>
            <input type="checkbox" name="ingredientes" value="<%=ingBean.getId()%>">
            <%   
                }
            %>
            <button name="command" value="CadastrarOpcaoComidaCommand">Cadastrar</button>
        </form>
    </body>
</html>
