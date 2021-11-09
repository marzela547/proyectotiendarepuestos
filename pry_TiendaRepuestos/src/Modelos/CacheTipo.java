/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author marce
 */
public class CacheTipo {
    private static boolean DatosCompartidos = false;
    private static TiposModelo tipo;
    public static Integer Tipcodigo;

    public static boolean isDatosCompartidos() {
        return DatosCompartidos;
    }

    public static void setDatosCompartidos(boolean DatosCompartidos) {
        CacheTipo.DatosCompartidos = DatosCompartidos;
    }

    public static TiposModelo getTipo() {
        return tipo;
    }

    public static void setTipo(TiposModelo tipo) {
        CacheTipo.tipo = tipo;
    }

    public static Integer getTipcodigo() {
        return Tipcodigo;
    }

    public static void setTipcodigo(Integer Tipcodigo) {
        CacheTipo.Tipcodigo = Tipcodigo;
    }
    
    
}
