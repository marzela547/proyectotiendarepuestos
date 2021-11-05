/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Conexiones.ProductosConexion;
import static Controladores.ControladorGeneral.FormatoTabla;
import Modelos.CachePedidos;
import Modelos.PedidosModelo;
import Modelos.ProductosModelo;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author marce
 */
public class ProductoControlador {
    static Integer op = 0;
    public static void Llenartablaproducto(JTable tablaproducto, String accion) 
    {  
        
        DefaultTableModel modelo = (DefaultTableModel) tablaproducto.getModel(); 
        modelo.setRowCount(0);
        //Estados estados = new Estados();
        ArrayList<ProductosModelo> productos = new ArrayList<>();
        productos = ProductosConexion.Listadoproducto(accion);
        for (int i = 0; i <productos.size(); i++) 
        {
            modelo.addRow
            (new Object[]
                {
                    productos.get(i).getProdcodigo(), 
                    productos.get(i).getProddescripcion(),
                    productos.get(i).getProdprecventa(),
                    productos.get(i).getProdestado()
                    
                }
            );
        } 
        FormatoTabla(tablaproducto, modelo.getColumnCount());
    }
    
    public static void transferirDatos(JTable tablaproducto){
        int fila;
        //PedidosModelo producto = new PedidosModelo();
        CachePedidos cache = new CachePedidos();
        fila = tablaproducto.getSelectedRow();
        cache.setBandeProductos(true);
        cache.setProdcodigo((Integer) tablaproducto.getValueAt(fila, 0));
        cache.setProddescripcion((String) tablaproducto.getValueAt(fila, 1));
        cache.setDetpedprodprecio((Float) tablaproducto.getValueAt(fila, 2));
    }
}
