
package Controller;

import Model.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jefferson Palacios Torres | Correo: jefferson308@hotmail.com
 */
public class ControlAccesoPages extends HttpServlet {

    public void validatePemisions(HttpServletRequest request, HttpServletResponse response,int codigoRol)
            throws ServletException, IOException {
        HttpSession objSesion = request.getSession(false);
        Usuario oUsuario;
        
        if (objSesion == null || objSesion.getAttribute("user") == null) {
            request.getRequestDispatcher("noLogin.jsp").forward(request, response);
        } else {
            oUsuario = (Usuario) objSesion.getAttribute("user");
            request.setAttribute("user", oUsuario);
            // 2 Rol: Auxiliar
            if (oUsuario.getCodigoRol() > codigoRol) {
                request.getRequestDispatcher("noPermisin.jsp").forward(request, response);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

}
