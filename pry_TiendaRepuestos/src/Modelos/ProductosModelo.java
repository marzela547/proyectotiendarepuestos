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
public class ProductosModelo {

    
    private Integer Procodigo;
    private String Proddescripcion;
    private Float Prodprecventa;
    private Integer Tipcodigo;
    private Integer Marcodigo;
    private Integer Proexistencia;
    private Integer Prodcantidadminima;
    private String estado;
    private String Tipdescripcion;
    private String Mardescripcion;
    private String Tipestado;
    private String Marestado;
    private Integer Detpedcant;
    
    
    public String getTipestado() {
        return Tipestado;
    }

    public void setTipestado(String Tipestado) {
        this.Tipestado = Tipestado;
    }

    public String getMarestado() {
        return Marestado;
    }

    public void setMarestado(String Marestado) {
        this.Marestado = Marestado;
    }
    
    
    
    
    
    public String getTipdescripcion() {
        return Tipdescripcion;
    }

    public void setTipdescripcion(String Tipdescripcion) {
        this.Tipdescripcion = Tipdescripcion;
    }

    public String getMardescripcion() {
        return Mardescripcion;
    }

    public void setMardescripcion(String Mardescripcion) {
        this.Mardescripcion = Mardescripcion;
    }
      
    public Integer getProdcantidadminima() {
        return Prodcantidadminima;
    }

    public void setProdcantidadminima(Integer Prodcantidadminima) {
        this.Prodcantidadminima = Prodcantidadminima;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }


    public ProductosModelo() {
    }

    public ProductosModelo(Integer Procodigo, String Proddescripcion, Float Prodprecventa, Integer Tipcodigo, Integer Marcodigo, Integer Proexistencia, Integer Prodcantidadminima, String estado) {
        this.Procodigo = Procodigo;
        this.Proddescripcion = Proddescripcion;
        this.Prodprecventa = Prodprecventa;
        this.Tipcodigo = Tipcodigo;
        this.Marcodigo = Marcodigo;
        this.Proexistencia = Proexistencia;
        this.Prodcantidadminima = Prodcantidadminima;
        this.estado = estado;
    }

    public Integer getProcodigo() {
        return Procodigo;
    }

    public void setProcodigo(Integer Procodigo) {
        this.Procodigo = Procodigo;
    }

    public String getProddescripcion() {
        return Proddescripcion;
    }

    public void setProddescripcion(String Proddescripcion) {
        this.Proddescripcion = Proddescripcion;
    }

    public Float getProdprecventa() {
        return Prodprecventa;
    }

    public void setProdprecventa(Float Prodprecventa) {
        this.Prodprecventa = Prodprecventa;
    }

    public Integer getTipcodigo() {
        return Tipcodigo;
    }

    public void setTipcodigo(Integer Tipcodigo) {
        this.Tipcodigo = Tipcodigo;
    }

    public Integer getMarcodigo() {
        return Marcodigo;
    }

    public void setMarcodigo(Integer Marcodigo) {
        this.Marcodigo = Marcodigo;
    }

    public Integer getProexistencia() {
        return Proexistencia;
    }

    public void setProexistencia(Integer Proexistencia) {
        this.Proexistencia = Proexistencia;
    }

    public Integer getDetpedcant() {
        return Detpedcant;
    }

    public void setDetpedcant(Integer Detpedcant) {
        this.Detpedcant = Detpedcant;
    }

  
   
}
