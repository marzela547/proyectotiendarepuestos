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
public class ClientesModelo {
    private Integer op;
    private Integer Clicodigo;
    private String RTN;
    private String Clinombre;
    private String Clitelefono;
    private String Cliestado;

    public String getCliestado() {
        return Cliestado;
    }

    public void setCliestado(String Cliestado) {
        this.Cliestado = Cliestado;
    }

    public Integer getOp() {
        return op;
    }

    public void setOp(Integer op) {
        this.op = op;
    }

    public Integer getClicodigo() {
        return Clicodigo;
    }

    public void setClicodigo(Integer Clicodigo) {
        this.Clicodigo = Clicodigo;
    }

    public String getRTN() {
        return RTN;
    }

    public void setRTN(String RTN) {
        this.RTN = RTN;
    }

    public String getClinombre() {
        return Clinombre;
    }

    public void setClinombre(String Clinombre) {
        this.Clinombre = Clinombre;
    }

    public String getClitelefono() {
        return Clitelefono;
    }

    public void setClitelefono(String Clitelefono) {
        this.Clitelefono = Clitelefono;
    }
}
