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
public class MarcasModelo {
    private Integer Marcodigo;
    private String Mardescripcion;
    private String Marestado;

    public String getMarestado() {
        return Marestado;
    }

    public void setMarestado(String Marestado) {
        this.Marestado = Marestado;
    }
    
    public Integer getMarcodigo() {
        return Marcodigo;
    }

    public void setMarcodigo(Integer Marcodigo) {
        this.Marcodigo = Marcodigo;
    }

    public String getMardescripcion() {
        return Mardescripcion;
    }

    public void setMardescripcion(String Mardescripcion) {
        this.Mardescripcion = Mardescripcion;
    }
    
    
}
