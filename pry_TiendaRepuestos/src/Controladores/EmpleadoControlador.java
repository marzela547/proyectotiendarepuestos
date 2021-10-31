/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Conexiones.EmpleadosConexion;
import Modelos.EmpleadosModelo;
import Modelos.PuestoModelo;
import Utils.Validators.Validaciones;

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
public class EmpleadoControlador {
    
    public static Boolean Mantenimientoempelado(String accion, Integer id,
            String identidad, String nombre, String telefono , String fechanacimiento, 
            String correo,String direccion ,String fechaningreso, String fechasalida,  String estado,
            JLabel erridentidad, JLabel errnombre, JLabel errtelefono, JLabel errfechanacimiento,
            JLabel errcorreo,JLabel errdireccion, JLabel errfechaingreso,JLabel errfechasalida)
    { 
        
        
        System.out.println("llego mante");
        EmpleadoControlador.Erroresnull(erridentidad,errnombre, errtelefono, errfechanacimiento, errcorreo,
                                            errdireccion,errfechaingreso,errfechasalida);
        String trimmedidentidad = identidad.trim();
        String trimmednombre = nombre.trim();
        String trimmedtelefono = telefono.trim();
        String trimmedfechanacimiento = fechanacimiento.trim();
        String trimmedcorreo = correo.trim();
        String trimmeddireccion = direccion.trim(); 
        String trimmedfechaningreso = fechaningreso.trim();
        String trimmedfechasalida = fechasalida.trim();
        Boolean mnterror = false;
        Boolean validaciongeneral = false;
        validaciongeneral = EmpleadoControlador.validacionesGenerales( trimmedidentidad,trimmednombre, 
               trimmedtelefono, trimmedfechanacimiento, trimmedcorreo,trimmeddireccion, trimmedfechaningreso, 
               trimmedfechasalida, erridentidad,errnombre, errtelefono,errfechanacimiento, errcorreo,errdireccion,
               errfechaingreso,errfechasalida);
        
        if(validaciongeneral == false)
        //{
            
            switch(accion)
            {
                case "insertar":
                    System.out.println("llego switch");
                    mnterror = EmpleadoControlador.Insertarempleado(trimmedidentidad, trimmednombre,
                            trimmedtelefono, trimmedfechanacimiento,trimmedcorreo,trimmeddireccion,
                            trimmedfechaningreso,trimmedfechasalida, estado);
                break;
                
                /*case "editar":   
                    mntError = CatalogoProductoController.editarProducto(id, 
                            trimmedNombre, trimmedDescripcion, trimmedStockMaximo, 
                            trimmedStockMinimo, id_categoria, estado);              
                break;*/
            }
        //}
        
        return !(mnterror == false && validaciongeneral == false);
    }    
    private static void Erroresnull(JLabel erridentidad, JLabel errnombre, JLabel errtelefono,
            JLabel errfechanacimiento, JLabel errcorreo, JLabel errdireccion ,JLabel errfechaingreso,
            JLabel errfechasalida )
    {
        errnombre.setText(null);
        erridentidad.setText(null);
        errtelefono.setText(null);
        errfechanacimiento.setText(null);
        errcorreo.setText(null);
        errdireccion.setText(null);
        errfechaingreso.setText(null);
        errfechasalida.setText(null);
        System.out.println("llego error null");
    }   
    private static boolean validacionesGenerales(String trimmedidentidad,String trimmednombre,
        String trimmedtelefono, String trimmedfechanacimiento, String trimmedcorreo, String trimmeddireccion,
        String trimmedfechaningreso, String trimmedfechasalida,JLabel erridentidad,JLabel errnombre,JLabel errtelefono,
        JLabel errfechanacimiento,JLabel errcorreo,JLabel errdireccion,JLabel errfechaingreso,JLabel errfechasalida)
    {
        boolean error = false;
        
        if(Validaciones.validarCampoVacio(trimmedidentidad))
        {
           erridentidad.setText("Es un campo obligatorio");
           error = true;
        }
        if(!Validaciones.validarIdentidad(trimmedidentidad))
        {
           erridentidad.setText("Formato incorrecto [####-####-#####]");
           error = true;
        }
        
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
        if(trimmedfechanacimiento=="null")
        {
           errfechanacimiento.setText("Es un campo obligatorio");
           error = true;
        }    
        if(trimmedfechaningreso=="null")
        {
           errfechaingreso.setText("Es un campo obligatorio");
           error = true;
        }   
        if(Validaciones.validarCampoVacio(trimmeddireccion))
        {
           errdireccion.setText("Es un campo obligatorio");
           error = true;
        }    
        System.out.println("llego valida");
        return error;
    }   
    private static boolean Insertarempleado(String trimmedidentidad,String trimmednombre,String trimmedtelefono,
            String trimmedfechanacimiento, String trimmedcorreo,  String trimmeddireccion, String trimmedfechaningreso,
            String trimmedfechasalida,String estado )
    {
        System.out.println("llego insertar");
        boolean error = false;
        EmpleadosModelo empleadomodelo = new EmpleadosModelo();
        System.out.println("llego insertar 1");
        //DefaultTableModel model =(DefaultTableModel) tableProveedores.getModel();
        //CatalogoProductoCache cache = new CatalogoProductoCache();
        //DetalleCatalogoProductosModel detalleproducto = new DetalleCatalogoProductosModel();
        System.out.println("llego insertar 2");
        empleadomodelo = EmpleadoControlador.Setempleadomodelo(0, trimmedidentidad,
                trimmednombre, trimmedtelefono,trimmedfechanacimiento,trimmedcorreo,
                trimmeddireccion,trimmedfechaningreso,"0000-00-00","ACT");
        System.out.println("llego insertar 3");
        String resultado = EmpleadosConexion.Mantenimientoempleados("insertar", empleadomodelo);    
        System.out.println(resultado);
        switch (resultado) 
        {
            case "OK": 
                    System.out.println("llego insertar 5");
                   JOptionPane.showMessageDialog(null, "Producto ingresado con éxito.");              
            break;
            
            case "errNombre":
                System.out.println("llego insertar 6");
                JOptionPane.showMessageDialog(null, "El Nombre ya se encuentra registrado.");
                error = true;
            break;
             case "errIdentidad":
                 System.out.println("llego insertar 7");
                JOptionPane.showMessageDialog(null, "Numero de Identidad ya se encuentra registrado.");
                error = true;
            break;
            case "errTelefono":
                System.out.println("llego insertar 8");
                JOptionPane.showMessageDialog(null, "El telefono ya se encuentra registrado.");
                error = true;
            break;
            default:
                System.out.println("llego insertar 9");
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error al ejecutar la operación.");
                error = true;
            break;
        }
        return error;
    }
    private static EmpleadosModelo Setempleadomodelo(Integer id, String trimmedidentidad,
            String trimmednombre, String trimmedtelefono, String trimmedfechanacimiento,String trimmedcorreo,
            String trimmeddireccion, String trimmedfechaningreso, String trimmedfechasalida,String estado)
    {
        EmpleadosModelo empleadomodelo = new EmpleadosModelo();      
        empleadomodelo.setEmpcodigo(id);
        empleadomodelo.setEmpidentidad(trimmedidentidad);
        empleadomodelo.setEmpnombre(trimmednombre);
        empleadomodelo.setEmptelefono(trimmedtelefono);
        empleadomodelo.setEmpfechanacimiento(trimmedfechanacimiento);
        empleadomodelo.setEmpcorreo(trimmedcorreo);
        empleadomodelo.setEmpdireccion(trimmeddireccion);
        empleadomodelo.setEmpfechaingreso(trimmedfechaningreso);
        empleadomodelo.setEmpfechasalidad(trimmedfechasalida);
        empleadomodelo.setEmpestado(estado);
        System.out.println("llego set");
        return empleadomodelo;
    }
           
