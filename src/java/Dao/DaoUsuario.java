/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;
import Model.Producto;
import Model.Usuario;
import Utils.Conexion;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
/**
 *
 * @author ASUS
 */
public class DaoUsuario{
    
    Conexion oConexion = new Conexion();
    
    public boolean insertarUsuario(Usuario oUsuario,Connection conexion) throws FileNotFoundException{
        FileInputStream fis = null;
        boolean exito = false;
        try {
            conexion.setAutoCommit(false);
            PreparedStatement ps = conexion.prepareStatement("INSERT INTO usuarios (numero_identificacion, nombre, apellidos, username,"
                    + "telefono,foto_perfil,password) VALUES (?,?,?,?,?,?,?)");
           
            File file = new File(oUsuario.getRutaImg());
            fis = new FileInputStream(file);
            
            ps.setString(1, oUsuario.getNumeroIdentificacion());
            ps.setString(2, oUsuario.getNombre());
            ps.setString(3, oUsuario.getApellidos());
            ps.setString(4, oUsuario.getUsername());
            ps.setString(5, oUsuario.getTelefono());
            ps.setBinaryStream(6,fis,(int)file.length());
            ps.setString(7, oUsuario.getPassword());
            
            ps.executeUpdate();
            
            conexion.commit();
            exito = true;
        } catch (SQLException ex) {
            try {
                conexion.setAutoCommit(false);
                conexion.rollback();
                System.err.println("Error insertando el Usuario: "+oUsuario.getNombre());
                System.out.println(ex.getMessage());
            } catch (SQLException ex1) {
                Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }finally{
            try {
                conexion.setAutoCommit(true);
                oConexion.cerrarConexion(conexion);
            } catch (SQLException ex) {
                Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return exito;
    }
    
    public boolean actualizarUsuario(Usuario oUsuario,Connection conexion) throws FileNotFoundException{
        FileInputStream fis = null;
        boolean exito = false;
        try {
            conexion.setAutoCommit(false);
            PreparedStatement ps = conexion.prepareStatement("UPDATE usuarios SET nombre = ?,apellidos = ?,telefono = ?, foto_perfil = ?");
            File file = new File(oUsuario.getRutaImg());
            fis = new FileInputStream(file);
            
            ps.setString(1, oUsuario.getNombre());
            ps.setString(2, oUsuario.getApellidos());
            ps.setString(3, oUsuario.getTelefono());
            ps.setBinaryStream(4,fis,(int)file.length());
            ps.executeUpdate();
            
            conexion.commit();
            exito = true;
        } catch (SQLException ex) {
            try {
                conexion.rollback();
                System.err.println("Error actualizando el Usuario: "+oUsuario.getNombre());
                System.out.println(ex.getMessage());
            } catch (SQLException ex1) {
                Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }finally{
            try {
                conexion.setAutoCommit(true);
                oConexion.cerrarConexion(conexion);
            } catch (SQLException ex) {
                Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return exito;
    }
    
    public List listarUsuarios(Connection conexion){
        List listaUsuarios = new ArrayList();
        try {
            Statement s = conexion.createStatement(); 
            ResultSet rs = s.executeQuery ("SELECT A.numero_identificacion,A.nombre,A.apellidos,A.username,A.telefono FROM productos A");
            while (rs.next()) 
            {       
                 Usuario oUsuario = new Usuario();
                 oUsuario.setNumeroIdentificacion(rs.getString(1));
                 oUsuario.setNombre(rs.getString(2));
                 oUsuario.setApellidos(rs.getString(3));
                 oUsuario.setUsername(rs.getString(4));
                 oUsuario.setTelefono(rs.getString(5));
                
                listaUsuarios.add(oUsuario);                
            }
        } catch (SQLException ex) {
            System.err.println("Error listando los Usuarios");
            System.out.println(ex.getMessage());
        }finally{
            oConexion.cerrarConexion(conexion);
        }
        return listaUsuarios;
    }
    
    public Usuario consultarUsuario(String numeroIdentificacion,Connection conexion){
        Usuario oUsuario = new Usuario();
        try {
            Statement s = conexion.createStatement(); 
            ResultSet rs = s.executeQuery ("SELECT A.numero_identificacion,A.nombre,A.apellidos,A.username,A.telefono,A.foto_perfil FROM usuarios A WHERE A.numero_identificacion = '"+numeroIdentificacion+"'");
            while (rs.next()) 
            { 
                 oUsuario.setNumeroIdentificacion(rs.getString(1));
                 oUsuario.setNombre(rs.getString(2));
                 oUsuario.setApellidos(rs.getString(3));
                 oUsuario.setUsername(rs.getString(4));
                 oUsuario.setTelefono(rs.getString(5));
                 
                 Blob blob = rs.getBlob(6);
                 byte[] data = blob.getBytes(1, (int)blob.length());
                 BufferedImage img = null;
                try {
                    img = ImageIO.read(new ByteArrayInputStream(data));
                    oUsuario.setFotoPerfil(img);
                } catch (IOException ex) {
                    Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            System.err.println("Error consultando el Usuario con Numero Identificacion: "+numeroIdentificacion);
            System.out.println(ex.getMessage());
        }finally{
            oConexion.cerrarConexion(conexion);
        }
        return oUsuario;
    }
    
    public boolean existeUsuarioConNumeroIdentificacion(String numeroIdentificacion){
        
        String numeroDocumento = "";
        Conexion oConexion = new Conexion();
        Connection conexion = oConexion.getConexion();
        try {
            Statement s = conexion.createStatement(); 
            ResultSet rs = s.executeQuery ("SELECT A.numero_identificacion FROM usuarios A WHERE A.numero_identificacion = '"+numeroIdentificacion+"' LIMIT 1");
            while (rs.next()) 
            { 
                numeroDocumento = rs.getString(1);
            }
        } catch (SQLException ex) {
            System.err.println("Error validando existencia del Usuario con Numero de identificacion: "+numeroIdentificacion);
            System.out.println(ex.getMessage());
        }finally{
            oConexion.cerrarConexion(conexion);
        }
        return !"".equals(numeroDocumento);
    }
    
    public boolean existeUsuarioConUsername(String username){
        
        String usuario = "";
        Conexion oConexion = new Conexion();
        Connection conexion = oConexion.getConexion();
        try {
            Statement s = conexion.createStatement(); 
            ResultSet rs = s.executeQuery ("SELECT A.username FROM usuarios A WHERE A.username = '"+username+"' LIMIT 1");
            while (rs.next()) 
            { 
                usuario = rs.getString(1);
            }
        } catch (SQLException ex) {
            System.err.println("Error validando existencia del Usuario con Usuario: "+username);
            System.out.println(ex.getMessage());
        }finally{
            oConexion.cerrarConexion(conexion);
        }
        return !"".equals(usuario);
    }
    
    public Usuario login(String username,String password,Connection conexion){
        Usuario oUsuario = new Usuario();
        try {
            Statement s = conexion.createStatement(); 
            ResultSet rs = s.executeQuery ("SELECT A.numero_identificacion,A.nombre,A.apellidos,A.username,A.telefono,A.foto_perfil FROM usuarios A WHERE A.username = '"+username+"' AND A.password = '"+password+"'");
            while (rs.next()) 
            { 
                 oUsuario.setNumeroIdentificacion(rs.getString(1));
                 oUsuario.setNombre(rs.getString(2));
                 oUsuario.setApellidos(rs.getString(3));
                 oUsuario.setUsername(rs.getString(4));
                 oUsuario.setTelefono(rs.getString(5));
                 
                 Blob blob = rs.getBlob(6);
                 byte[] data = blob.getBytes(1, (int)blob.length());
                 BufferedImage img = null;
                try {
                    img = ImageIO.read(new ByteArrayInputStream(data));
                    oUsuario.setFotoPerfil(img);
                } catch (IOException ex) {
                    Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            System.err.println("Error validando el Usuario con Usuario: "+username);
            System.out.println(ex.getMessage());
        }finally{
            oConexion.cerrarConexion(conexion);
        }
        return oUsuario;
    }
    
}
