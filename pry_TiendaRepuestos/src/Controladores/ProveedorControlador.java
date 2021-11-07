/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Conexiones.ProveedoresConexion;
import static Controladores.ControladorGeneral.FormatoTabla;
import Modelos.CachePedidos;
import Modelos.PedidosModelo;
import Modelos.ProveedoresModelo;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author marce
 */
public class ProveedorControlador {
    static Integer op = 0;
    public static void Llenartablaproveedor(JTable tablaproveedor, String accion) 
    {  
        
        DefaultTableModel modelo = (DefaultTableModel) tablaproveedor.getModel(); 
        modelo.setRowCount(0);
        //Estados estados = new Estados();
        ArrayList<ProveedoresModelo> proveedores = new ArrayList<>();
        proveedores = ProveedoresConexion.Listadoproveedor(accion);
        for (int i = 0; i <proveedores.size(); i++) 
        {
            modelo.addRow
            (new Object[]
                {
                    proveedores.get(i).getProcodigo(), 
                    proveedores.get(i).getPronombre(),
                    proveedores.get(i).getProdireccion(),
                    proveedores.get(i).getProtelefono(),
                    proveedores.get(i).getProestado()
                    
                }
            );
        } 
        FormatoTabla(tablaproveedor, modelo.getColumnCount());
    }
    
    public static void transferirDatos(JTable tablaproveedor){
        int fila;
        //PedidosModelo proveedor = new PedidosModelo();
        CachePedidos cache = new CachePedidos();
        fila = tablaproveedor.getSelectedRow();
        cache.setBandeProveedores(true);
        cache.setProcodigo((Integer) tablaproveedor.getValueAt(fila, 0));
        cache.setPronombre((String) tablaproveedor.getValueAt(fila, 1));
        cache.setProdireccion((String) tablaproveedor.getValueAt(fila, 2));
        cache.setProtelefono((String) tablaproveedor.getValueAt(fila, 3));
    }
}
