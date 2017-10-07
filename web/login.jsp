<%-- 
    Document   : index
    Created on : 30/09/2017, 03:56:23 AM
    Author     : Jefferon Palacios Torres
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%-- <%
  response.sendRedirect("Jsp/inicio.jsp");
%> --%>
<!DOCTYPE html>
<html>
    <head>
        <title>Inicio de sesión</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
        <!-- vinculo a bootstrap -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <!-- Temas-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
        <!-- se vincula al hoja de estilo para definir el aspecto del formulario de login-->  
        <link rel="stylesheet" type="text/css" href="Css/styleLogin.css">
        <!-- vinculando a libreria Jquery-->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <!-- Libreria java scritp de bootstrap -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <script src="Js/loginJs.js"></script>

    </head>
    <body>
        <c:set var="context" value="${pageContext.request.contextPath}" />
        <input type="hidden" name="contexto" id="contexto" value="${context}"/>
        <script>var contexto = $("#contexto").val();</script>

        <div id="Contenedor">
            <div class="Icon">
                <!--Icono de usuario-->
                <span class="glyphicon glyphicon-user"></span>
            </div>
            <div class="mensajeError">
                <span>Datos Incorrectos</span>
            </div>
            <div class="ContentForm">
                <form action="/ControlLogin" method="post" name="FormEntrar">
                    <div class="input-group input-group-lg">
                        <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-envelope"></i></span>
                        <input type="text" class="form-control" name="username" placeholder="Usuario" id="username" aria-describedby="sizing-addon1" required>
                    </div>
                    <br>
                    <div class="input-group input-group-lg">
                        <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-lock"></i></span>
                        <input type="password" name="password" id="password" class="form-control" placeholder="******" aria-describedby="sizing-addon1" required>
                    </div>
                    <br>
                    <button class="btn btn-lg btn-primary btn-block btn-signin" id="IngresoLog" type="button">Entrar</button>
                    <div class="opcioncontra"><a href="">Olvidaste tu contraseña?</a></div>
                </form>
            </div>	
        </div>
    </body>
</html>
