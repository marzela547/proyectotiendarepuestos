package Controladores;

import Conexiones.RecuperarConexion;
import Conexiones.UsuarioConexion;
import Especiales.PlaceHolder;
import Especiales.Validaciones;
import Modelos.RecuperarModelo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fgodo
 */
public class RecuperarControlador {
    private byte centiseconds = 0;
    private byte seconds = 30;
    private short minutes = 0;
    
    static Integer valorDado = 0;
    static String Usuario ="Paracs1";
   public static String cod()
   {
       return String.valueOf(valorDado);
   }
    
    public static boolean RecuperarContrasena(String txtcorreo,JLabel errcorreo){
        
        
        errcorreo.setText(null);
        boolean validaciongenerales= false;
        boolean errm= false;
        

        if((RecuperarConexion.exiteEmpUsuario(txtcorreo))!=1){
            errcorreo.setText("No existe correo");
            validaciongenerales = true;
        }
        if(Validaciones.validarCampoVacio(txtcorreo) ){
            errcorreo.setText("Es un campo obligatorio");
            validaciongenerales = true;            
        }        
        if(validaciongenerales==false)
        {   
            System.out.println("no te");
            
            errm=RecuperarControlador.EnviarMensaje(txtcorreo);
                       
        }
             
        
        return !(validaciongenerales == false && errm==false);
    
    }
    public static boolean EnviarMensaje(String txtcorreo){
        Random r = new Random();
        valorDado =  r.nextInt(5000)+1;
        Properties propiedad = new Properties();
        propiedad.setProperty("mail.smtp.host", "smtp.gmail.com");
        propiedad.setProperty("mail.smtp.starttls.enable", "true");
        propiedad.setProperty("mail.smtp.port", "587");
        
        Session sesion = Session.getDefaultInstance(propiedad,null);
        
        String correoEnvia = "fd_godoyz@unicah.edu";
        String contrasena = "Brujo123";
        String receptor = txtcorreo;
        String asunto = "RECUPERACIÓN DE CONTRASEÑA";
        String mensaje= String.valueOf(valorDado);
        MimeMessage mail = new MimeMessage(sesion);
        
      
        try {
            mail.setFrom(new InternetAddress (correoEnvia));
            mail.addRecipient(Message.RecipientType.TO, new InternetAddress (receptor));
            mail.setSubject(asunto);
            mail.setText(mensaje);
            
            Transport transportar = sesion.getTransport("smtp");
            transportar.connect(correoEnvia,contrasena);
            transportar.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));          
            transportar.close();
            
            JOptionPane.showMessageDialog(null, "Listo, revise su correo");
             return false;
        } catch (Exception ex) {
            
            System.err.println("Error: "+ex);
            return true;
        }         
    }
    private Timer  timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random r = new Random();
                if (centiseconds > 0) {
                    centiseconds--;
                } else {
                    if (seconds == 0 && minutes == 0) {
                        valorDado = r.nextInt(5000)+1; 
                        timer.stop();
                        
                       
                    } else if (seconds > 0) {
                        seconds--;
                        centiseconds = 99;
                    } else if (minutes > 0) {
                        minutes--;
                        seconds = 59;
                        centiseconds = 99;
                    }
                }
            }
     });
    
    public static boolean IngresarCodigo(String codigo,JLabel errcodigo){
        
        System.out.println(codigo);
        System.out.println(RecuperarControlador.cod());
        boolean validaciongenerales= false;
        
        if(Validaciones.validarCampoVacio(codigo) ){
            errcodigo.setText("Es un campo obligatorio");
            validaciongenerales = true;            
        }
        if(!RecuperarControlador.cod().equals(codigo))
        {
            errcodigo.setText("Codigo erroneo");
            validaciongenerales = true;  
        } 
                     
        
        return validaciongenerales;
    
    }    
    
    public static void setPlaceHolders(JTextField txtusuario,JTextField txtactualcontra, JTextField txtcontrac)
    {
            PlaceHolder placeholderusuario = new PlaceHolder("Ingrese el Usuario ", txtusuario);
            PlaceHolder placeholdercontra = new PlaceHolder("Ingrese nueva Contraseña", txtactualcontra);
            PlaceHolder placeholdercontrannue = new PlaceHolder("Confirmar la Contraseña ", txtcontrac);

    }
        public static void setPlaceHoldersCodigo(JTextField txtusuario,JTextField txtactualcontra)
    {
            PlaceHolder placeholderusuario = new PlaceHolder("Ingrese el Correo", txtusuario);
            PlaceHolder placeholdercontra = new PlaceHolder("Ingrese Codigo", txtactualcontra);

    }  
    public static boolean MantenimientoContrasena(String usuario,String contrasenan, 
            String contrasenac, JLabel errcontrasenan,JLabel errcontrasenac)
    {
        boolean errautorizacion = false;
        boolean mnterror = false; 
        errcontrasenan.setText(null);
        errcontrasenac.setText(null);
        String trimmedcontran = contrasenan.trim();
        String trimmedcontrac = contrasenac.trim();
        Boolean validacionesgenerales = false;
        validacionesgenerales = RecuperarControlador.validacionesGenerales(Usuario,trimmedcontran, trimmedcontrac, 
                                                                            errcontrasenan,errcontrasenac);
        if(!validacionesgenerales)
        {              
                System.out.println("llego");    
                mnterror = RecuperarControlador.ModificarContrasena(trimmedcontran);

        }
        
         return !(mnterror == false && validacionesgenerales == false && errautorizacion ==false);
    }  
    private static boolean ModificarContrasena(String trimmedcontrasena )
    {
        System.out.println("llego2"); 
        boolean error = false;
        String hash = null;
        RecuperarModelo recuperarModelo = new RecuperarModelo();
        hash = EmpleadoControlador.sha256Encryption(trimmedcontrasena);
        System.out.println("llego 3"); 
        recuperarModelo = RecuperarControlador.Setcontrasena(hash);
        System.out.println("lleg4"); 
        String resultado = UsuarioConexion.MantenimientoEditarContra("contrasena", recuperarModelo);    
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
    private static boolean validacionesGenerales(String usuario,String contrasenanu,String contrasenaco,
                JLabel errcontrasenanu,JLabel errcontrasenaco)
    {
        boolean error = false;
        
        if(Validaciones.validarCampoVacio(usuario))
        {
           //errusuario.setText("Usuario es obligatorio");
           error = true;
        }
        
        if(Validaciones.validarCampoVacio(contrasenanu))
        {
           errcontrasenanu.setText("Confirmacion es obligatorio");
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
        return error;

    }
    private static RecuperarModelo Setcontrasena(String contrasena)
    {
        RecuperarModelo recuperarModelo = new RecuperarModelo();  
        recuperarModelo.setEmpCodigo(0);
        recuperarModelo.setEmpUsuario(Usuario);
        recuperarModelo.setContrasena(contrasena);
        return recuperarModelo;
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
    public static void setusuario(String usuario){
         Usuario = usuario ;
    }
     public static String getusuario(){
        return Usuario ;
    }   
}
