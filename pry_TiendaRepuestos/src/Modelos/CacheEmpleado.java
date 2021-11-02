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
public class CacheEmpleado {
    private static boolean DatosCompartidos = false;
    private static EmpleadosModelo empleado;
    public static Integer Empcodigo;
    public boolean isDatosCompartidos() {
        return DatosCompartidos;
    }

    public void Setdatoscompartidos(boolean DatosCompartidos) {
        CacheEmpleado.DatosCompartidos = DatosCompartidos;
    }
    
    public EmpleadosModelo getEmpleado() {
        return empleado;
    }

    public void setEmpleado(EmpleadosModelo empid) {
        CacheEmpleado.empleado = empid;
    }

    public static Integer getEmpcodigo() {
        return Empcodigo;
    }

    public static void setEmpcodigo(Integer Empcodigo) {
        CacheEmpleado.Empcodigo = Empcodigo;
    }
   
}
