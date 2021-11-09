/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Conexiones.ContactoConexion;
import Conexiones.ProductosConexion;
import static Controladores.ContactoContralador.op;
import static Controladores.ControladorGeneral.FormatoTabla;
import Especiales.PlaceHolder;
import Especiales.Validaciones;
import Modelos.CachePedidos;
import Modelos.CacheProductos;
import Modelos.ContactoModelo;
import Modelos.ProductosModelo;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author fgodo
 */
public class ProductoControlador {
     static Integer op = 0;
    
    public static void setPlaceHolders(JTextField txtdescripcion, JTextField txtventa,
            JTextField txtexistencia,JTextField txtminia)
    {
            PlaceHolder placeholdernombre = new PlaceHolder("Ingrese el Nombre", txtdescripcion);
            PlaceHolder placeholderventa = new PlaceHolder("Ingrese Precio de venta  ", txtventa);
            PlaceHolder placeholderexistencia = new PlaceHolder("Ingrese la existencia ", txtexistencia);
            PlaceHolder placeholdereminima = new PlaceHolder("Ingrese cantidad minima ", txtminia);
    }    
    
    public static Boolean MantenimientoProducto(String accion, Integer id,
            String descripcion, String pventa ,Integer tipo,Integer marca,
            String existencia,String minima ,String estado,
            JLabel errdescripicon, JLabel errtventa, JLabel errexistencia,JLabel errminima)
    { 

        ProductoControlador.Erroresnull(errdescripicon, errtventa, errexistencia,errminima);

        String trimmeddecripcion = descripcion.trim();

        Boolean mnterror = false;
        Boolean validaciongeneral = false;
        
        validaciongeneral = ProductoControlador.validacionesGenerales( trimmeddecripcion, pventa, existencia, 
               minima, errdescripicon, errtventa,errexistencia,errminima);

        if(validaciongeneral == false)
        {
            
            switch(accion)
            {
                case "insertar":
                    
                    mnterror = ProductoControlador.Insertarproducto(descripcion,Float.parseFloat(pventa),tipo,marca,
                            Integer.parseInt(existencia), Integer.parseInt(minima),estado);
                break;
                
                case "editar":   
                    mnterror = ProductoControlador.Modificarproducto(id,descripcion,Float.parseFloat(pventa),tipo,marca,
                            Integer.parseInt(existencia), Integer.parseInt(minima),estado);           
                break;
            }
        }
        
        return !(mnterror == false && validaciongeneral == false);
    }
    private static void Erroresnull( JLabel errndescri, JLabel errtventa,JLabel errtexistencia,
            JLabel errtminima)
    {
        errndescri.setText(null);
        errtventa.setText(null);
        errtexistencia.setText(null);
        errtminima.setText(null);
    }   
    private static boolean validacionesGenerales(String descripcion,String pventa , String existencia,String minima,
        JLabel errdescripcion,JLabel errventa, JLabel errexistencia,JLabel errminima )
    {
       
        boolean error = false;
        if(Validaciones.validarCampoVacio(descripcion))
        {
           errdescripcion.setText("El nombre es un campo obligatorio");
           error = true;
        }
        if(Validaciones.validarCampoVacio(String.valueOf(pventa)))
        {
           errventa.setText("Es un campo obligatorio");
           error = true;
        }
         System.out.println("llego");
        if(Validaciones.validarCampoVacio(String.valueOf(existencia)))
        {
           errexistencia.setText("Es un campo obligatorio");
           error = true;
        }      
         if(Validaciones.validarCampoVacio(String.valueOf(minima)))
        {
           errminima.setText("Es un campo obligatorio");
           error = true;
        }       
        System.out.println("llego");
        if(!Validaciones.validarNumerosDouble(String.valueOf(pventa)))
        {
           errventa.setText("Es un campo numerico decimal");
           error = true;
        }
        if(!Validaciones.validarNumeros(String.valueOf(existencia)))
        {
           errexistencia.setText("Es un campo numerico entero");
           error = true;
        }      
         if(!Validaciones.validarNumeros(String.valueOf(minima)))
        {
           errminima.setText("Es un campo numerico entero");
           error = true;
        }          
         System.out.println("llego2");
        if(!Validaciones.validarmayor0((String.valueOf(minima))))
        {
           errminima.setText("Debe mayor 0");
           error = true;
        }  
        System.out.println("jajaj");
        if(!Validaciones.validarmayor0float((String.valueOf(pventa))))
        {
           errventa.setText("Debe mayor 0");
           error = true;
        } 
         System.out.println("jejej");
        if(!Validaciones.validarmayor0((String.valueOf(existencia))))
        {
          errexistencia.setText("Debe mayor 0");
           error = true;
        } 
         System.out.println("llego3");
         
        return error;
    }       
      
    
     private static boolean Insertarproducto(String descripcion,Float pventa,
            Integer tipo,Integer marca,Integer existencia,Integer minima, String estado )
    {
        boolean error = false;
        ProductosModelo productomodelo = new ProductosModelo();
        productomodelo = ProductoControlador.Setproductomodelo(0, 
                descripcion, pventa,tipo,marca, existencia,minima,estado);
        String resultado = ProductosConexion.MantenimientProductos("insertar", productomodelo);    
        switch (resultado) 
        {
            case "OK": 

                    JOptionPane.showMessageDialog(null, "Producto ingresado con éxito.");                                   
            break;
            
             case "errDescripcion":
                JOptionPane.showMessageDialog(null, "Nombre ya registrado.");
                error = true;
            break;
            default:
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error al ejecutar la operación.");
                error = true;
            break;
        }
        return error;
    }    
     private static boolean Modificarproducto(Integer Id,String descripcion,Float pventa,
            Integer tipo,Integer marca,Integer existencia,Integer minima, String estado )
    {
        boolean error = false;
        ProductosModelo productomodelo = new ProductosModelo();
        productomodelo = ProductoControlador.Setproductomodelo(Id, 
                descripcion, pventa,tipo,marca, existencia,minima,estado);
        String resultado = ProductosConexion.MantenimientProductos("editar", productomodelo);    
        switch (resultado) 
        {
            case "OK": 

                    JOptionPane.showMessageDialog(null, "Producto editado con éxito.");                                   
            break;
            
             case "errDescripcion":
                JOptionPane.showMessageDialog(null, "Nombre ya registrado.");
                error = true;
            break;
            default:
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error al ejecutar la operación.");
                error = true;
            break;
        }
        return error;
    } 
    public static boolean Eliminarproducto(Integer id)
    {
        float d =0;
        boolean error = false;
        ProductosModelo productomodelo = new ProductosModelo();
        productomodelo = ProductoControlador.Setproductomodelo(id, 
                "",d,0,0,0,0,"");
        String resultado = ProductosConexion.MantenimientProductos("eliminar", productomodelo);    
        switch (resultado) 
        {
            case "OK": 
                   JOptionPane.showMessageDialog(null, "Producto eliminado con éxito.");    
                   error=true;
            break;
            
        }
        return error;
    }       
     
