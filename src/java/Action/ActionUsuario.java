/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import Dao.DaoProducto;
import Dao.DaoUsuario;
import Model.Producto;
import Model.Usuario;
import Utils.Conexion;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Jeferson Palacios Torres | Correo: jefferson308@hotmail.com
 */
public class ActionUsuario {
    
    private DaoUsuario daoUsuario = new DaoUsuario();
    private Usuario oUsuario = new Usuario();
    Conexion oConexion = new Conexion();
    
    public boolean insertarUsuario(Usuario oUsuario) throws FileNotFoundException{
        Connection conn = oConexion.getConexion();
        return daoUsuario.insertarUsuario(oUsuario, conn);
   }
    
    public Usuario consultarUsuario(String numeroIdentificacion){
        Connection conn = oConexion.getConexion();
        oUsuario = daoUsuario.consultarUsuario(numeroIdentificacion, conn);
        
        return oUsuario;
    }
    
    public List listarUsuarios(){
        Connection conn = oConexion.getConexion();
        List listaUsuarios = daoUsuario.listarUsuarios(conn);
        
        return listaUsuarios;
    }
    
    public boolean existeUsuarioByNumeroIdentificacion(String numeroIdentificacion){
        return daoUsuario.existeUsuarioConNumeroIdentificacion(numeroIdentificacion);
    }
    
    public boolean existeUsuarioByUsername(String username){
        return daoUsuario.existeUsuarioConUsername(username);
    }
    
    public Usuario login(String username,String password){
        Connection conn = oConexion.getConexion();
        oUsuario = daoUsuario.login(username, password, conn);
        return oUsuario;
    }   
    
}
