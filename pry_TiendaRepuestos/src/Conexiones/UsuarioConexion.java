/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexiones;

import Modelos.EmpleadosModelo;
import Modelos.RecuperarModelo;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import javax.swing.JOptionPane;

/**
 *
 * @author fgodo
 */
public class UsuarioConexion {
    
    
    public static EmpleadosModelo ObtenerUsuario(String Empusuario)
    {
        Connection con = null;
        PreparedStatement stmt;
        ResultSet rss;
        
        EmpleadosModelo empleadoModelo = new EmpleadosModelo();
        
        try 
        {
            con = Conexion.getConexion(con);

            String query = "SELECT * FROM empleados WHERE BINARY Empusuario = ? LIMIT 1;";
            stmt = con.prepareStatement(query);
            stmt.setString(1, Empusuario);
            rss = stmt.executeQuery();
            
            while (rss.next()) 
            {
                empleadoModelo.setEmpcodigo(rss.getInt("Empcodigo"));
                empleadoModelo.setEmpidentidad(rss.getString("Empidentidad"));
                empleadoModelo.setEmpnombre(rss.getString("Empnombre"));
                empleadoModelo.setEmpusuario(rss.getString("Empusuario"));
                empleadoModelo.setEmpcontrasena(rss.getString("Empcontrasena"));
                empleadoModelo.setEmpestado(rss.getString("Empestado"));
  
            }
            
            con.close();
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,e);
        }
        
        return empleadoModelo;
    }

    public static String MantenimientoEditarContra(String accion, RecuperarModelo RecuperarModelo)
    { 
        String estado = "";
        Connection con = null;     
        try
        {
            String query;
            con = Conexion.getConexion(con);
           
            query = "{CALL MantenimientoRecuperarContrasena(?,?,?)}";
            CallableStatement cs = con.prepareCall(query);
            cs.setString            (1, RecuperarModelo.getEmpUsuario());     
            cs.setString            (2, RecuperarModelo.getContrasena());
            cs.registerOutParameter (3, Types.VARCHAR);           
            cs.executeUpdate();
            estado = cs.getString(3);
            System.out.println(estado);
            con.close();
        }
        catch (Exception e)
        {
            estado = e.toString();
        } 
        return estado;
    } 



    
}