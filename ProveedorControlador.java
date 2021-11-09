/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;


import Conexiones.ProveedorConexion;
import Especiales.PlaceHolder;
import Especiales.Validaciones;
import Modelos.ProveedorModelo;
import static Controladores.ControladorGeneral.FormatoTabla;
import Modelos.CacheProveedor;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author fgodo
 */
public class ProveedorControlador {
    
    static Integer op = 0;
 
    public static void setPlaceHolders( JTextField txtnombre, JTextField txttelefono,
        JTextArea txtdireccion)
    {
            PlaceHolder placeholdernombre = new PlaceHolder(" Ingrese el Nombre ", txtnombre);
            PlaceHolder placeholdertelefono = new PlaceHolder("Ingrese el Telefono  ", txttelefono);
            PlaceHolder placeholderDireccion = new PlaceHolder("Ingrese la Dirección", txtdireccion);
    }     
    public static Boolean Mantenimientoproveedor(String accion, Integer id,
            String nombre, String telefono ,String direccion ,  String estado,
            JLabel errnombre,JLabel errtelefono,JLabel errdireccion)
    { 
        
        ProveedorControlador.Erroresnull(errnombre, errtelefono,errdireccion);

        String trimmednombre = nombre.trim();
        String trimmedtelefono = telefono.trim();
        String trimmeddireccion = direccion.trim(); 
        Boolean mnterror = false;
        Boolean validaciongeneral = false;
        validaciongeneral = ProveedorControlador.validacionesGenerales(trimmednombre, 
               trimmedtelefono,trimmeddireccion,errnombre,
               errtelefono,errdireccion);

        if(validaciongeneral == false)
        {
            
            switch(accion)
            {
                case "insertar":
                    
                    mnterror = ProveedorControlador.Insertarproveedor(trimmednombre, trimmedtelefono,
                            trimmeddireccion, estado);
                break;
                
                case "editar":   
                    mnterror = ProveedorControlador.Modificarproveedor(id,trimmednombre, trimmedtelefono,
                            trimmeddireccion, estado);             
                break;
            }
        }
        
        return !(mnterror == false && validaciongeneral == false);
    }  
    private static void Erroresnull( JLabel errnombre, JLabel errtelefono,
              JLabel errdireccion )
    {
        errnombre.setText(null);
        errtelefono.setText(null);
        errdireccion.setText(null);
    }     
    private static boolean validacionesGenerales(String trimmednombre, String trimmedtelefono,
        String trimmeddireccion,JLabel errnombre,JLabel errtelefono,JLabel errdireccion)
    {
        boolean error = false;
        if(Validaciones.validarCampoVacio(trimmednombre))
        {
           errnombre.setText("El nombre es un campo obligatorio");
           error = true;
        }        
   
        if(Validaciones.validarCampoVacio(trimmedtelefono))
        {
           errtelefono.setText("Es un campo obligatorio");
           error = true;
        }
        
        if(!Validaciones.validarNumeros(trimmedtelefono))
        {
           errtelefono.setText("El telefono es un campo numerico");
           error = true;
        }      
        if(Validaciones.validarCampoVacio(trimmeddireccion))
        {
           errdireccion.setText("Es un campo obligatorio");
           error = true;
        }
        return error;
    }       
    private static boolean Insertarproveedor(String trimmednombre,String trimmedtelefono, 
            String trimmeddireccion, String estado)
    {
        boolean error = false;
        ProveedorModelo proveedormodelo = new ProveedorModelo();
        proveedormodelo = ProveedorControlador.Setproveedormodelo(0,trimmednombre, trimmedtelefono,
                trimmeddireccion,"ACT");
        String resultado = ProveedorConexion.Mantenimientoproveedores("insertar", proveedormodelo);    
        switch (resultado) 
        {
            case "OK": 
                JOptionPane.showMessageDialog(null, "Proveedor ingresado con éxito.");                             
            break;
            
            case "errNombre":
                JOptionPane.showMessageDialog(null, "El Nombre ya se encuentra registrado.");
                error = true;
            break;
            case "errTelefono":
                JOptionPane.showMessageDialog(null, "El Telefono ya se encuentra registrado.");
                error = true;
            break;
            default:
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error al ejecutar la operación.");
                error = true;
            break;
        }
        return error;
    }
    private static boolean Modificarproveedor(Integer id,String trimmednombre,String trimmedtelefono, 
            String trimmeddireccion, String estado)
    {
        boolean error = false;
        ProveedorModelo proveedormodelo = new ProveedorModelo();
        proveedormodelo = ProveedorControlador.Setproveedormodelo(id,trimmednombre, trimmedtelefono,
                trimmeddireccion,"ACT");
        String resultado = ProveedorConexion.Mantenimientoproveedores("editar", proveedormodelo);    
        switch (resultado) 
        {
            case "OK": 
                JOptionPane.showMessageDialog(null, "Proveedor modificado con éxito.");                             
            break;
            
            case "errNombre":
                JOptionPane.showMessageDialog(null, "El Nombre ya se encuentra registrado.");
                error = true;
            break;
            case "errTelefono":
                JOptionPane.showMessageDialog(null, "El Telefono ya se encuentra registrado.");
                error = true;
            break;
            default:
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error al ejecutar la operación.");
                error = true;
            break;
        }
        return error;
    }    
    public static boolean Eliminarproveedor(Integer id)
    {
        boolean error = false;
        ProveedorModelo proveedormodelo = new ProveedorModelo();

        proveedormodelo =  ProveedorControlador.Setproveedormodelo(id,"","","","");
        String resultado = ProveedorConexion.Mantenimientoproveedores("eliminar", proveedormodelo);    
        switch (resultado) 
        {
            case "OK": 
                   JOptionPane.showMessageDialog(null, "Proveedor eliminado con éxito.");    
                   error=true;
            break;
            
        }
        return error;
    }    
    private static ProveedorModelo Setproveedormodelo(Integer id, String trimmednombre, 
            String trimmedtelefono, String trimmeddireccion,String estado)
    {
        ProveedorModelo proveedormodelo = new ProveedorModelo();      
        proveedormodelo.setProcodigo(id);
        proveedormodelo.setPronombre(trimmednombre);
        proveedormodelo.setProtelefono(trimmedtelefono);
        proveedormodelo.setProdireccion(trimmeddireccion);
        proveedormodelo.setProestado(estado);
        return proveedormodelo;
    }
    public static void Llenartablaproveedor(JTable tablaproveedor, String accion) 
    {  
        
        DefaultTableModel modelo = (DefaultTableModel) tablaproveedor.getModel(); 
        modelo.setRowCount(0);
        ArrayList<ProveedorModelo> proveedor = new ArrayList<>();
        proveedor = ProveedorConexion.Listadoproveedores(accion);
        for (int i = 0; i <proveedor.size(); i++) 
        {
            modelo.addRow
            (new Object[]
                {
                    proveedor.get(i).getProcodigo(), 
                    proveedor.get(i).getPronombre(),
                    proveedor.get(i).getProdireccion(),
                    proveedor.get(i).getProtelefono(),
                    proveedor.get(i).getProestado(),
                    
                }
            );
        } 
        FormatoTabla(tablaproveedor, modelo.getColumnCount());
    }  
    public static Integer SetdatosromCache(JTextField txtnombre,JTextField txttelefono,
                JTextArea txtdireccion, JComboBox cmbestado)
    {
        Integer ProId = null;
        CacheProveedor procache = new CacheProveedor();
       
        if(procache.isDatosCompartidos())
        {
            ProId = procache.getProveedor().getProcodigo();
            txtnombre.setText(procache.getProveedor().getPronombre());
            txttelefono.setText(procache.getProveedor().getProtelefono());
            txtdireccion.setText(procache.getProveedor().getProdireccion());
            cmbestado.setSelectedItem(procache.getProveedor().getProestado());
        }
        return ProId;
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
}

