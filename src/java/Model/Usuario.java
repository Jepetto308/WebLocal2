/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Image;

/**
 *
 * @author Jefferson Palacios Torres | Correo: jefferson308@hotmail.com
 */
public class Usuario {

    private String numeroIdentificacion;
    private String nombre;
    private String apellidos;
    private String username;
    private String telefono;
    private Image fotoPerfil;  
    private String rutaImg;
    private String password;
    
    public Usuario(String numeroIdentificacion,String nombre,String apellidos,String username,String telefono,Image fotoPerfil,String rutaImg,String password){
        this.numeroIdentificacion = numeroIdentificacion;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.username = username;
        this.telefono = telefono;
        this.fotoPerfil = fotoPerfil;
        this.rutaImg = rutaImg;
        this.password = password;
    }
    
    public Usuario(){
        this.numeroIdentificacion = "";
        this.nombre = "";
        this.apellidos = "";
        this.username = "";
        this.telefono = "";
        this.fotoPerfil = null;
        this.rutaImg = "";
        this.password = "";
    }
    
    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public Image getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(Image fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }
    
    public String getRutaImg() {
        return rutaImg;
    }

    public void setRutaImg(String rutaImg) {
        this.rutaImg = rutaImg;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
