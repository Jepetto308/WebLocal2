/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    private static Connection conexion = null;
    private static String servidor = "127.0.0.1";
    private static String database = "inventario";
    private static String usuario = "root";
    private static String password = "";
    private static String url = "";

    public void conectar(String servidor, String database, String usuario, String password) {
        try {

            this.servidor = servidor;
            this.database = database;

            Class.forName("com.mysql.jdbc.Driver");
            url = "jdbc:mysql://" + servidor + "/" + database;
            conexion = DriverManager.getConnection(url, usuario, password);
            System.out.println("Conexion a Base de Datos " + url + " . . . . .Ok");

        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
    }

    public Connection getConexion() {
        conectar(servidor, database, usuario, password);
        return conexion;
    }

    public Connection cerrarConexion(Connection conn) {
        try {
            if(conexion != null){
                conexion.close();
            }
            System.out.println("Cerrando conexion a " + url + " . . . . . Ok");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        conexion = null;
        return conexion;
    }

    public static void main(String[] args) {
//        Conexion cls = new Conexion();
//        cls.conectar("127.0.0.1", "inventario", "root", "");
//        try {
//            PreparedStatement ps = conexion.prepareStatement("INSERT INTO productos (nombre, cantidad, descripcion) VALUES ('Arroz',1,'Arroz Diana por lb')");
//            ps.executeUpdate();
//        } catch (SQLException ex) {
//            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

}
