/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexiones;

import Modelos.TiposModelo;
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
public class TiposConexion {
    public static ArrayList<TiposModelo> Listadotipos(String accion) 
    {
        Connection con = null;
        Statement stm;
        ResultSet rss;
        
        ArrayList<TiposModelo> tipos = new ArrayList<>();
        
        switch(accion)
        {
            case "Activos":
                try
                {
                    con = Conexion.getConexion(con);
                    stm = con.createStatement();
                    
                    String query = "SELECT * From tipoproducto "
                     + "WHERE Tipestado = 'ACT' " 
                     + "ORDER BY Tipcodigo ASC";

                    rss = stm.executeQuery(query);

                    while (rss.next()) 
                    {
                        TiposModelo tipo = new TiposModelo();
                        tipo.setTipcodigo(rss.getInt("Tipcodigo"));
                        tipo.setTipdescripcion(rss.getString("Tipdescripcion"));
                        tipo.setTipestado(rss.getString("Tipestado"));;
                        tipos.add(tipo);
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
                    String query = "SELECT * From tipoproducto "
                     + "WHERE Tipestado = 'INA' " 
                     + "ORDER BY Tipcodigo ASC";

                    rss = stm.executeQuery(query);

                    while (rss.next()) 
                    {
                        TiposModelo tipo = new TiposModelo();
                        tipo.setTipcodigo(rss.getInt("Tipcodigo"));
                        tipo.setTipdescripcion(rss.getString("Tipdescripcion"));
                        tipo.setTipestado(rss.getString("Tipestado"));;
                        tipos.add(tipo);
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
                    String query = "SELECT * From tipoproducto ";
                    rss = stm.executeQuery(query);
                    while (rss.next()) 
                    {
                        TiposModelo tipo = new TiposModelo();
                        tipo.setTipcodigo(rss.getInt("Tipcodigo"));
                        tipo.setTipdescripcion(rss.getString("Tipdescripcion"));
                        tipo.setTipestado(rss.getString("Tipestado"));;
                        tipos.add(tipo);
                    }
                    con.close();
                } 
                catch (SQLException e)
                {
                    JOptionPane.showMessageDialog(null,e);
                } 
            break;                
        }

        return tipos;
    }
    public static String Mantenimientotipos(String accion, TiposModelo TiposModelo)
    { 
        String estado = "";
        Connection con = null;
        
        try
        {
            String query;
            con = Conexion.getConexion(con);
           
            query = "{CALL MantenimientoTipos(?,?,?,?,?)}";
            CallableStatement cs = con.prepareCall(query);
            cs.setString            (1, accion);     
            System.out.println(accion);
            cs.setInt               (2, TiposModelo.getTipcodigo()); 
            cs.setString            (3, TiposModelo.getTipdescripcion());
            cs.setString            (4, TiposModelo.getTipestado());
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
