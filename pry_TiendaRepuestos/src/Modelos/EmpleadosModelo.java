/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.util.ArrayList;

/**
 *
 * @author fgodo
 */
public class EmpleadosModelo {
    private Integer op;
    private Integer Empcodigo;
    private String Empidentidad;
    private String Empnombre;
    private String Emptelefono;
    private String Empfechanacimiento;
    private String Empcorreo;
    private String Empdireccion;
    private String Empfechaingreso;
    private String Empfechasalidad;
    private String Empestado;
    private String Empusuario;
    private String Empcontrasena;
    private Integer Puecodigo;
    private Integer Pueempcodigo;
    private String Puedecripcion;

    public String getPuedecripcion() {
        return Puedecripcion;
    }

    public void setPuedecripcion(String Puedecripcion) {
        this.Puedecripcion = Puedecripcion;
    }
    
    
    private static ArrayList<Integer> allPuempcodigos = new ArrayList<>();
    public Integer getPuecodigo() {
        return Puecodigo;
    }

    public  ArrayList<Integer> getAllPuempcodigos() {
        return allPuempcodigos;
    }

    public  void setAllPuempcodigos(Integer id) {
        this.allPuempcodigos.add(id);
    }

    public void setPuecodigo(Integer Puecodigo) {
        this.Puecodigo = Puecodigo;
    }

    public Integer getPueempcodigo() {
        return Pueempcodigo;
    }

    public void setPueempcodigo(Integer Pueempcodigo) {
        this.Pueempcodigo = Pueempcodigo;
    }

    public String getEmpusuario() {
        return Empusuario;
    }

    public void setEmpusuario(String Empusuario) {
        this.Empusuario = Empusuario;
    }

    public String getEmpcontrasena() {
        return Empcontrasena;
    }

    public void setEmpcontrasena(String Empcontrasena) {
        this.Empcontrasena = Empcontrasena;
    }
    
    public Integer getOp() {
        return op;
    }

    public void setOp(Integer op) {
        this.op = op;
    }
    
    public String getEmpestado() {
        return Empestado;
    }

    public void setEmpestado(String Empestado) {
        this.Empestado = Empestado;
    }

    public String getEmpdireccion() {
        return Empdireccion;
    }

    public void setEmpdireccion(String Empdireccion) {
        this.Empdireccion = Empdireccion;
    }


    public Integer getEmpcodigo() {
        return Empcodigo;
    }

    public void setEmpcodigo(Integer Empcodigo) {
        this.Empcodigo = Empcodigo;
    }

    public String getEmpidentidad() {
        return Empidentidad;
    }

    public void setEmpidentidad(String Empidentidad) {
        this.Empidentidad = Empidentidad;
    }

    public String getEmpnombre() {
        return Empnombre;
    }

    public void setEmpnombre(String Empnombre) {
        this.Empnombre = Empnombre;
    }

    public String getEmptelefono() {
        return Emptelefono;
    }

    public void setEmptelefono(String Emptelefono) {
        this.Emptelefono = Emptelefono;
    }

    public String getEmpfechanacimiento() {
        return Empfechanacimiento;
    }

    public void setEmpfechanacimiento(String Empfechanacimiento) {
        this.Empfechanacimiento = Empfechanacimiento;
    }

    public String getEmpfechaingreso() {
        return Empfechaingreso;
    }

    public void setEmpfechaingreso(String Empfechaingreso) {
        this.Empfechaingreso = Empfechaingreso;
    }

    public String getEmpfechasalidad() {
        return Empfechasalidad;
    }

    public void setEmpfechasalidad(String Empfechasalidad) {
        this.Empfechasalidad = Empfechasalidad;
    }

    public String getEmpcorreo() {
        return Empcorreo;
    }

    public void setEmpcorreo(String Empcorreo) {
        this.Empcorreo = Empcorreo;
    }
    
}
