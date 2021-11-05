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
public class CacheLogin {
    private static Integer EmpCodigo;
    private static String Empnombre;
    private static String Empcorreo;
    private static String EmpUsuario; 

    public static Integer getEmpCodigo() {
        return EmpCodigo;
    }

    public static void setEmpCodigo(Integer EmpCodigo) {
        CacheLogin.EmpCodigo = EmpCodigo;
    }

    public static String getEmpnombre() {
        return Empnombre;
    }

    public static void setEmpnombre(String Empnombre) {
        CacheLogin.Empnombre = Empnombre;
    }

    public static String getEmpcorreo() {
        return Empcorreo;
    }

    public static void setEmpcorreo(String Empcorreo) {
        CacheLogin.Empcorreo = Empcorreo;
    }

    public static String getEmpUsuario() {
        return EmpUsuario;
    }

    public static void setEmpUsuario(String EmpUsuario) {
        CacheLogin.EmpUsuario = EmpUsuario;
    }
    
    
    
    
    
}
