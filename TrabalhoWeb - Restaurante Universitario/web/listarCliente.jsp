<%-- 
    Document   : listarCliente
    Created on : 01/06/2018, 17:17:05
    Author     : mathe
--%>

<%@page import="dao.UsuarioDAO"%>
<%@page import="modelo.bean.UsuarioBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table>
            <tr>
                <th>Nome</th>
                <th>Email</th>
                <th>Codigo identificador</th>
                <th>Tipo usuario</th>
            </tr>
            <%
                for(UsuarioBean usuario:UsuarioDAO.getUsuarios()){
            %>
            <td><%= usuario.getNome() %></td>
            <td><%= usuario.getEmail() %></td>
            <td><%= usuario.getCodigoIdentificador() %></td>
            <td><%= usuario.getTipoUsuarioBean().getNivelAcesso() %></td>
            <%
                }
            %>
            <tr>
                <td></td>
            </tr>
        </table>
    </body>
</html>
