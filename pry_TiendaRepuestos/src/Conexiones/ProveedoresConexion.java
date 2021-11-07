/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexiones;

import Modelos.ProveedoresModelo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author marce
 */
public class ProveedoresConexion {
     public static ArrayList<ProveedoresModelo> Listadoproveedor(String accion) 
    {
        Connection con = null;
        Statement stm;
        ResultSet rss;
        
        ArrayList<ProveedoresModelo> proveedores = new ArrayList<>();
        
        switch(accion)
        {
            case "Activos":
                try
                {
                    con = Conexion.getConexion(con);
                    stm = con.createStatement();
                    
                    String query = "SELECT * From proveedores"
                     + "WHERE Proestado = 'ACT' " 
                     + "ORDER BY Procodigo ASC";

                    rss = stm.executeQuery(query);

                    while (rss.next()) 
                    {
                        ProveedoresModelo proveedor = new ProveedoresModelo();
                        proveedor.setProcodigo(rss.getInt("Procodigo"));
                        proveedor.setPronombre(rss.getString("Pronombre"));
                        proveedor.setProestado(rss.getString("Proestado"));;
                        proveedores.add(proveedor);
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
                    String query = "SELECT * From proveedores "
                     + "WHERE Proestado = 'INA' " 
                     + "ORDER BY Procodigo ASC";


                    rss = stm.executeQuery(query);

                    while (rss.next()) 
                    {
                        ProveedoresModelo proveedor = new ProveedoresModelo();
                        proveedor.setProcodigo(rss.getInt("Procodigo"));
                        proveedor.setPronombre(rss.getString("Pronombre"));
                        proveedor.setProestado(rss.getString("Proestado"));;
                        proveedores.add(proveedor);
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
                    String query = "SELECT * From proveedores ";
                    rss = stm.executeQuery(query);
                    while (rss.next()) 
                    {
                        ProveedoresModelo proveedor = new ProveedoresModelo();
                        proveedor.setProcodigo(rss.getInt("Procodigo"));
                        proveedor.setPronombre(rss.getString("Pronombre"));
                        proveedor.setProdireccion(rss.getString("Prodireccion"));
                        proveedor.setProtelefono(rss.getString("Protelefono"));
                        proveedor.setProestado(rss.getString("Proestado"));;
                        proveedores.add(proveedor);
                    }
                    con.close();
                } 
                catch (SQLException e)
                {
                    JOptionPane.showMessageDialog(null,e);
                } 
            break;                
        }

        return proveedores;
    }
}
