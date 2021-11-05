/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;


import Conexiones.PuestosConexion;
import static Controladores.ControladorGeneral.FormatoTabla;
import static Controladores.EmpleadoControlador.op;
import Especiales.PlaceHolder;
import Modelos.CachePuesto;
import Modelos.EmpleadosModelo;
import Modelos.PuestoModelo;
import Especiales.Validaciones;

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
public class PuestoControlador {
    static Integer op = 0;
    public static void setPlaceHolders(JTextField txtidentidad)
    {
            PlaceHolder placeholderdescripcion = new PlaceHolder("Ingrese el Nombre ", txtidentidad);

    }  
    
    
    
    public static Boolean Mantenimientopuesto(String accion, Integer id,
            String descripcion, String estado,JLabel errdescripcion)
    { 
        PuestoControlador.Erroresnull(errdescripcion);
        String trimmedescripcion = descripcion.trim();
        Boolean mnterror = false;
        Boolean validaciongeneral = false;
        validaciongeneral = PuestoControlador.validacionesGenerales( trimmedescripcion, errdescripcion);
        System.out.println(accion);
        if(validaciongeneral == false)
        {
            
            switch(accion)
            {
                case "insertar":
                
                    mnterror = PuestoControlador.Insertarpuesto(trimmedescripcion);
                break;
                
                case "editar":   
                    mnterror = PuestoControlador.Modificarpuesto(id,trimmedescripcion, estado);             
                break;
            }
        }
        
        return !(mnterror == false && validaciongeneral == false);
    }
    private static void Erroresnull(JLabel errdescripcion)
    {
        errdescripcion.setText(null);

    } 
    public static Integer SetdatosromCache(JTextField txtdescripcion, JComboBox cmbestado)
    {
        Integer PueId = null;
        CachePuesto puestocache = new CachePuesto();

        
        if(puestocache.isDatosCompartidos())
        {
            PueId = puestocache.getPuesto().getPuecodigo();
            txtdescripcion.setText(puestocache.getPuesto().getPuedescripcion());
            cmbestado.setSelectedItem(puestocache.getPuesto().getPueestado());
            
        }
        return PueId;
    }    
   private static boolean validacionesGenerales(String trimmedescripcion,JLabel errdescripcion)
    {
        boolean error = false;
        
        if(Validaciones.validarCampoVacio(trimmedescripcion))
        {
           errdescripcion.setText("Es un campo obligatorio");
           error = true;
        }
        if(!Validaciones.validarLetras(trimmedescripcion))
        {
           errdescripcion.setText("Es un campo alfabetico");
           error = true;
        }
        return error;
    } 
    public static void Llenartablaempleado(JTable tablapuestos, String accion) 
    {  
        
        DefaultTableModel modelo = (DefaultTableModel) tablapuestos.getModel(); 
        modelo.setRowCount(0);
        //Estados estados = new Estados();
        ArrayList<PuestoModelo> puestos = new ArrayList<>();
        puestos = PuestosConexion.Listadopuestos(accion);
        for (int i = 0; i <puestos.size(); i++) 
        {
            modelo.addRow
            (new Object[]
                {
                    puestos.get(i).getPuecodigo(), 
                    puestos.get(i).getPuedescripcion(),
                    puestos.get(i).getPueestado()
                    
                }
            );
        } 
        FormatoTabla(tablapuestos, modelo.getColumnCount());
    }    
    
    private static boolean Insertarpuesto(String trimmeddescripcion )
    {
        boolean error = false;
        PuestoModelo puestomodelo = new PuestoModelo();;
        puestomodelo = PuestoControlador.Setpuestos(0, trimmeddescripcion,"ACT");
        String resultado = PuestosConexion.Mantenimientopuestos("insertar", puestomodelo);    
        System.out.println(resultado);
        switch (resultado) 
        {
            case "OK": 
                   JOptionPane.showMessageDialog(null, "Producto ingresado con éxito.");              
            break;
            
            case "errDescripcion":
                JOptionPane.showMessageDialog(null, "El Nombre ya se encuentra registrado.");
                error = true;
            break;
            default:
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error al ejecutar la operación.");
                error = true;
            break;
        }
        return error;
    }    
    private static boolean Modificarpuesto(Integer id, String trimmeddescripcion ,String estado )
    {
        boolean error = false;
        PuestoModelo puestomodelo = new PuestoModelo();
        puestomodelo = PuestoControlador.Setpuestos(id, trimmeddescripcion,estado);
        String resultado = PuestosConexion.Mantenimientopuestos("editar", puestomodelo);    
        System.out.println(resultado);
        switch (resultado) 
        {
            case "OK": 
                   JOptionPane.showMessageDialog(null, "Producto editado con éxito.");              
            break;
            
            case "errDescripcion":
                JOptionPane.showMessageDialog(null, "El nombre de puesto ya se encuentra registrado.");
                error = true;
            break;
            default:
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error al ejecutar la operación.");
                error = true;
            break;
        }
        return error;
    }
    public static boolean Eliminarpuesto(Integer id)
    {
        boolean error = false;
        PuestoModelo puestomodelo = new PuestoModelo();
        puestomodelo = PuestoControlador.Setpuestos(id, "","");
        String resultado = PuestosConexion.Mantenimientopuestos("eliminar", puestomodelo);    

        switch (resultado) 
        {
            case "OK": 
                   JOptionPane.showMessageDialog(null, "Producto se elimino con éxito.");    
                   error=true;
            break;           
        }
        System.out.println("eleminar");
        return error;
    }   
    private static PuestoModelo Setpuestos(Integer id, String trimmeddescipcion,String estado)
    {
        PuestoModelo puestomodelo = new PuestoModelo();      
        puestomodelo.setPuecodigo(id);
        puestomodelo.setPuedescripcion(trimmeddescipcion);
        puestomodelo.setPueestado(estado);
        return puestomodelo;
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
