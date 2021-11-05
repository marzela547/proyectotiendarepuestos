package Controladores;

import Conexiones.RecuperarConexion;
import Especiales.Validaciones;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    
   
    
    public static boolean RecuperarContrasena(String txtcorreo,JLabel errcorreo){
        
        
        boolean validaciongenerales= false;
        boolean errm= false;
        
        if(Validaciones.validarCampoVacio(txtcorreo) ){
            errcorreo.setText("Es un campo obligatorio");
            validaciongenerales = true;            
        }
        if((RecuperarConexion.exiteEmpUsuario(txtcorreo))!=1){
            errcorreo.setText("No existe correo");
            validaciongenerales = true;
        }
        
        if(validaciongenerales==false)
        {
            
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
             return true;
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
}
