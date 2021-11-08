/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Conexiones.ContactoConexion;
import static Controladores.ControladorGeneral.FormatoTabla;
import Especiales.PlaceHolder;
import Especiales.Validaciones;
import Modelos.CacheContacto;
import Modelos.CacheProveedor;
import Modelos.ContactoModelo;
import Modelos.ProveedoresModelo;
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
public class ContactoContralador {
    static Integer op = 0;
    
    public static void setPlaceHolders(JTextField txtnombre, JTextField txttelefono,
        JTextField txtcorreo)
    {

            PlaceHolder placeholdernombre = new PlaceHolder("Ingrese el Nombre", txtnombre);
            PlaceHolder placeholdertelefono = new PlaceHolder("Ingrese el Telefono  ", txttelefono);
            PlaceHolder placeholderCorreo = new PlaceHolder("Ingrese el Correo ", txtcorreo);
    }       
    
    
    public static Boolean Mantenimientocontacto(String accion, Integer id,
            String nombre, String telefono ,String correo,String proveedor,  String estado,
            JLabel errnombre, JLabel errtelefono, JLabel errcorreo)
    { 
        
        ContactoContralador.Erroresnull(errnombre, errtelefono, errcorreo);
        
        String trimmednombre = nombre.trim();
        String trimmedtelefono = telefono.trim();
        String trimmedcorreo = correo.trim();
        Boolean mnterror = false;
        Boolean validaciongeneral = false;

        validaciongeneral = ContactoContralador.validacionesGenerales( trimmednombre, trimmedtelefono, trimmedcorreo, 
               errnombre, errtelefono, errcorreo);

        if(validaciongeneral == false)
        {
            
            switch(accion)
            {
                case "insertar":
                    
                    mnterror = ContactoContralador.Insertarcontacto( trimmednombre,
                            trimmedtelefono,trimmedcorreo,ContactoConexion.IdPro(proveedor),estado);
                break;
                
                case "editar":   
                    mnterror = ContactoContralador.Modificarcontacto(id,trimmednombre,
                            trimmedtelefono,trimmedcorreo,ContactoConexion.IdPro(proveedor),estado);           
                break;
            }
        }
        
        return !(mnterror == false && validaciongeneral == false);
    }       
    private static void Erroresnull( JLabel errnombre, JLabel errtelefono,
            JLabel errcorreo)
    {
        errnombre.setText(null);
        errtelefono.setText(null);
        errcorreo.setText(null);

    }       
    private static boolean validacionesGenerales(String trimmednombre,String trimmedtelefono, String trimmedcorreo,
        JLabel errnombre,JLabel errtelefono, JLabel errcorreo)
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
         if(Validaciones.validarCampoVacio(trimmedcorreo))
        {
           errcorreo.setText("Es un campo obligatorio");
           error = true;
        }       
        if(!Validaciones.validarCorreo(trimmedcorreo))
        {
            
           errcorreo.setText("Formato erroneo de correo");
           error = true;
        }
        return error;
    }       
    
     private static boolean Insertarcontacto(String trimmednombre,String trimmedtelefono,
            String trimmedcorreo,Integer proveedor, String estado )
    {
        boolean error = false;
        ContactoModelo contactoomodelo = new ContactoModelo();
        contactoomodelo = ContactoContralador.Setcontactomodelo(0, 
                trimmednombre, trimmedtelefono,trimmedcorreo,proveedor, estado);
        String resultado = ContactoConexion.Mantenimientocontacto("insertar", contactoomodelo);    
        switch (resultado) 
        {
            case "OK": 

                    JOptionPane.showMessageDialog(null, "Contacto ingresado con éxito.");                                   
            break;
            
             case "errCorreo":
                JOptionPane.showMessageDialog(null, "Correo ya registrado.");
                error = true;
            break;
            case "errTelefono":
                JOptionPane.showMessageDialog(null, "El telefono ya se encuentra registrado.");
                error = true;
            break;
            default:
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error al ejecutar la operación.");
                error = true;
            break;
        }
        return error;
    }

     private static boolean Modificarcontacto(Integer id,String trimmednombre,String trimmedtelefono,
            String trimmedcorreo,Integer proveedor, String estado )
    {
        boolean error = false;
        ContactoModelo contactoomodelo = new ContactoModelo();
        contactoomodelo = ContactoContralador.Setcontactomodelo(id, 
                trimmednombre, trimmedtelefono,trimmedcorreo,proveedor, estado);
        String resultado = ContactoConexion.Mantenimientocontacto("editar", contactoomodelo);    
        switch (resultado) 
        {
            case "OK": 

                    JOptionPane.showMessageDialog(null, "Contacto editado con éxito.");                                   
            break;
            
             case "errCorreo":
                JOptionPane.showMessageDialog(null, "Correo ya registrado.");
                error = true;
            break;
            case "errTelefono":
                JOptionPane.showMessageDialog(null, "El telefono ya se encuentra registrado.");
                error = true;
            break;
            default:
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error al ejecutar la operación.");
                error = true;
            break;
        }
        return error;
    }   
      public static boolean Eliminarcontacto(Integer id)
    {
        boolean error = false;
        ContactoModelo contactoomodelo = new ContactoModelo();
        contactoomodelo = ContactoContralador.Setcontactomodelo(id,"","","",0,"");
        String resultado = ContactoConexion.Mantenimientocontacto("eliminar", contactoomodelo);    
        switch (resultado) 
        {
            case "OK": 
                   JOptionPane.showMessageDialog(null, "Contacto eliminado con éxito.");    
                   error=true;
            break;
            
        }
        return error;
    }         
    private static ContactoModelo Setcontactomodelo(Integer id, String trimmednombre, String trimmedtelefono,
            String trimmedcorreo,Integer proveedor,String estado)
    {
        ContactoModelo contactomodelo = new ContactoModelo();      
        contactomodelo.setConcodigo(id);
        contactomodelo.setConnombre(trimmednombre);
        contactomodelo.setContelefono(trimmedtelefono);
        contactomodelo.setConcorreo(trimmedcorreo);
        contactomodelo.setProcodigo(proveedor);
        contactomodelo.setConestado(estado);
        return contactomodelo;
    }    
    public static void Llenartablacontacto(JTable tablacotnacto, String accion) 
    {  
        
        DefaultTableModel modelo = (DefaultTableModel) tablacotnacto.getModel(); 
        modelo.setRowCount(0);
        ArrayList<ContactoModelo> contactos = new ArrayList<>();
        contactos = ContactoConexion.Listadocontacto(accion);
        for (int i = 0; i <contactos.size(); i++) 
        {
            modelo.addRow
            (new Object[]
                {
                    contactos.get(i).getConcodigo(), 
                    contactos.get(i).getConnombre(),
                    contactos.get(i).getContelefono(),
                    contactos.get(i).getConcorreo(),
                    contactos.get(i).getPronombre(),
                    contactos.get(i).getConestado()
                    
                }
            );
        } 
        FormatoTabla(tablacotnacto, modelo.getColumnCount());
    }     
    public static Integer SetdatosromCache(JTextField txtnombre,JTextField txttelefono,
                JTextField txtcorreo,JComboBox cmbproveedor, JComboBox cmbestado)
    {
        Integer ConId = null;
        CacheContacto contactocache = new CacheContacto();
       
        if(contactocache.isDatosCompartidos())
        {
            ConId = contactocache.getContacto().getConcodigo();
            txtnombre.setText(contactocache.getContacto().getConnombre());
            txttelefono.setText(contactocache.getContacto().getContelefono());
            txtcorreo.setText(contactocache.getContacto().getConcorreo());
            cmbproveedor.setSelectedItem(contactocache.getContacto().getPronombre());
            cmbestado.setSelectedItem(contactocache.getContacto().getConestado());
        }
        return ConId;
    }
    public static void Llenarcmbproveedor(JComboBox CmbProveedor)
    {
        ArrayList<ProveedoresModelo> proveedores = new ArrayList<>();
        proveedores = ContactoConexion.Listadoproveedores();
        
        for (int i = 0; i<proveedores.size(); i++)
        {
            CmbProveedor.addItem(proveedores.get(i).getPronombre());
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
}
