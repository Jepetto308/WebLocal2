/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import Dao.DaoParametros;
import Dao.DaoProducto;
import Model.Parametro;
import Model.Producto;
import Utils.Conexion;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class ActionParametros {
    
    public boolean actualizarParametro(Parametro oParametro) throws FileNotFoundException{
        DaoParametros daoParametros = new DaoParametros();
        Conexion oConexion = new Conexion();
        Connection conn = oConexion.getConexion();
        return daoParametros.actualizarParametro(oParametro, conn);
    }
    
    public Parametro consultarParametro(String codigo){
        DaoParametros daoParametros = new DaoParametros();
        Conexion oConexion = new Conexion();
        Connection conn = oConexion.getConexion();
        Parametro oParametro = daoParametros.consultarParametro(codigo, conn);
        
        return oParametro;
    }
    
    public List listarParametros(){
        DaoParametros daoParametros = new DaoParametros();
        Conexion oConexion = new Conexion();
        Connection conn = oConexion.getConexion();
        List listaParametros = daoParametros.listarParametros(conn);
        
        return listaParametros;
    }
    
}
