/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Conexiones.PedidosConexion;
import Conexiones.ProductosConexion;
import static Controladores.ControladorGeneral.FormatoTabla;
import Especiales.PlaceHolder;
import Especiales.Validaciones;
import Modelos.CachePedidos;
import Modelos.PedidosModelo;
import Modelos.ProductosModelo;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author marce
 */
public class PedidosControlador {
    static Integer op = 0;
    
    public static void setPlaceHolders(JTextField txtProveedor, JTextField txtProducto, JTextArea txtDescripproducto, JTextField txtprecio)
    {
        PlaceHolder placeholderProveddor = new PlaceHolder("Compañía...", txtProveedor);
        PlaceHolder placeholderProductoCod = new PlaceHolder("000...", txtProducto);
        PlaceHolder placeholderProductoDes = new PlaceHolder("Descripción...", txtDescripproducto);
        PlaceHolder placeholderProductoPre = new PlaceHolder("Lps.0.00", txtprecio);
    }
    
    public static void agregarProveedor(JTextField txtProveedor){
        //PedidosModelo pedidos = new PedidosModelo();
        CachePedidos cache = new CachePedidos();
        txtProveedor.setText(cache.getPronombre());
    }
    public static void agregarProducto(JTextField txtProducto, JTextArea txtDescrip, JTextField txtPrecio, JSpinner spinner){
        CachePedidos cache = new CachePedidos();
        spinner.setValue(1);
        txtDescrip.setText(cache.getProddescripcion());
        txtPrecio.setText(cache.getDetpedprodprecio().toString());
        txtProducto.setText(String.valueOf(cache.getProdcodigo()));
    }
    
    public static void cambioSpinner(JSpinner spinner){
        if(Integer.parseInt(spinner.getValue().toString())<1){
            JOptionPane.showMessageDialog(null, "Lo sentimos, la cantidad no puede ser menor a 1");
            spinner.setValue(1);
        }
        
    }
    public static Boolean Mantenimientopedidos(String accion, Integer id ,Integer Procodigo,
             String Pedfecha, Integer Empcodigo, String Estado)
    { 
        
        
        Boolean mnterror = false;
        
            switch(accion)
            {
                case "insertar":
                
                    mnterror = PedidosControlador.Insertarpedido(Procodigo, Pedfecha, Empcodigo);
                break;
                
                case "editar":   
                    mnterror = PedidosControlador.Modificarpedido(id,Procodigo, Pedfecha, Empcodigo,  Estado);            
                break;
            }
        return !(mnterror == false);
    }
    
    private static boolean Insertarpedido(Integer Procodigo, String Pedfecha, Integer Empcodigo)
    {
        System.out.println("llego insertar");
        boolean error = false;
        PedidosModelo pedidomodelo = new PedidosModelo();
        pedidomodelo = PedidosControlador.Setpedidosmodelo(0, Procodigo, Pedfecha, Empcodigo, "ACT",0);
        String resultado = PedidosConexion.Mantenimientopedidos("insertar", pedidomodelo);    
        System.out.println(resultado);
        switch (resultado) 
        {
            case "OK": 
                    System.out.println("llego insertar 5");
                   JOptionPane.showMessageDialog(null, "Pedido ingresado con éxito.");              
            break;
            default:
                System.out.println("llego insertar 9");
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error al ejecutar la operación.");
                error = true;
            break;
        }
        return error;
    }
    
    private static boolean Modificarpedido(Integer id,Integer Procodigo, String Pedfecha, Integer Empcodigo,  String Estado )
    {
        boolean error = false;
        System.out.println("llegue");
        PedidosModelo pedidomodelo = new PedidosModelo();
        pedidomodelo = PedidosControlador.Setpedidosmodelo(id, Procodigo, Pedfecha, Empcodigo,  Estado, 0);
        String resultado = PedidosConexion.Mantenimientopedidos("editar", pedidomodelo);    
          System.out.println(pedidomodelo);
        System.out.println(resultado);
        switch (resultado) 
        {
            case "OK": 
                   JOptionPane.showMessageDialog(null, "Pedido editado con éxito.");              
            break;
            
            default:
                System.out.println("llego insertar 9");
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error al ejecutar la operación.");
                error = true;
            break;
        }
        return error;
    }
    
