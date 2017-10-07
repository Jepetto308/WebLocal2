/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.sql.Timestamp;

/**
 *
 * @author ASUS
 */
public class Parametro {
    
    private String codigo;
    private String valor;
    private Timestamp fechaModificacion;
    private String usuarioModificacion;
    
    public void Parametros(String codigo,String valor, Timestamp fechaModificacion, String usuarioModificacion){
        this.codigo = codigo;
        this.valor = valor;
        this.fechaModificacion = fechaModificacion;
        this.usuarioModificacion = usuarioModificacion;
    }
    
    public void Parametros(){
        this.codigo = "";
        this.valor = "";
        this.fechaModificacion = null;
        this.usuarioModificacion = "";
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Timestamp getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Timestamp fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(String usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }
         
    
}
