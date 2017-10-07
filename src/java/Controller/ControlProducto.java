/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Action.ActionProducto;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jefferson Palacios Torres | Correo: jefferson308@hotmail.com
 */
public class ControlProducto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        proccesRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        proccesRequest(request, response);
    }

    protected void proccesRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ActionProducto oActionInsertarProducto = new ActionProducto();
        List listaProductos = oActionInsertarProducto.listarProductos();
        request.setAttribute("listaProductos", listaProductos);

        request.getRequestDispatcher("Jsp/productos.jsp").forward(request, response);
    }

}
