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
public class CachePuesto {
    private static boolean DatosCompartidos = false;
    private static PuestoModelo puesto;
    public static Integer Puecodigo;
    
    public boolean isDatosCompartidos() {
        return DatosCompartidos;
    }

    public static void setDatosCompartidos(boolean DatosCompartidos) {
        CachePuesto.DatosCompartidos = DatosCompartidos;
    }


    public PuestoModelo getPuesto() {
        return puesto;
    }

    public void setPuesto(PuestoModelo Pueid) {
        CachePuesto.puesto = Pueid;
    }

    public static Integer getPuecodigo() {
        return Puecodigo;
    }

    public static void setPuecodigo(Integer Puecodigo) {
        CachePuesto.Puecodigo = Puecodigo;
    }

    
}