    public static void Llenartablapedidostemp(JTable tablatemp) 
    {  
        
        DefaultTableModel modelo = (DefaultTableModel) tablatemp.getModel(); 
        modelo.setRowCount(0);
        //Estados estados = new Estados();
        ArrayList<PedidosModelo> temp = new ArrayList<>();
        temp = PedidosConexion.Listadotemp();
        for (int i = 0; i <temp.size(); i++) 
        {
            modelo.addRow
            (new Object[]
                {
                    temp.get(i).getProdcodigo(), 
                    temp.get(i).getProddescripcion(),
                    temp.get(i).getDetpedprodprecio(),
                    temp.get(i).getDetpedcant()
                    
                }
            );
        } 
        FormatoTabla(tablatemp, modelo.getColumnCount());
    }
    public static Boolean Mantenimientotemp(String accion,JTextField txtcodigo, JTextArea txtdescrip, JTextField txtprecio, JSpinner spinner)
    { 
        Boolean mnterror = false;
        
            switch(accion)
            {
                case "insertar":
                
                    mnterror = PedidosControlador.Insertartemp(txtcodigo, txtdescrip,
                            txtprecio, spinner);
                break;
                
                case "editar":   
                    mnterror = PedidosControlador.Modificartemp(txtcodigo, txtdescrip,
                            txtprecio, spinner);             
                break;
                case "eliminar":   
                    mnterror = PedidosControlador.Eliminartemp();             
                break;
            }
        
        
        return !(mnterror == false );
    }
    private static boolean Insertartemp(JTextField txtcodigo, JTextArea txtdescrip, JTextField txtprecio, JSpinner spinner )
    {
        System.out.println("llego insertar");
        boolean error = false;
        PedidosModelo pedidomodelo = new PedidosModelo();
        pedidomodelo = PedidosControlador.Setpedidomodelo(Integer.parseInt(txtcodigo.getText()), txtdescrip.getText(), Float.parseFloat(txtprecio.getText()), Integer.parseInt(spinner.getValue().toString()));
        String resultado = PedidosConexion.Mantenimientotemp("insertar", pedidomodelo);    
        System.out.println(resultado);
        switch (resultado) 
        {
            case "OK": 
                    System.out.println("llego insertar 5");
                    System.out.println("Producto agregado correctamente");
            break;
            case "existe": 
                    System.out.println("llego insertar 5");
                    JOptionPane.showMessageDialog(null,"El producto ya se encuentra agregado al pedido");
            break;
            default:
                System.out.println("llego insertar 9");
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error al ejecutar la operación.");
                error = true;
            break;
        }
        return error;
    }
    private static boolean Modificartemp(JTextField txtcodigo, JTextArea txtdescrip, JTextField txtprecio, JSpinner spinner)
    {
        boolean error = false;
        System.out.println("llegue");
        PedidosModelo pedidomodelo = new PedidosModelo();
        pedidomodelo = PedidosControlador.Setpedidomodelo(Integer.parseInt(txtcodigo.getText()), txtdescrip.getText(), Float.parseFloat(txtprecio.getText()), Integer.parseInt(spinner.getValue().toString()));
        String resultado = PedidosConexion.Mantenimientotemp("editar", pedidomodelo);    
          //System.out.println(cmodelo);
        //System.out.println(resultado);
        switch (resultado) 
        {
            case "OK": 
                   JOptionPane.showMessageDialog(null, "Cliente editado con éxito.");              
            break;
            default:
                System.out.println("llego insertar 9");
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error al ejecutar la operación.");
                error = true;
            break;
        }
        return error;
    }
    private static boolean Eliminartemp()
    {
        boolean error = false;
        System.out.println("llegue");
        PedidosModelo pedidomodelo = new PedidosModelo();
        pedidomodelo = PedidosControlador.Setpedidomodelo(0, "",Float.parseFloat("0"),0);
        String resultado = PedidosConexion.Mantenimientotemp("eliminar", pedidomodelo);    
        switch (resultado) 
        {
            case "OK": 
                   //JOptionPane.showMessageDialog(null, "Cliente eliminado con éxito.");    
                   error=true;
            break;
            
        }
        return error;
    } 
    private static PedidosModelo Setpedidomodelo( Integer id, String descrip, Float precio, Integer cantidad )
    {
        PedidosModelo pedidomodelo = new PedidosModelo();     
        pedidomodelo.setProdcodigo(id);
        pedidomodelo.setProddescripcion(descrip);
        pedidomodelo.setDetpedprodprecio(precio);
        pedidomodelo.setDetpedcant(cantidad);
        return pedidomodelo;
    }
    
    private static PedidosModelo Setpedidosmodelo( Integer id, Integer Procodigo, String Pedfecha, Integer Empcodigo,  String Estado, Integer canti)
    {
        PedidosModelo pedidomodelo = new PedidosModelo();     
        pedidomodelo.setPedcodigo(id);
        pedidomodelo.setProcodigo(Procodigo);
        pedidomodelo.setPedfecha(Pedfecha);
        pedidomodelo.setEmpcodigo(Empcodigo);
        pedidomodelo.setPedestado(Estado);
        pedidomodelo.setDetpedcant(canti);
        
        return pedidomodelo;
    }
    
    public static void agregarFilaProducto(JTable tabla_productos, JTextField txtcodigo, JTextArea txtdescrip, JTextField txtprecio, JSpinner spinner){
        String productos [] = {txtcodigo.getText(), txtdescrip.getText(), txtprecio.getText(), String.valueOf(spinner.getValue())};
        
        DefaultTableModel modelo = (DefaultTableModel) tabla_productos.getModel();
        modelo.addRow(productos);
        
    }
    
    public static void limpiarTextos(JTextField txtcodigo, JTextArea txtdescrip, JTextField txtprecio, JSpinner spinner){
        txtcodigo.setText("");
        txtdescrip.setText("");
        txtprecio.setText("");
        spinner.setValue(1);
    }
}
