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
public class CacheCliente {
    private static boolean DatosCompartidos = false;
    private static ClientesModelo cliente;
    public static Integer Clicodigo;
    public boolean isDatosCompartidos() {
        return DatosCompartidos;
    }

    public void Setdatoscompartidos(boolean DatosCompartidos) {
        CacheCliente.DatosCompartidos = DatosCompartidos;
    }
    
    public ClientesModelo getCliente() {
        return cliente;
    }

    public void setCliente(ClientesModelo cliid) {
        CacheCliente.cliente = cliid;
    }

    public static Integer getClicodigo() {
        return Clicodigo;
    }

    public static void setClicodigo(Integer Clicodigo) {
        CacheCliente.Clicodigo = Clicodigo;
    }
}
