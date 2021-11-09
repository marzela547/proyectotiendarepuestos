/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Conexiones.TiposConexion;
import static Controladores.ControladorGeneral.FormatoTabla;
import Especiales.PlaceHolder;
import Especiales.Validaciones;
import Modelos.CacheTipo;
import Modelos.TiposModelo;
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
public class TipoControlador {
    static Integer op = 0;
    public static void setPlaceHolders(JTextField txtidentidad)
    {
            PlaceHolder placeholderdescripcion = new PlaceHolder("Ingrese el Nombre ", txtidentidad);

    }  
    
    
    
    public static Boolean Mantenimientotipo(String accion, Integer id,
            String descripcion, String estado,JLabel errdescripcion)
    { 
        TipoControlador.Erroresnull(errdescripcion);
        String trimmedescripcion = descripcion.trim();
        Boolean mnterror = false;
        Boolean validaciongeneral = false;
        validaciongeneral = TipoControlador.validacionesGenerales( trimmedescripcion, errdescripcion);
        System.out.println(accion);
        if(validaciongeneral == false)
        {
            
            switch(accion)
            {
                case "insertar":
                
                    mnterror = TipoControlador.Insertartipo(trimmedescripcion);
                break;
                
                case "editar":   
                    mnterror = TipoControlador.Modificartipo(id,trimmedescripcion, estado);             
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
        Integer TipId = null;
        CacheTipo cache = new CacheTipo();

        
        if(cache.isDatosCompartidos())
        {
            TipId = cache.getTipo().getTipcodigo();
            txtdescripcion.setText(cache.getTipo().getTipdescripcion());
            cmbestado.setSelectedItem(cache.getTipo().getTipestado());
            
        }
        return TipId;
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
    public static void Llenartablatipo(JTable tablatipos, String accion) 
    {  
        
        DefaultTableModel modelo = (DefaultTableModel) tablatipos.getModel(); 
        modelo.setRowCount(0);
        //Estados estados = new Estados();
        ArrayList<TiposModelo> tipos = new ArrayList<>();
        tipos = TiposConexion.Listadotipos(accion);
        for (int i = 0; i <tipos.size(); i++) 
        {
            modelo.addRow
            (new Object[]
                {
                    tipos.get(i).getTipcodigo(), 
                    tipos.get(i).getTipdescripcion(),
                    tipos.get(i).getTipestado()
                    
                }
            );
        } 
        FormatoTabla(tablatipos, modelo.getColumnCount());
    }    
    
    private static boolean Insertartipo(String trimmeddescripcion )
    {
        boolean error = false;
        TiposModelo modelo = new TiposModelo();;
        modelo = TipoControlador.Settipos(0, trimmeddescripcion,"ACT");
        String resultado = TiposConexion.Mantenimientotipos("insertar", modelo);    
        System.out.println(resultado);
        switch (resultado) 
        {
            case "OK": 
                   JOptionPane.showMessageDialog(null, "Tipo de producto ingresado con éxito.");              
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
    private static boolean Modificartipo(Integer id, String trimmeddescripcion ,String estado )
    {
        boolean error = false;
        TiposModelo modelo = new TiposModelo();
        modelo = TipoControlador.Settipos(id, trimmeddescripcion,estado);
        String resultado = TiposConexion.Mantenimientotipos("editar", modelo);    
        System.out.println(resultado);
        switch (resultado) 
        {
            case "OK": 
                   JOptionPane.showMessageDialog(null, "Tipo de producto editado con éxito.");              
            break;
            
            case "errDescripcion":
                JOptionPane.showMessageDialog(null, "El nombre del tipo ya se encuentra registrado.");
                error = true;
            break;
            default:
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error al ejecutar la operación.");
                error = true;
            break;
        }
        return error;
    }
    public static boolean Eliminartipo(Integer id)
    {
        boolean error = false;
        TiposModelo modelo = new TiposModelo();
        modelo = TipoControlador.Settipos(id, "","");
        String resultado = TiposConexion.Mantenimientotipos("eliminar", modelo);    

        switch (resultado) 
        {
            case "OK": 
                   JOptionPane.showMessageDialog(null, "El tipo producto se elimino con éxito.");    
                   error=true;
            break;           
        }
        System.out.println("eleminar");
        return error;
    }   
    private static TiposModelo Settipos(Integer id, String trimmeddescipcion,String estado)
    {
        TiposModelo modelo = new TiposModelo();      
        modelo.setTipcodigo(id);
        modelo.setTipdescripcion(trimmeddescipcion);
        modelo.setTipestado(estado);
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
