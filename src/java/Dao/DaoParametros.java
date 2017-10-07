/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;
import Model.Parametro;
import Utils.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Jefferson Palacios Torres
 */
public class DaoParametros{
    
    Conexion oConexion = new Conexion();
   
    
    public boolean actualizarParametro(Parametro oParametro,Connection conexion){
        boolean exito = false;
        try {
            conexion.setAutoCommit(false);
            Timestamp oDate = new Timestamp(System.currentTimeMillis());
            PreparedStatement ps = conexion.prepareStatement("UPDATE parametros SET valor = ?,"
                    + "fecha_modificacion = ?,usuario_modificacion = ? WHERE codigo = '"+oParametro.getCodigo()+"'");
            ps.setString(1, oParametro.getValor());
            ps.setTimestamp(2, oDate);
            ps.setString(3, oParametro.getUsuarioModificacion());
            ps.executeUpdate();
            
            conexion.commit();
            exito = true;
        } catch (SQLException ex) {
            try {
                conexion.rollback();
                System.err.println("Error actualizando el Parametro: "+oParametro.getCodigo());
                System.out.println(ex.getMessage());
            } catch (SQLException ex1) {
                Logger.getLogger(DaoParametros.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }finally{
            try {
                conexion.setAutoCommit(true);
                oConexion.cerrarConexion(conexion);
            } catch (SQLException ex) {
                Logger.getLogger(DaoParametros.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return exito;
    }
    
    public List listarParametros(Connection conexion){
        List listaParametros = new ArrayList();
        try {
            Statement s = conexion.createStatement(); 
            ResultSet rs = s.executeQuery ("SELECT A.codigo,A.valor,A.fecha_modificacion,A.usuario_modificacion FROM parametros A");
            while (rs.next()) 
            {       
                 Parametro oParametro = new Parametro();
                 oParametro.setCodigo(rs.getString(1));
                 oParametro.setValor(rs.getString(2));
                 oParametro.setFechaModificacion(rs.getTimestamp(3));
                 oParametro.setUsuarioModificacion(rs.getString(4));
                                 
                 listaParametros.add(oParametro);                
            }
        } catch (SQLException ex) {
            System.err.println("Error listando los Parametros");
            System.out.println(ex.getMessage());
        }finally{
            oConexion.cerrarConexion(conexion);
        }
        return listaParametros;
    }
    
    public Parametro consultarParametro(String codigo,Connection conexion){
        Parametro oParametro = new Parametro();
        try {
            Statement s = conexion.createStatement(); 
            ResultSet rs = s.executeQuery ("SELECT A.codigo,A.valor,A.fecha_modificacion,A.usuario_modificacion FROM parametros A where A.codigo LIKE '"+codigo+"%'");
            while (rs.next()) 
            {       
                 oParametro.setCodigo(rs.getString(1));
                 oParametro.setValor(rs.getString(2));
                 oParametro.setFechaModificacion(rs.getTimestamp(3));
                 oParametro.setUsuarioModificacion(rs.getString(4));
            }
        } catch (SQLException ex) {
            System.err.println("Error consultando el Parametro con Codigo: "+codigo);
            System.out.println(ex.getMessage());
        }finally{
            oConexion.cerrarConexion(conexion);
        }
        return oParametro;
    }
        
}
