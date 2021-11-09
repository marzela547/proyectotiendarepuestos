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
public class CacheMarca {
    private static boolean DatosCompartidos = false;
    private static MarcasModelo marca;
    public static Integer Marcodigo;

    public static boolean isDatosCompartidos() {
        return DatosCompartidos;
    }

    public static void setDatosCompartidos(boolean DatosCompartidos) {
        CacheMarca.DatosCompartidos = DatosCompartidos;
    }

    public static MarcasModelo getMarca() {
        return marca;
    }

    public static void setMarca(MarcasModelo marca) {
        CacheMarca.marca = marca;
    }

    public static Integer getMarcodigo() {
        return Marcodigo;
    }

    public static void setMarcodigo(Integer Marcodigo) {
        CacheMarca.Marcodigo = Marcodigo;
    }
    
    
}
