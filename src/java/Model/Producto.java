/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.awt.Image;

/**
 *
 * @author ASUS
 */
public class Producto {
    
    private int idProducto;
    private String nombre;
    private int cantidad;
    private String descripcion;
    private Image imagen;
    private String rutaImg;
    
    public Producto(int idProducto,String nombre,int cantidad,String descripcion,String rutaImg){
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.rutaImg = rutaImg;
    }
    
    public Producto(){
        this.idProducto = 0;
        this.nombre = "";
        this.cantidad = 0;
        this.descripcion = "";
        this.rutaImg = "";
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getRutaImg() {
        return rutaImg;
    }

    public void setRutaImg(String rutaImg) {
        this.rutaImg = rutaImg;
    }
    
    public Image getImagen() {
        return imagen;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }
}
