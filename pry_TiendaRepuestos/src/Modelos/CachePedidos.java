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
public class CachePedidos {
    private static boolean bandeProductos = false;
    private static boolean bandeProveedores = false;
    private static Integer Procodigo;
    private static Integer Prodcodigo;
    private static Float Detpedprodprecio;
    private static String Proddescripcion;
    private static String Pronombre;

    public static String getPronombre() {
        return Pronombre;
    }

    public static void setPronombre(String Pronombre) {
        CachePedidos.Pronombre = Pronombre;
    }
    
    public static Integer getProcodigo() {
        return Procodigo;
    }

    public static void setProcodigo(Integer Procodigo) {
        CachePedidos.Procodigo = Procodigo;
    }

    public static Integer getProdcodigo() {
        return Prodcodigo;
    }

    public static void setProdcodigo(Integer Prodcodigo) {
        CachePedidos.Prodcodigo = Prodcodigo;
    }

    public static Float getDetpedprodprecio() {
        return Detpedprodprecio;
    }

    public static void setDetpedprodprecio(Float Detpedprodprecio) {
        CachePedidos.Detpedprodprecio = Detpedprodprecio;
    }

    public static String getProddescripcion() {
        return Proddescripcion;
    }

    public static void setProddescripcion(String Proddescripcion) {
        CachePedidos.Proddescripcion = Proddescripcion;
    }
    
    public static boolean isBandeProductos() {
        return bandeProductos;
    }

    public static void setBandeProductos(boolean bandeProductos) {
        CachePedidos.bandeProductos = bandeProductos;
    }

    public static boolean isBandeProveedores() {
        return bandeProveedores;
    }

    public static void setBandeProveedores(boolean bandeProveedores) {
        CachePedidos.bandeProveedores = bandeProveedores;
    }
    
}
