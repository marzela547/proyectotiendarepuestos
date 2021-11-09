/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author jorge
 */
public class CacheProductos {
    
    private static boolean DatosCompartidos = false;
    private static ProductosModelo producto;
    public static Integer Prodcodigo;
    
      public boolean isDatosCompartidos() {
        return DatosCompartidos;
    }

      public void Setdatoscompartidos(boolean DatosCompartidos) {
        CacheProductos.DatosCompartidos = DatosCompartidos;
    }
    
    public  ProductosModelo getProducto() {
        return producto;
    }

    public void setProducto(ProductosModelo proid) {
        CacheProductos.producto = proid;
    }

    public static Integer getProdcodigo() {
        return Prodcodigo;
    }

    public  static void setProdcodigo(Integer Prodcodigo) {
        CacheProductos.Prodcodigo = Prodcodigo;
    }
    
    
  
}
