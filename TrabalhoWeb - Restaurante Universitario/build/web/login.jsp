<%-- 
    Document   : Login
    Created on : 06/05/2018, 16:44:26
    Author     : mathe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="Style/styleLogin.css">
	<title>Login</title>
</head>
<body> 

	<div id="premenu">
		<ul>
		<li id="Ru"> <img src="Imagens\logo.png" id="logoRu" alt="logo Ru" height="80" width="160"></li>
                </ul>
	</div>

	<div id="login" >
            <form id="formlogin" method="get" action="FrontController">
			<label for="lbllogin">Login</label>
                        <input type="text" name="login" id="lbllogin" placeholder="Digite seu usuário" required="">
			<br><br>
			<label for="lblsenha">Senha</label>
                        <input type="password" name="senha" id="lblsenha" placeholder="Digite sua senha" required="">
			<br><br>
                        <button  type="submit" name="command" value="LogarCommand">Entrar</button>
                        <button id="alterarSenha"  type="submit" name="command" value="alterar" >Alterar senha</button>
		</form>
	</div>

</body>
</html>