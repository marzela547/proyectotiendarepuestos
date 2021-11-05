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
public class PedidosModelo {
    private Integer op;
    private Integer Pedcodigo;
    private Integer Procodigo;
    private String Pedfecha;
    private Integer Empcodigo;
    private String Pedestado;
    private Integer Detpedcodigo;
    private Integer Prodcodigo;
    private Integer Detpedcant;
    private Float Detpedprodprecio;
    private String Proddescripcion;

    public String getProddescripcion() {
        return Proddescripcion;
    }

    public void setProddescripcion(String Proddescripcion) {
        this.Proddescripcion = Proddescripcion;
    }
   

    public Integer getOp() {
        return op;
    }

    public void setOp(Integer op) {
        this.op = op;
    }

    public Integer getPedcodigo() {
        return Pedcodigo;
    }

    public void setPedcodigo(Integer Pedcodigo) {
        this.Pedcodigo = Pedcodigo;
    }

    public Integer getProcodigo() {
        return Procodigo;
    }

    public void setProcodigo(Integer Procodigo) {
        this.Procodigo = Procodigo;
    }

    public String getPedfecha() {
        return Pedfecha;
    }

    public void setPedfecha(String Pedfecha) {
        this.Pedfecha = Pedfecha;
    }

    public Integer getEmpcodigo() {
        return Empcodigo;
    }

    public void setEmpcodigo(Integer Empcodigo) {
        this.Empcodigo = Empcodigo;
    }

    public String getPedestado() {
        return Pedestado;
    }

    public void setPedestado(String Pedestado) {
        this.Pedestado = Pedestado;
    }

    public Integer getDetpedcodigo() {
        return Detpedcodigo;
    }

    public void setDetpedcodigo(Integer Detpedcodigo) {
        this.Detpedcodigo = Detpedcodigo;
    }

    public Integer getProdcodigo() {
        return Prodcodigo;
    }

    public void setProdcodigo(Integer Prodcodigo) {
        this.Prodcodigo = Prodcodigo;
    }

    public Integer getDetpedcant() {
        return Detpedcant;
    }

    public void setDetpedcant(Integer Detpedcant) {
        this.Detpedcant = Detpedcant;
    }

    public Float getDetpedprodprecio() {
        return Detpedprodprecio;
    }

    public void setDetpedprodprecio(Float Detpedprodprecio) {
        this.Detpedprodprecio = Detpedprodprecio;
    }
    
}
