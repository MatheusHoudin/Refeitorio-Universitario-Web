<%-- 
    Document   : manterCliente
    Created on : 01/06/2018, 16:24:48
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
        <form method="post" action="FrontController">
            Nome: <input name="nome" type="text">
            Matricula: <input name="matricula" type="number" minlength="8" maxlength="8">
            Email: <input name="email" type="email">
            Tipo do usuário:
            Administrador:<input type="radio" name="tipoUsuario" value="Administrador">
            Nutricionista:<input type="radio" name="tipoUsuario" value="Nutricionista">
            Funcionario:<input type="radio" name="tipoUsuario" value="Docente">
            Residente:<input type="radio" name="tipoUsuario" value="AlunoResidente">
            Aluno não residente:<input type="radio" name="tipoUsuario" value="AlunoNormal">
            <button name="command" value="CadastrarClienteCommand">Cadastrar</button>
        </form>
        
    </body>
</html>
