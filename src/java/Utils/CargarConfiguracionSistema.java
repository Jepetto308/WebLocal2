/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.util.HashMap;
import java.util.Map;
import Action.ActionParametros;
import Model.Parametro;
import java.util.List;

/**
 *
 * @author Jefferson Palacios Torres
 */
public class CargarConfiguracionSistema {
    public final Map parametrosConfiguracion;

    public CargarConfiguracionSistema() {
        this.parametrosConfiguracion = cargarParametros();
    }
    
    public Map cargarParametros(){
        ActionParametros oActionParametros = new ActionParametros();
        List listaParametros = oActionParametros.listarParametros();
        Map aux = new HashMap();
        for(int i=0;i<listaParametros.size();i++){
            Parametro oParametro = (Parametro) listaParametros.get(i);
            aux.put(oParametro.getCodigo(), oParametro.getValor());
        }
        return aux;
    }
    
}
