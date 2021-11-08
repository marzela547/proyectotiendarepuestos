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
    private Integer Prodcodigo;
    private String Proddescripcion;
    private Float Prodprecventa;
    private String Prodestado;
    private Integer Detpedcant;

    public Integer getDetpedcant() {
        return Detpedcant;
    }

    public void setDetpedcant(Integer Detpedcant) {
        this.Detpedcant = Detpedcant;
    }

    public Integer getProdcodigo() {
        return Prodcodigo;
    }

    public void setProdcodigo(Integer Prodcodigo) {
        this.Prodcodigo = Prodcodigo;
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

    public String getProdestado() {
        return Prodestado;
    }

    public void setProdestado(String Prodestado) {
        this.Prodestado = Prodestado;
    }
    
}
