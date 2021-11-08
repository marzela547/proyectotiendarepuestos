/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author fgodo
 */
public class CacheProveedor {
    private static boolean DatosCompartidos = false;
    private static ProveedorModelo proveedor;
    public static Integer Procodigo; 

    public boolean isDatosCompartidos() {
        return DatosCompartidos;
    }

    public  void setDatosCompartidos(boolean DatosCompartidos) {
        CacheProveedor.DatosCompartidos = DatosCompartidos;
    }

    public  ProveedorModelo getProveedor() {
        return proveedor;
    }

    public void setProveedor(ProveedorModelo Procodigo) {
        CacheProveedor.proveedor = Procodigo;
    }

    public static Integer getProcodigo() {
        return Procodigo;
    }

    public static void setProcodigo(Integer Procodigo) {
        CacheProveedor.Procodigo = Procodigo;
    }


    
    
    
}
