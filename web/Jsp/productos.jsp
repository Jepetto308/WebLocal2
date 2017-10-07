<%-- 
    Document   : inicio
    Created on : 5/10/2017, 09:27:11 PM
    Author     : Jefferson Palacios Torres | Correo: jefferson308@hotmail.com
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>Bienvenido: <c:out value = "${username.nombre}"/></h3>
        <h1>Productos</h1>
        <table>
                <tr>
                    <td>Nombre</td>
                    <td>Cantidad</td>
                    <td>Descripcion</td>
                </tr>
                <c:forEach items="${listaProductos}" var="obj">
                    <tr>
                        <td><c:out value = "${obj.nombre}"/></td>
                        <td><c:out value = "${obj.cantidad}"/></td>
                        <td><c:out value = "${obj.descripcion}"/></td>
                    </tr>
                </c:forEach>
        </table>
    </body>
</html>
