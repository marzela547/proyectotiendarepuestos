/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexiones;

import Modelos.MarcasModelo;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author marce
 */
public class MarcasConexion {
     public static ArrayList<MarcasModelo> Listadomarcas(String accion) 
    {
        Connection con = null;
        Statement stm;
        ResultSet rss;
        
        ArrayList<MarcasModelo> marcas = new ArrayList<>();
        
        switch(accion)
        {
            case "Activos":
                try
                {
                    con = Conexion.getConexion(con);
                    stm = con.createStatement();
                    
                    String query = "SELECT * From marcas "
                     + "WHERE Marestado = 'ACT' " 
                     + "ORDER BY Marcodigo ASC";

                    rss = stm.executeQuery(query);

                    while (rss.next()) 
                    {
                        MarcasModelo marca = new MarcasModelo();
                        marca.setMarcodigo(rss.getInt("Marcodigo"));
                        marca.setMardescripcion(rss.getString("Mardescripcion"));
                        marca.setMarestado(rss.getString("Marestado"));;
                        marcas.add(marca);
                    } 
                    
                    con.close();
                } 
                catch (SQLException e)
                {
                    JOptionPane.showMessageDialog(null,e);
                } 
            break;
                
            case "Inactivos":
                try
                {
                    con = Conexion.getConexion(con);
                    stm = con.createStatement();
                    String query = "SELECT * From marcas "
                     + "WHERE Marestado = 'INA' " 
                     + "ORDER BY Marcodigo ASC";

                    rss = stm.executeQuery(query);

                    while (rss.next()) 
                    {
                        MarcasModelo marca = new MarcasModelo();
                        marca.setMarcodigo(rss.getInt("Marcodigo"));
                        marca.setMardescripcion(rss.getString("Mardescripcion"));
                        marca.setMarestado(rss.getString("Marestado"));;
                        marcas.add(marca);
                    } 
                    
                    con.close();
                } 
                catch (SQLException e)
                {
                    JOptionPane.showMessageDialog(null,e);
                } 
            break; 
                
            case "Todos":
                try
                {
                    con =Conexion.getConexion(con);
                    stm = con.createStatement();
                    String query = "SELECT * From marcas ";
                    rss = stm.executeQuery(query);
                    while (rss.next()) 
                    {
                        MarcasModelo marca = new MarcasModelo();
                        marca.setMarcodigo(rss.getInt("Marcodigo"));
                        marca.setMardescripcion(rss.getString("Mardescripcion"));
                        marca.setMarestado(rss.getString("Marestado"));;
                        marcas.add(marca);
                    }
                    con.close();
                } 
                catch (SQLException e)
                {
                    JOptionPane.showMessageDialog(null,e);
                } 
            break;                
        }

        return marcas;
    }
     public static String Mantenimientomarcas(String accion, MarcasModelo MarcasModelo)
    { 
        String estado = "";
        Connection con = null;
        
        try
        {
            String query;
            con = Conexion.getConexion(con);
           
            query = "{CALL MantenimientoMarcas(?,?,?,?,?)}";
            CallableStatement cs = con.prepareCall(query);
            cs.setString            (1, accion);     
            System.out.println(accion);
            cs.setInt               (2, MarcasModelo.getMarcodigo()); 
            cs.setString            (3, MarcasModelo.getMardescripcion());
            cs.setString            (4, MarcasModelo.getMarestado());
            cs.registerOutParameter (5, Types.VARCHAR);
            
            cs.executeUpdate();
            estado = cs.getString(5);
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