    private static ProductosModelo Setproductomodelo(Integer id, String descripcion, Float venta,Integer tipo,
            Integer marca,  Integer existencia,Integer minima, String estado)
    {
        ProductosModelo productomodelo = new ProductosModelo();      
        productomodelo.setProcodigo(id);
        productomodelo.setProddescripcion(descripcion);
        productomodelo.setProdprecventa(venta);
        productomodelo.setTipcodigo(tipo);
        productomodelo.setMarcodigo(marca);
        productomodelo.setProexistencia(existencia);
        productomodelo.setProdcantidadminima(minima);
        productomodelo.setEstado(estado);
        return productomodelo;
    }     
    
    
    public static Integer SetdatosromCache(JTextField txtdescripcion,JTextField txtventa,
                 JComboBox cmbtipo,JComboBox cmbmarca,JTextField txtexistencia,JTextField minima,
                 JComboBox cmbestado )
    {
        Integer ProId = null;
        CacheProductos cache = new CacheProductos();
       
        if(cache.isDatosCompartidos())
        {
            System.out.println("llego");
            ProId = cache.getProducto().getProcodigo();
            txtdescripcion.setText(cache.getProducto().getProddescripcion());
            txtventa.setText(String.valueOf(cache.getProducto().getProdprecventa()));
            cmbtipo.setSelectedItem(cache.getProducto().getTipdescripcion());
            cmbmarca.setSelectedItem(cache.getProducto().getMardescripcion());
            txtexistencia.setText(String.valueOf(cache.getProducto().getProexistencia()));
            minima.setText(String.valueOf(cache.getProducto().getProdcantidadminima()));
            cmbestado.setSelectedItem(cache.getProducto().getEstado());
            System.out.println("final");
        }
        return ProId;
    }    
    public static void Llenartablaproducto(JTable tablaproducto, String accion) 
    {  
        
        DefaultTableModel modelo = (DefaultTableModel) tablaproducto.getModel(); 
        modelo.setRowCount(0);
        ArrayList<ProductosModelo> productos = new ArrayList<>();
        productos = ProductosConexion.ListadoProducto(accion);
        for (int i = 0; i <productos.size(); i++) 
        {
            modelo.addRow
            (new Object[]
                {
                    productos.get(i).getProcodigo(), 
                    productos.get(i).getProddescripcion(),
                    productos.get(i).getProdprecventa(),
                    productos.get(i).getTipdescripcion(),
                    productos.get(i).getMardescripcion(),
                    productos.get(i).getProexistencia(),
                    productos.get(i).getProdcantidadminima(),
                    productos.get(i).getEstado(),
                }
            );
        } 
        FormatoTabla(tablaproducto, modelo.getColumnCount());
    }      
    public static void Llenartablaproductos(JTable tablaproducto, String accion, int cod) 
    {  
        
        DefaultTableModel modelo = (DefaultTableModel) tablaproducto.getModel(); 
        modelo.setRowCount(0);
        //Estados estados = new Estados();
        ArrayList<ProductosModelo> productos = new ArrayList<>();
        productos = ProductosConexion.Listadoproducto(accion,cod);
        for (int i = 0; i <productos.size(); i++) 
        {
            modelo.addRow
            (new Object[]
                {
                    productos.get(i).getProcodigo(), 
                    productos.get(i).getProddescripcion(),
                    productos.get(i).getProdprecventa(),
                    productos.get(i).getEstado()
                    
                }
            );
        } 
        FormatoTabla(tablaproducto, modelo.getColumnCount());
    }
    public static void Llenarcmbmarca(JComboBox CmbMarca)
    {
        ArrayList<ProductosModelo> proveedores = new ArrayList<>();
        proveedores = ProductosConexion.Listadomarcas();
        
        for (int i = 0; i<proveedores.size(); i++)
        {
            CmbMarca.addItem(proveedores.get(i).getMardescripcion());
        }
    }     
    public static void Llenarcmbtipo(JComboBox CmbTipo)
    {
        ArrayList<ProductosModelo> proveedores = new ArrayList<>();
        proveedores = ProductosConexion.Listadotipos();
        
        for (int i = 0; i<proveedores.size(); i++)
        {
            CmbTipo.addItem(proveedores.get(i).getTipdescripcion());
        }
    } 
    public void setOperacion(Integer ope)
    {
        this.op = ope;
    }
    public static Integer getOperacion()
    {
        Integer opv = op;
        return opv;
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
