<%-- 
    Document   : menu
    Created on : 7/10/2017, 10:50:54 AM
    Author     : Jefferson Palacios Torres | Correo: jefferson308@hotmail.com
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="Controller.ControlAccesoPages" %>
<%
    ControlAccesoPages oControlAccesoPages = new ControlAccesoPages();
    oControlAccesoPages.validatePemisions(request, response, 1);
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="Css/styleMenu.css">
        <title>Easy Inventory</title>
    </head>
    <c:set var="context" value="${pageContext.request.contextPath}" />
    <body>
        <header>
            <section class="wrapper">
                <nav>
                    <ul>
                        <li><a href="#">Inicio</a></li>
                        <li><a href="${context}/ControlProducto">Productos</a></li>
                        <li><a href="#">Facturas</a></li>
                        <li><a href="#">Reportes</a></li>
                        <li><a href="#">Contacto</a></li>
                        <li><a href="#">Logout</a></li>
                    </ul>
                </nav>
                <div class="infoUser">
                    <h3>Usuario: <c:out value="${user.nombre}"/> <c:out value="${user.apellidos}"/></h3>
                    <h3>Sucursal: Global | Rol: <c:out value="${user.nombreRol}"/></h3>
                </div>
            </section>
        </header>
    </body>
</html>
