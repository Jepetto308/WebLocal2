/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import Dao.DaoProducto;
import Model.Producto;
import Utils.Conexion;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class ActionInsertarProducto {
    
    public boolean insertarProducto(Producto oProducto) throws FileNotFoundException{
        DaoProducto daoProducto = new DaoProducto();
        Conexion oConexion = new Conexion();
        Connection conn = oConexion.getConexion();
        daoProducto.insertarProducto(oProducto, conn);
        
        return oProducto.getIdProducto() > 0;
    }
    
    public Producto consultarProducto(Producto oProducto){
        DaoProducto daoProducto = new DaoProducto();
        Conexion oConexion = new Conexion();
        Connection conn = oConexion.getConexion();
        oProducto = daoProducto.consultarProducto(oProducto.getIdProducto(), conn);
        
        return oProducto;
    }
    
    public List listarProductos(){
        DaoProducto daoProducto = new DaoProducto();
        Conexion oConexion = new Conexion();
        Connection conn = oConexion.getConexion();
        List listaProductos = daoProducto.listarProductos(conn);
        
        return listaProductos;
    }
    
}
