/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;
import Model.Producto;
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
public class DaoProducto{
    
    Conexion oConexion = new Conexion();
    
    public Producto insertarProducto(Producto oProducto,Connection conexion) throws FileNotFoundException{
        FileInputStream fis = null;
        try {
            conexion.setAutoCommit(false);
            PreparedStatement ps = conexion.prepareStatement("INSERT INTO productos (nombre, cantidad, descripcion,imagen,rutaImg) VALUES (?,?,?,?,?)");
           
            File file = new File(oProducto.getRutaImg());
            fis = new FileInputStream(file);
            
            ps.setString(1, oProducto.getNombre());
            ps.setInt(2, oProducto.getCantidad());
            ps.setString(3, oProducto.getDescripcion());
            ps.setBinaryStream(4,fis,(int)file.length());
            ps.setString(5, oProducto.getRutaImg());
            
            ps.executeUpdate();
            
            conexion.commit();
            oProducto.setIdProducto(acountIdentifiquer());
        } catch (SQLException ex) {
            try {
                conexion.setAutoCommit(false);
                conexion.rollback();
                System.err.println("Error insertando el Producto: "+oProducto.getNombre());
                System.out.println(ex.getMessage());
            } catch (SQLException ex1) {
                Logger.getLogger(DaoProducto.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }finally{
            try {
                conexion.setAutoCommit(true);
                oConexion.cerrarConexion(conexion);
            } catch (SQLException ex) {
                Logger.getLogger(DaoProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return oProducto;
    }
    
    public Producto actualizarProducto(Producto oProducto,Connection conexion){
        try {
            conexion.setAutoCommit(false);
            PreparedStatement ps = conexion.prepareStatement("UPDATE productos SET nombre = ?,cantidad = ?,descripcion = ?");
            ps.setString(1, oProducto.getNombre());
            ps.setInt(2, oProducto.getCantidad());
            ps.setString(3, oProducto.getDescripcion());
            ps.executeUpdate();
            
            conexion.commit();
        } catch (SQLException ex) {
            try {
                conexion.rollback();
                System.err.println("Error actualizando el Producto: "+oProducto.getNombre());
                System.out.println(ex.getMessage());
            } catch (SQLException ex1) {
                Logger.getLogger(DaoProducto.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }finally{
            try {
                conexion.setAutoCommit(true);
                oConexion.cerrarConexion(conexion);
            } catch (SQLException ex) {
                Logger.getLogger(DaoProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return oProducto;
    }
    
    public List listarProductos(Connection conexion){
        List listaProductos = new ArrayList();
        try {
            Statement s = conexion.createStatement(); 
            ResultSet rs = s.executeQuery ("SELECT A.id_producto,A.nombre,A.cantidad,A.descripcion,A.imagen FROM productos A");
            while (rs.next()) 
            {       
                 Producto oProducto = new Producto();
                 oProducto.setIdProducto(rs.getInt(1));
                 oProducto.setNombre(rs.getString(2));
                 oProducto.setCantidad(rs.getInt(3));
                 oProducto.setDescripcion(rs.getString(4));
                 
                 Blob blob = rs.getBlob("imagen");
                 byte[] data = blob.getBytes(1, (int)blob.length());
                 BufferedImage img = null;
                try {
                    img = ImageIO.read(new ByteArrayInputStream(data));
                    oProducto.setImagen(img);
                } catch (IOException ex) {
                    Logger.getLogger(DaoProducto.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                listaProductos.add(oProducto);                
            }
        } catch (SQLException ex) {
            System.err.println("Error listando los Productos");
            System.out.println(ex.getMessage());
        }finally{
            oConexion.cerrarConexion(conexion);
        }
        return listaProductos;
    }
    
    public Producto consultarProducto(int idProducto,Connection conexion){
        Producto oProducto = new Producto();
        try {
            Statement s = conexion.createStatement(); 
            ResultSet rs = s.executeQuery ("SELECT A.id_producto,A.nombre,A.cantidad,A.descripcion,A.imagen FROM productos A WHERE A.id_producto = "+idProducto);
            while (rs.next()) 
            { 
                 oProducto.setIdProducto(rs.getInt(1));
                 oProducto.setNombre(rs.getString(2));
                 oProducto.setCantidad(rs.getInt(3));
                 oProducto.setDescripcion(rs.getString(4));
                 
                 Blob blob = rs.getBlob("imagen");
                 byte[] data = blob.getBytes(1, (int)blob.length());
                 BufferedImage img = null;
                try {
                    img = ImageIO.read(new ByteArrayInputStream(data));
                    oProducto.setImagen(img);
                } catch (IOException ex) {
                    Logger.getLogger(DaoProducto.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            System.err.println("Error consultando el Producto con ID: "+idProducto);
            System.out.println(ex.getMessage());
        }finally{
            oConexion.cerrarConexion(conexion);
        }
        return oProducto;
    }
    
    public int acountIdentifiquer(){
        
        int idProducto = 0;
        Conexion oConexion = new Conexion();
        Connection conexion = oConexion.getConexion();
        try {
            Statement s = conexion.createStatement(); 
            ResultSet rs = s.executeQuery ("SELECT MAX(A.id_producto) FROM productos A");
            while (rs.next()) 
            { 
                idProducto = rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.err.println("Error obteniendo el autoincrementable de Producto: ");
            System.out.println(ex.getMessage());
        }finally{
            oConexion.cerrarConexion(conexion);
        }
        return idProducto;
    }
    
    
    
}
