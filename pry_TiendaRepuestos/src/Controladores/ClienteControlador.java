/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;
import Conexiones.ClientesConexion;
import static Controladores.ControladorGeneral.FormatoTabla;
import Especiales.PlaceHolder;
import Modelos.CacheCliente;
import Modelos.ClientesModelo;
import Especiales.Validaciones;

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
public class ClienteControlador {
    static Integer op = 0;
    
    
    
    public static void setPlaceHolders(JTextField txtNombre, JTextField txtRTN, JTextField txtTelefono)
    {
        PlaceHolder placeholderNombre = new PlaceHolder(" Ingrese el nombre del cliente", txtNombre);
        PlaceHolder placeholderRTN = new PlaceHolder(" Ingrese el RTN del cliente", txtRTN);
        PlaceHolder placeholderTel = new PlaceHolder(" Ingrese el teléfono del cliente", txtTelefono);
    }
    public static Boolean Mantenimientocliente(String accion, Integer id,
             String nombre, String RTN, String telefono , String estado,
            JLabel errRTN, JLabel errnombre, JLabel errtelefono)
    { 
        ClienteControlador.Erroresnull(errRTN,errnombre, errtelefono);
        String trimmedRTN = RTN.trim();
        String trimmednombre = nombre.trim();
        String trimmedtelefono = telefono.trim();
        Boolean mnterror = false;
        Boolean validaciongeneral = false;
        validaciongeneral = ClienteControlador.validacionesGenerales( trimmedRTN,trimmednombre, 
               trimmedtelefono, errRTN,errnombre, errtelefono);
        
        if(validaciongeneral == false)
        //{
            
            switch(accion)
            {
                case "insertar":
                
                    mnterror = ClienteControlador.Insertarcliente(trimmedRTN, trimmednombre,
                            trimmedtelefono, estado);
                break;
                
                case "editar":   
                    mnterror = ClienteControlador.Modificarcliente(id,trimmedRTN, trimmednombre,
                            trimmedtelefono, estado);             
                break;
            }
        //}
        
        return !(mnterror == false && validaciongeneral == false);
    }
    private static void Erroresnull(JLabel errRTN, JLabel errnombre, JLabel errtelefono )
    {
        errnombre.setText(null);
        errRTN.setText(null);
        errtelefono.setText(null);
    }
    
    private static boolean validacionesGenerales(String trimmedRTN,String trimmednombre,
        String trimmedtelefono, JLabel errRTN,JLabel errnombre,JLabel errtelefono)
    {
        boolean error = false;
        
        if(Validaciones.validarCampoVacio(trimmedRTN))
        {
           errRTN.setText("Es un campo obligatorio");
           error = true;
        }
        if(!Validaciones.validarIdentidad(trimmedRTN))
        {
           errRTN.setText("Formato incorrecto [####-####-######]");
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
           
        return error;
    }
    private static boolean Insertarcliente(String trimmedRTN,String trimmednombre,String trimmedtelefono,String estado )
    {
        System.out.println("llego insertar");
        boolean error = false;
        ClientesModelo clientemodelo = new ClientesModelo();
        clientemodelo = ClienteControlador.Setclientemodelo(0, trimmedRTN, trimmednombre, trimmedtelefono, "ACT");
        String resultado = ClientesConexion.Mantenimientoclientes("insertar", clientemodelo);    
        System.out.println(resultado);
        switch (resultado) 
        {
            case "OK": 
                    System.out.println("llego insertar 5");
                   JOptionPane.showMessageDialog(null, "Cliente ingresado con éxito.");              
            break;
            
            case "errNombre":
                System.out.println("llego insertar 6");
                JOptionPane.showMessageDialog(null, "El Nombre ya se encuentra registrado.");
                error = true;
            break;
             case "errRTN":
                 System.out.println("llego insertar 7");
                JOptionPane.showMessageDialog(null, "El RTN ya se encuentra registrado.");
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
    private static boolean Modificarcliente(Integer id,String trimmedRTN,String trimmednombre,String trimmedtelefono,String estado )
    {
        boolean error = false;
        System.out.println("llegue");
        ClientesModelo clientemodelo = new ClientesModelo();
        clientemodelo = ClienteControlador.Setclientemodelo(id, trimmedRTN,
                trimmednombre, trimmedtelefono, estado);
        String resultado = ClientesConexion.Mantenimientoclientes("editar", clientemodelo);    
          System.out.println(clientemodelo);
        System.out.println(resultado);
        switch (resultado) 
        {
            case "OK": 
                   JOptionPane.showMessageDialog(null, "Cliente editado con éxito.");              
            break;
            
            case "errNombre":
                JOptionPane.showMessageDialog(null, "El Nombre ya se encuentra registrado.");
                error = true;
            break;
             case "errRTN":
                JOptionPane.showMessageDialog(null, "RTN ya se encuentra registrado.");
                error = true;
            break;
            case "errTelefono":
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
    public static boolean Eliminarcliente(Integer id)
    {
        boolean error = false;
        System.out.println("llegue");
        ClientesModelo clientemodelo = new ClientesModelo();
        clientemodelo = ClienteControlador.Setclientemodelo(id, "","", "","");
        String resultado = ClientesConexion.Mantenimientoclientes("eliminar", clientemodelo);    
        switch (resultado) 
        {
            case "OK": 
                   JOptionPane.showMessageDialog(null, "Cliente eliminado con éxito.");    
                   error=true;
            break;
            
        }
        return error;
    }    
 
    private static ClientesModelo Setclientemodelo(Integer id, String trimmedRTN,
            String trimmednombre, String trimmedtelefono,String estado)
    {
        ClientesModelo clientemodelo = new ClientesModelo();     
        clientemodelo.setClicodigo(id);
        clientemodelo.setRTN(trimmedRTN);
        clientemodelo.setClinombre(trimmednombre);
        clientemodelo.setClitelefono(trimmedtelefono);
        clientemodelo.setCliestado(estado);
        return clientemodelo;
    }
    
    public static void Llenartablacliente(JTable tablacliente, String accion) 
    {  
        
        DefaultTableModel modelo = (DefaultTableModel) tablacliente.getModel(); 
        modelo.setRowCount(0);
        //Estados estados = new Estados();
        ArrayList<ClientesModelo> clientes = new ArrayList<>();
        clientes = ClientesConexion.Listadocliente(accion);
        for (int i = 0; i <clientes.size(); i++) 
        {
            modelo.addRow
            (new Object[]
                {
                    clientes.get(i).getClicodigo(), 
                    clientes.get(i).getRTN(),
                    clientes.get(i).getClinombre(),
                    clientes.get(i).getClitelefono(),
                    clientes.get(i).getCliestado()
                    
                }
            );
        } 
        FormatoTabla(tablacliente, modelo.getColumnCount());
    }

    public static Integer SetdatosromCache(JTextField txtRTN,JTextField txtnombre,JTextField txttelefono, JComboBox cmbestado)
    {
        Integer CliId = null;
        CacheCliente clicache = new CacheCliente();
  
        
        if(clicache.isDatosCompartidos())
        {
            CliId = clicache.getCliente().getClicodigo();
            txtRTN.setText(clicache.getCliente().getRTN());
            txtnombre.setText(clicache.getCliente().getClinombre());
            txttelefono.setText(clicache.getCliente().getClitelefono());
            cmbestado.setSelectedItem(clicache.getCliente().getCliestado());
           // KitController.LlenarTableDetalleKit(KitId);
            
        }
        return CliId;
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
