/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexiones;

import Modelos.ClientesModelo;
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
public class ClientesConexion {
     public static ArrayList<ClientesModelo> Listadocliente(String accion) 
    {
        Connection con = null;
        Statement stm;
        ResultSet rss;
        
        ArrayList<ClientesModelo> clientes = new ArrayList<>();
        
        switch(accion)
        {
            case "Activos":
                try
                {
                    con = Conexion.getConexion(con);
                    stm = con.createStatement();
                    
                    String query = "SELECT * From clientes "
                     + "WHERE Cliestado = 'ACT' " 
                     + "ORDER BY Clicodigo ASC";

                    rss = stm.executeQuery(query);

                    while (rss.next()) 
                    {
                        ClientesModelo cliente = new ClientesModelo();
                        cliente.setClicodigo(rss.getInt("Clicodigo"));
                        cliente.setRTN(rss.getString("RTN"));
                        cliente.setClinombre(rss.getString("Clinombre"));;
                        cliente.setClitelefono(rss.getString("Clitelefono"));
                        cliente.setCliestado(rss.getString("Cliestado"));
                        clientes.add(cliente);
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
                    String query = "SELECT * From clientes "
                     + "WHERE Cliestado = 'INA' " 
                     + "ORDER BY Clicodigo ASC";


                    rss = stm.executeQuery(query);

                    while (rss.next()) 
                    {
                        ClientesModelo cliente = new ClientesModelo();
                        cliente.setClicodigo(rss.getInt("Clicodigo"));
                        cliente.setRTN(rss.getString("RTN"));
                        cliente.setClinombre(rss.getString("Clinombre"));;
                        cliente.setClitelefono(rss.getString("Clitelefono"));
                        cliente.setCliestado(rss.getString("Cliestado"));
                        clientes.add(cliente);
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
                    String query = "SELECT * From clientes ";
                    rss = stm.executeQuery(query);
                    while (rss.next()) 
                    {
                        ClientesModelo cliente = new ClientesModelo();
                        cliente.setClicodigo(rss.getInt("Clicodigo"));
                        cliente.setRTN(rss.getString("RTN"));
                        cliente.setClinombre(rss.getString("Clinombre"));;
                        cliente.setClitelefono(rss.getString("Clitelefono"));
                        cliente.setCliestado(rss.getString("Cliestado"));
                        clientes.add(cliente);
                    }
                    con.close();
                } 
                catch (SQLException e)
                {
                    JOptionPane.showMessageDialog(null,e);
                } 
            break;                
        }

        return clientes;
    }
     public static String Mantenimientoclientes(String accion, ClientesModelo ClientesModelo)
    { 
        String estado = "";
        Connection con = null;
        
        try
        {
            String query;
            con = Conexion.getConexion(con);
           
            query = "{CALL MantenimientoClientes(?,?,?,?,?,?,?)}";
            CallableStatement cs = con.prepareCall(query);
            cs.setString            (1, accion);     
            System.out.println(accion);
            cs.setInt               (2, ClientesModelo.getClicodigo()); 
            cs.setString            (3,  ClientesModelo.getClinombre());
            cs.setString            (4,  ClientesModelo.getClitelefono());
            cs.setString            (5,  ClientesModelo.getRTN());
            cs.setString            (6,  ClientesModelo.getCliestado());
            cs.registerOutParameter (7, Types.VARCHAR);
            
            cs.executeUpdate();
            estado = cs.getString(12);
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
