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
public class RecuperarModelo {
    Integer EmpCodigo;
    String EmpUsuario;
    String Contrasena;
    String Codigo;

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }
    
    public Integer getEmpCodigo() {
        return EmpCodigo;
    }

    public void setEmpCodigo(Integer EmpCodigo) {
        this.EmpCodigo = EmpCodigo;
    }

    public String getEmpUsuario() {
        return EmpUsuario;
    }

    public void setEmpUsuario(String Usuario) {
        this.EmpUsuario = Usuario;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String Contrasena) {
        this.Contrasena = Contrasena;
    }
    
      
}
