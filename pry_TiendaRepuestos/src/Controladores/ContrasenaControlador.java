/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Conexiones.EmpleadosConexion;
import Conexiones.UsuarioConexion;
import Especiales.PlaceHolder;
import Especiales.Validaciones;
import Modelos.CacheLogin;
import Modelos.EmpleadosModelo;
import java.security.MessageDigest;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author fgodo
 */
public class ContrasenaControlador {
    public static void setPlaceHolders(JTextField txtusuario,JTextField txtactualcontra, JTextField txtcontranue,JTextField txtcontranuec)
    {
            PlaceHolder placeholderusuario = new PlaceHolder("Ingrese el Usuario ", txtusuario);
            PlaceHolder placeholdercontra = new PlaceHolder("Ingrese la Contraseña Actual", txtactualcontra);
            PlaceHolder placeholdercontrannue = new PlaceHolder("Ingrese la nueva Contraseña ", txtcontranue);
            PlaceHolder placeholdercontraco = new PlaceHolder("Confirme la Contraseña ", txtcontranuec);

    }  
    public static boolean MantenimientoContrasena(String usuario, String contrasena, String contrasenan, 
            String contrasenac, JLabel errcontrasena, JLabel errcontrasenan,JLabel errcontrasenac)
    {
        boolean errautorizacion = false;
        boolean mnterror = false; 
        errcontrasena.setText(null);
        errcontrasenan.setText(null);
        errcontrasenac.setText(null);
        
        String trimmedcontran = contrasenan.trim();
        String trimmedcontrac = contrasenac.trim();
        Boolean validacionesgenerales = false;
        validacionesgenerales = ContrasenaControlador.validacionesGenerales(usuario, contrasena, trimmedcontran, 
                                                                    trimmedcontrac, errcontrasena ,errcontrasenan,errcontrasenac);
        if(!validacionesgenerales)
        {
            EmpleadosModelo empleadoModelo = new EmpleadosModelo(); 
                empleadoModelo = UsuarioConexion.ObtenerUsuario(usuario);
                String bddContrasenia = empleadoModelo.getEmpcontrasena();

                if(compararContraseniaEncriptada(bddContrasenia, contrasena))
                {
                    System.out.println("");
 
                    mnterror = ContrasenaControlador.ModificarContrasena(usuario,trimmedcontran);
                       
                                               
                }
                else
                {
                    errautorizacion = true;
                    errcontrasena.setText("Contraseña incorrecta.");
                }

        }
        
         return !(mnterror == false && validacionesgenerales == false && errautorizacion ==false);
    }  
    private static boolean ModificarContrasena(String usuario,String trimmedcontrasena )
    {
        boolean error = false;
        String hash = null;
        EmpleadosModelo empleadomodelo = new EmpleadosModelo();
        hash = EmpleadoControlador.sha256Encryption(trimmedcontrasena);
        empleadomodelo = ContrasenaControlador.Setcontrasena(usuario,hash);
        String resultado = EmpleadosConexion.MantenimientoContrasena("contrasena", empleadomodelo);    
        switch (resultado) 
        {
            case "OK": 
                   JOptionPane.showMessageDialog(null, "Se cambio la contraña con éxito.");              
            break;
        
            default:
                
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error al ejecutar la operación.");
                error = true;
            break;
        }
        return error;
    } 
    private static boolean validacionesGenerales(String usuario,String contrasenaac,String contrasenanu,String contrasenaco,
                JLabel errcontrasenaac,JLabel errcontrasenanu,JLabel errcontrasenaco)
    {
        boolean error = false;
        
        if(Validaciones.validarCampoVacio(usuario))
        {
           //errusuario.setText("Usuario es obligatorio");
           error = true;
        }
        
        if(Validaciones.validarCampoVacio(contrasenaac))
        {
           System.out.println("llego");
           errcontrasenaac.setText("Contraseña es obligatoria");
           error = true;
        }
        if(Validaciones.validarCampoVacio(contrasenanu))
        {
           errcontrasenanu.setText("Nueva Contraseña es obligatoria");
           error = true;
        }
        if(Validaciones.validarCampoVacio(contrasenaco))
        {
           errcontrasenaco.setText("Confirmacion es obligatorio");
           error = true;
        }
        if(Validaciones.validarContrasenia(contrasenanu))
        {
           errcontrasenanu.setText("Debe de incluir mayusculas y numeros");
           error = true;
        }  
        if(Validaciones.validarContraseniaCoincide(contrasenanu,contrasenaco))
        {
           errcontrasenaco.setText("No concuerda con la nueva contraseña");
           error = true;
        }  
        System.out.println("llego 1");
        return error;

    }
    private static EmpleadosModelo Setcontrasena(String usuario,String contrasena)
    {
        EmpleadosModelo empleadomodelo = new EmpleadosModelo();  
        empleadomodelo.setEmpcodigo(CacheLogin.getEmpCodigo());
        empleadomodelo.setEmpidentidad("0000-00-00");
        empleadomodelo.setEmpnombre("Nulo");
        empleadomodelo.setEmptelefono("00000000");
        empleadomodelo.setEmpfechanacimiento("0000-00-00");
        empleadomodelo.setEmpcorreo("Nulo");
        empleadomodelo.setEmpdireccion("Nulo");
        empleadomodelo.setEmpfechaingreso("0000-00-00");
        empleadomodelo.setEmpfechasalidad("0000-00-00");
        empleadomodelo.setEmpestado("Nulo");
        empleadomodelo.setEmpusuario(usuario);
        empleadomodelo.setEmpcontrasena(contrasena);
        return empleadomodelo;
    }   
    
    private static boolean compararContraseniaEncriptada(String cotraseniaBdd, 
            String contraseniaIngresada)
    {
        boolean valido = false; 
       
        String hashedpassword = EmpleadoControlador.sha256Encryption(contraseniaIngresada);

        if(hashedpassword.equals(cotraseniaBdd))
        {
            valido = true;
        }
        
       return valido;
    }
    public static String sha256Encryption(String data)
    {
        StringBuffer sb = new StringBuffer();
        try
        {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(data.getBytes());
            byte byteData[] = md.digest();

            for (int i = 0; i < byteData.length; i++) 
            {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return sb.toString();
    }    
}
