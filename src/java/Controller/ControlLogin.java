
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Action.ActionUsuario;
import Model.Usuario;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jefferson Palacios Torres | Correo: jefferson308@hotmail.com
 */
public class ControlLogin extends HttpServlet {
    
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
       
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            
            ActionUsuario oActionUsuario = new ActionUsuario();
            Usuario oUsuario = oActionUsuario.login(username, password);            
            HttpSession objSesion = request.getSession(true); 
            objSesion.setAttribute("user", oUsuario );
            
            if("".equals(oUsuario.getUsername())){
                response.getWriter().print(true);
            }
    }
}
