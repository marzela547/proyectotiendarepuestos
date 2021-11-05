/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Conexiones.UsuarioConexion;
import Especiales.PlaceHolder;
import Especiales.Validaciones;
import Modelos.CacheLogin;
import Modelos.EmpleadosModelo;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author fgodo
 */
public class LoginControlador {
    
    public static void setPlaceHolders(JTextField txtusuario, JTextField txtcontrasena){

            PlaceHolder  placeholderUsuario = new PlaceHolder(" Ingresar Usuario", txtusuario);
            PlaceHolder placeholde = new PlaceHolder("Ingrese la Contraseña", txtcontrasena);

    }      
    
    
    public static boolean verificarIniciarSesion(String usuario, 
            String contrasena, JLabel errUsuario, JLabel errContrasena)
    {
        boolean autorizacion = false;            
        errUsuario.setText(null);
        errContrasena.setText(null);
        Boolean validacionesgenerales = false;
        validacionesgenerales = LoginControlador.validacionesGenerales(usuario, contrasena, errUsuario, errContrasena);
        System.out.println(validacionesgenerales);
        if(!validacionesgenerales)
        {
            EmpleadosModelo empleadoModelo = new EmpleadosModelo(); 
            empleadoModelo = UsuarioConexion.ObtenerUsuario(usuario);

            if(empleadoModelo.getEmpcodigo()!= null)
            {
                String bddContrasenia = empleadoModelo.getEmpcontrasena();

                if(compararContraseniaEncriptada(bddContrasenia, contrasena))
                {
                    CacheLogin.setEmpCodigo(empleadoModelo.getEmpcodigo());
                    CacheLogin.setEmpnombre(empleadoModelo.getEmpnombre());
                    CacheLogin.setEmpUsuario(empleadoModelo.getEmpusuario());
                    CacheLogin.setEmpcorreo(empleadoModelo.getEmpcorreo()); 

                    if(empleadoModelo.getEmpestado().equals("ACT"))
                    {
                        autorizacion = true;
                                               
                    }
                    else
                    {
                        errUsuario.setText("Usuario inactivo.");
                    }
                }
                else
                {
                    errContrasena.setText("Contraseña incorrecta.");
                }
            }
            else
            {
                errUsuario.setText("Las credenciales son incorrectas.");
                
            }
        }
        
        return autorizacion;
    }    
    

    private static boolean validacionesGenerales(String usuario,String contrasena,JLabel errusuario,JLabel errccontra)
    {
        boolean error = false;
        
        if(Validaciones.validarCampoVacio(usuario))
        {
           errusuario.setText("Usuario es obligatorio");
           error = true;
        }
        if(Validaciones.validarCampoVacio(contrasena))
        {
           errccontra.setText("Contraseña es obligatoria");
           error = true;
        }
         
        return error;

    }

    public static void Logout()
    {
        CacheLogin.setEmpCodigo(null);
        CacheLogin.setEmpnombre(null);
        CacheLogin.setEmpcorreo(null);
        CacheLogin.setEmpUsuario(null);
        
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
    
    
}
