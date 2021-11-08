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
public class CacheContacto {
     private static boolean DatosCompartidos = false;
    private static ContactoModelo contacto;
    public static Integer Concodigo;

    public  boolean isDatosCompartidos() {
        return DatosCompartidos;
    }

    public  void setDatosCompartidos(boolean DatosCompartidos) {
        CacheContacto.DatosCompartidos = DatosCompartidos;
    }

    public  ContactoModelo getContacto() {
        return contacto;
    }

    public  void setContacto(ContactoModelo Concodigo) {
        CacheContacto.contacto = Concodigo;
    }

    public static Integer getConcodigo() {
        return Concodigo;
    }

    public static void setConcodigo(Integer Concodigo) {
        CacheContacto.Concodigo = Concodigo;
    }
   
}