    public static void AgregarPuesto(Object[] dataRow,JTable tabla_puestos )
    {
        DefaultTableModel model =(DefaultTableModel) tabla_puestos.getModel();
        
        boolean rp= false;  

           for(int i =0 ; i<model.getRowCount();i++)
           {

                   if(model.getValueAt(i, 0) == dataRow[0] )
                   {
                       rp=true;
                   }            
           }       
        
            if(rp==false)
            {
                model.addRow(dataRow);     
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Puesto ya seleccionado.");
            }         
         
    }
    public static void Quitarpuestosseleccionados( String puesto_descripcion,JTable tabla_puestos  )
    {
   
        DefaultTableModel model =(DefaultTableModel) tabla_puestos.getModel();
        for(int i = 0; i < model.getRowCount(); i++  )
        {
            if(puesto_descripcion == model.getValueAt(i, 0)){
                model.removeRow(i);
            }  
        }
    }
        public static void Llenarcmbpuestos(JComboBox CmbPuesto)
    {
        ArrayList<PuestoModelo> puestos = new ArrayList<>();
        puestos = EmpleadosConexion.Listadopuestos();
        
        for (int i = 0; i<puestos.size(); i++)
        {
            CmbPuesto.addItem(puestos.get(i).getPuedescripcion());
        }
    }
}
