/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Conexiones.MarcasConexion;
import static Controladores.ControladorGeneral.FormatoTabla;
import Especiales.PlaceHolder;
import Especiales.Validaciones;
import Modelos.CacheMarca;
import Modelos.MarcasModelo;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author marce
 */
public class MarcaControlador {
    static Integer op = 0;
    
    public static void setPlaceHolders(JTextField txtidentidad)
    {
            PlaceHolder placeholderdescripcion = new PlaceHolder("Ingrese el Nombre ", txtidentidad);

    } 
    public static Boolean Mantenimientomarcas(String accion, Integer id,
            String descripcion, String estado,JLabel errdescripcion)
    { 
        MarcaControlador.Erroresnull(errdescripcion);
        String trimmedescripcion = descripcion.trim();
        Boolean mnterror = false;
        Boolean validaciongeneral = false;
        validaciongeneral = MarcaControlador.validacionesGenerales( trimmedescripcion, errdescripcion);
        System.out.println(accion);
        if(validaciongeneral == false)
        {
            
            switch(accion)
            {
                case "insertar":
                
                    mnterror = MarcaControlador.Insertarmarca(trimmedescripcion);
                break;
                
                case "editar":   
                    mnterror = MarcaControlador.Modificarmarca(id,trimmedescripcion, estado);             
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
        Integer MarId = null;
        CacheMarca cache = new CacheMarca();

        
        if(cache.isDatosCompartidos())
        {
            MarId = cache.getMarca().getMarcodigo();
            txtdescripcion.setText(cache.getMarca().getMardescripcion());
            cmbestado.setSelectedItem(cache.getMarca().getMarestado());
            
        }
        return MarId;
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
    public static void Llenartablamarca(JTable tablamarcas, String accion) 
    {  
        
        DefaultTableModel modelo = (DefaultTableModel) tablamarcas.getModel(); 
        modelo.setRowCount(0);
        //Estados estados = new Estados();
        ArrayList<MarcasModelo> marcas = new ArrayList<>();
        marcas = MarcasConexion.Listadomarcas(accion);
        for (int i = 0; i <marcas.size(); i++) 
        {
            modelo.addRow
            (new Object[]
                {
                    marcas.get(i).getMarcodigo(), 
                    marcas.get(i).getMardescripcion(),
                    marcas.get(i).getMarestado()
                    
                }
            );
        } 
        FormatoTabla(tablamarcas, modelo.getColumnCount());
    }
    private static boolean Insertarmarca(String trimmeddescripcion )
    {
        boolean error = false;
        MarcasModelo modelo = new MarcasModelo();;
        modelo = MarcaControlador.Setmarcas(0, trimmeddescripcion,"ACT");
        String resultado = MarcasConexion.Mantenimientomarcas("insertar", modelo);    
        System.out.println(resultado);
        switch (resultado) 
        {
            case "OK": 
                   JOptionPane.showMessageDialog(null, "Marca ingresada con éxito.");              
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
    private static boolean Modificarmarca(Integer id, String trimmeddescripcion ,String estado )
    {
        boolean error = false;
        MarcasModelo modelo = new MarcasModelo();
        modelo = MarcaControlador.Setmarcas(id, trimmeddescripcion,estado);
        String resultado = MarcasConexion.Mantenimientomarcas("editar", modelo);    
        System.out.println(resultado);
        switch (resultado) 
        {
            case "OK": 
                   JOptionPane.showMessageDialog(null, "Marca editada con éxito.");              
            break;
            
            case "errDescripcion":
                JOptionPane.showMessageDialog(null, "El nombre de la marca ya se encuentra registrado.");
                error = true;
            break;
            default:
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error al ejecutar la operación.");
                error = true;
            break;
        }
        return error;
    }
    public static boolean Eliminarmarca(Integer id)
    {
        boolean error = false;
        MarcasModelo modelo = new MarcasModelo();
        modelo = MarcaControlador.Setmarcas(id, "","");
        String resultado = MarcasConexion.Mantenimientomarcas("eliminar", modelo);    

        switch (resultado) 
        {
            case "OK": 
                   JOptionPane.showMessageDialog(null, "La marca se eliminó con éxito.");    
                   error=true;
            break;           
        }
        System.out.println("eleminar");
        return error;
    }   
    private static MarcasModelo Setmarcas(Integer id, String trimmeddescipcion,String estado)
    {
        MarcasModelo modelo = new MarcasModelo();      
        modelo.setMarcodigo(id);
        modelo.setMardescripcion(trimmeddescipcion);
        modelo.setMarestado(estado);
        return modelo;
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
