<%-- 
    Document   : index
    Created on : 06/05/2018, 16:45:31
    Author     : mathe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>

<title> TelaPrincipal </title>
<script language="Javascript">
	
	function preload(){
		imgs=Array('Imagens/img11.png','Imagens/img12.png','Imagens/img13.png','Imagens/img14.png');
		imgQtde=imgs.length;
		for(i=0;i<imgQtde;i++){
			var preloadimg = new Image();
			preloadimg.scr = imgs[i];
		}

	}

	function iniciaSlider(){
		preload();
		max=14;
		min=11;
		fi = min;
		tr= true;
		Carregafoto("Imagens/img11.png");
		document.getElementById("moldura").addEventListener("transitionend",fimTr);
	}

	function fimTr(){
		tr=true;
	}


	function Carregafoto(foto){
		document.getElementById("moldura").style.backgroundImage="URL("+foto+")";
	}

	function prox(){
		if(tr){
			tr=false;
			fi++;
			if(fi>max){
				fi=min;
			}
			Carregafoto("Imagens/img"+fi+".png");
		}
	}

	function ant(){
		if(tr){
			tr=false;
			fi--;
			if(fi<min){
				fi=max;
			}
			Carregafoto("Imagens/img"+fi+".png");
		}
	}





</script>

<link rel="stylesheet" href="Style/style.css" type="text/css">
		
</head>



<body onload="iniciaSlider()">

	 <ul id="premenu">
             <li id="acesso">  <a href="FrontController?command=LoginCommand" ><input type="image" src="Imagens/img10.png" class="logoufc" alt="Self Service" height="40" width="100"></a> </li>
	 </ul>

	 <img src="Imagens/img9.png" class="logoufc" alt="Self Service">	<br><br>
	
    <div id="menu">

    <ul>
    	<li> <a href="#"><h1 id="Nomelogo"> Restaurante Universitario </h1> </a></li>
    	<li> <a href="#ligacao1"> Conheça o RU </a> </li>
    	<li> <a href="#ligacao2"> Cardapio</a> </li>
    	<li> <a href="#ligacao3"> Informações Gerais </a> </li>
    	<li id="idcontato"> <a href="#ligacao4"> Contato </a> </li>
   		
    </ul>
	</div> <br><br>

	<div id="moldura" onclick="prox()"> 	

	</div>

	<br>
	<br>
	




	<div id="informacao">
       
         <h1><A name="ligacao1">Conheça o Restaurante Universitario</A></h1> <br>
         <p> 	O Restaurante Universitário, sob a coordenação da Pró-Reitoria de Assuntos Estudantis,<br> é uma unidade destinada a oferecer refeições de qualidade a estudantes, docentes e servidores<br> técnico-administrativos da UFC, além de constituir um espaço de convivência e integração <br>da comunidade universitária.<br>

O atendimento do Restaurante Universitário abrange uma parcela dos estudantes<br> que buscam economizar tempo e dinheiro em deslocamento. Atualmente, são fornecidas cerca de 15.000<br> refeições por dia, distribuídas nos Refeitórios de Fortaleza (Campus do Pici I e II, Campus do Benfica, <br>Campus do Porangabuçu e Labomar), Sobral, Quixadá, Russas e Crateús.<br> São oferecidas diariamente três refeições: café da manhã (apenas para residentes), almoço e jantar.</p>

       	<img src="Imagens/img7.png" alt="Self Service" height="280" width="650"> 
       	

  
        <br><br><br><br><br><br>
       
        <h1><A name="ligacao2"> Cardapio</A></h1> <br>
       	
       		<p> Os cardápios do RU são elaborados por nutricionistas. <br>
       			em todas as refeições oferecemos a opção vegana <br>
       			</p>
       			<a href="file://C:/Users/Snipes/Desktop/ExerciciosWeb/TrabalhoWeb/TelaInicial/pdf1.pdf"><h3> Clique aqui para consultar o Cardapio </h3> </a>
       			

	
	   <br><br><br>       
		<h1><A name="ligacao3">Informações Gerais</A></h1><br>
        <h3>Horario de funcionamento</h3><br>
        <p> Café da manhã (somente para Residentes): das 06h15min às 08h<br>
			Almoço: das 11h às 14h<br>
			Jantar: das 17h às 19h30min<br>
			Recarga de cartões: das 08h às 19h25min<br>
		</p><br>
		<h3>Valor das refeições</h3><br>
		<p> Estudante: R$ 1,10<br>
			<img src="Imagens/img8.png" id="img2" alt="Self Service" height="320" width="380">
			Servidor técnico–administrativo: R$ 7,00<br>
			Docente: R$ 7,00</p><br>
			
		<h3>Publico Alvo</h3><br>

		<p> Estudantes, servidores técnico–administrativos, docentes e pessoal a serviço da <br>UFC de empresas terceirizadas contratadas.
			Além das categorias acima descritas,<br> também podem solicitar o acesso aos Refeitórios<br> participantes de eventos realizados pela UFC 
(congressos, encontro de estudantes,<br> cursos, etc.), desde que estejam vinculados a outras Instituições Federais de Ensino <br>Superior, 
pesquisadores que estejam desenvolvendo algum trabalho em parceria com a<br> Universidade, bolsistas de projetos, dentre outros,
 desde que formalizem a solicitação<br> através do envio de um ofício para a Pró-Reitoria de Assuntos Estudantis<br>.
</p><br>
		<h3> Acesso ao RU</h3><br>
		<p> O acesso às refeições do RU é realizado com o cartão eletrônico (que pode ser<br> recarregado com GRU) ou 
através da compra de tickets.</p><br><br>



        <h1><A name="ligacao4">Nosso Contato</A></h1><br>
        <p> Av.da Universidade,2853-Benfica,Fortaleza-CE,CEP 60020-181 <br>
        	Fone: +85(00)0000-0000</p> <a href="" id="referencia">Ver Mapa</a><br>

	</div>

</body>





</html>