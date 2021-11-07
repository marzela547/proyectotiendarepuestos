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
public class ProveedoresModelo {
    private Integer Procodigo;
    private String Pronombre;
    private String Proestado;
    private String Prodireccion;

    public String getProdireccion() {
        return Prodireccion;
    }

    public void setProdireccion(String Prodireccion) {
        this.Prodireccion = Prodireccion;
    }
    
    

    public String getProestado() {
        return Proestado;
    }

    public void setProestado(String Proestado) {
        this.Proestado = Proestado;
    }
    

    public Integer getProcodigo() {
        return Procodigo;
    }

    public void setProcodigo(Integer Procodigo) {
        this.Procodigo = Procodigo;
    }

    public String getPronombre() {
        return Pronombre;
    }

    public void setPronombre(String Pronombre) {
        this.Pronombre = Pronombre;
    }
    
}
