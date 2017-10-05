<%-- 
    Document   : index
    Created on : 30/09/2017, 03:56:23 AM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio</title>

        <script>

            function imprimirNombre() {
                var nombre = document.getElementById("nombre").value;
                alert(nombre);
            }
        </script>


        <script language="javascript">
            var kCode,sKey;
            function isMayus(input) {
                kCode = input.keyCode ? input.keyCode : input.which;
                sKey = input.shiftKey ? input.shiftKey : ((kCode == 16) ? true : false);
                if (((kCode >= 65 && kCode <= 90) && !sKey) || ((kCode >= 97 && kCode <= 122) && sKey))
                    alert('El Bloq Mayus está activado.');
            }
        </script>

    </head>
    <body>
        <h1>Productos!</h1>
        <input onkeypress="isMayus(event)" type="text" id="nombre" name="nombre" placeholder="Ingrese el nombre del producto">
        <div id="caplock" style=" visibility:hidden ">El bloqueo de mayúsculas está activado</div>
    </body>
</html>
