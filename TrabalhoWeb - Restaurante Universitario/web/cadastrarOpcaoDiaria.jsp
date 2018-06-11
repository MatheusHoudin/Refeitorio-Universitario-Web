<%-- 
    Document   : cadastrarOpcaoDiaria
    Created on : 11/06/2018, 08:12:29
    Author     : mathe
--%>

<%@page import="dao.OpcaoComidaDAO"%>
<%@page import="java.util.List"%>
<%@page import="modelo.bean.OpcaoComidaBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="get" action="FrontController">
            Data: <input type="date" name="data">
            Turno: 
            <select name="turno">
                <option value="manhã">Manhã</option>
                <option value="noite" >Noite</option>
            </select>
            Principal:
            <select name="principal">
                <%
                    List<OpcaoComidaBean> principal = OpcaoComidaDAO.getOpcaoComidaBeanPorCategoria("principal");
                    for(OpcaoComidaBean opc:principal){
                %>
                <option value="<%= opc.getId() %>"><%= opc.getNomeComida() %></option>
                <%
                    }
                %>
            </select>
            Secundario:
            <select name="secundario">
                <%
                    List<OpcaoComidaBean> secundario = OpcaoComidaDAO.getOpcaoComidaBeanPorCategoria("secundario");
                    for(OpcaoComidaBean opc:secundario){
                %>
                <option value="<%= opc.getId() %>"><%= opc.getNomeComida() %></option>
                <%
                    }
                %>
            </select>
            Vegetariano:
            <select name="vegetarianno">
                <%
                    List<OpcaoComidaBean> vegetariano = OpcaoComidaDAO.getOpcaoComidaBeanPorCategoria("vegetariano");
                    for(OpcaoComidaBean opc:vegetariano){
                %>
                <option value="<%= opc.getId() %>"><%= opc.getNomeComida() %></option>
                <%
                    }
                %>
            </select>
            Acompanhamento:
            <select name="acompanhamento">
                <%
                    List<OpcaoComidaBean> acompanhamento = OpcaoComidaDAO.getOpcaoComidaBeanPorCategoria("acompanhamento");
                    for(OpcaoComidaBean opc:acompanhamento){
                %>
                <option value="<%= opc.getId() %>"><%= opc.getNomeComida() %></option>
                <%
                    }
                %>
            </select>
            Guarnição:
            <select name="guarnicao">
                <%
                    List<OpcaoComidaBean> guarnicao = OpcaoComidaDAO.getOpcaoComidaBeanPorCategoria("guarnicao");
                    for(OpcaoComidaBean opc:guarnicao){
                %>
                <option value="<%= opc.getId() %>"><%= opc.getNomeComida() %></option>
                <%
                    }
                %>
            </select>
            Sobremesa:
            <select name="sobremesa">
                <%
                    List<OpcaoComidaBean> sobremesa = OpcaoComidaDAO.getOpcaoComidaBeanPorCategoria("sobremesa");
                    for(OpcaoComidaBean opc:sobremesa){
                %>
                <option value="<%= opc.getId() %>"><%= opc.getNomeComida() %></option>
                <%
                    }
                %>
            </select>
            Bebida:
            <select name="bebida">
                <%
                    List<OpcaoComidaBean> bebida = OpcaoComidaDAO.getOpcaoComidaBeanPorCategoria("bebida");
                    for(OpcaoComidaBean opc:bebida){
                %>
                <option value="<%= opc.getId() %>"><%= opc.getNomeComida() %></option>
                <%
                    }
                %>
            </select>
        </form>
    </body>
</html>
