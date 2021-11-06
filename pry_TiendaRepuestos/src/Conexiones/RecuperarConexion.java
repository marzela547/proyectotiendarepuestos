package Conexiones;


import Conexiones.Conexion;
import Controladores.RecuperarControlador;
import Modelos.RecuperarModelo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fgodo
 */
public class RecuperarConexion {
    
    
    public static Integer  exiteEmpUsuario(String EmpCorreo) 
    {
        Connection con = null;
        Statement stm;
        ResultSet rss;
        Integer valor = 0; 
        RecuperarModelo recuperarModelo = new RecuperarModelo();
         try 
        {
            con = Conexion.getConexion(con);
            stm = con.createStatement();
            String query = "SELECT count(Empcodigo) as contador, Empusuario,Empcodigo FROM empleados WHERE  Empcorreo='"+EmpCorreo+"'";
                                
            rss = stm.executeQuery(query);
            
            while (rss.next()) 
            {
                valor=rss.getInt("contador");
                recuperarModelo.setEmpUsuario(rss.getString("Empusuario"));              
            }
            RecuperarControlador.setusuario(recuperarModelo.getEmpUsuario());
            con.close();
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,e);
        }  
        return valor;           
    }    
        
    
    
    
    
}
