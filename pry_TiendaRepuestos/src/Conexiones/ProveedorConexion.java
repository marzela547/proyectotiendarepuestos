/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexiones;

import Modelos.EmpleadosModelo;
import Modelos.ProveedorModelo;
import Modelos.PuestoModelo;
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
 * @author fgodo
 */
public class ProveedorConexion {
      public static ArrayList<ProveedorModelo> Listadoproveedores(String accion) 
    {
        Connection con = null;
        Statement stm;
        ResultSet rss;
        
        ArrayList<ProveedorModelo> proveedores = new ArrayList<>();
        
        switch(accion)
        {
            case "Activos":
                try
                {
                    con = Conexion.getConexion(con);
                    stm = con.createStatement();
                    
                    String query = "SELECT * From proveedores "
                     + "WHERE Proestado = 'ACT' " 
                     + "ORDER BY Procodigo ASC";

                    rss = stm.executeQuery(query);

                    while (rss.next()) 
                    {
                        ProveedorModelo proveedor = new ProveedorModelo();
                        proveedor.setProcodigo(rss.getInt("Procodigo"));
                        proveedor.setPronombre(rss.getString("Pronombre"));
                        proveedor.setProdireccion(rss.getString("Prodireccion"));
                        proveedor.setProtelefono(rss.getString("Protelefono"));
                        proveedor.setProestado(rss.getString("Proestado"));
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
                        ProveedorModelo proveedor = new ProveedorModelo();
                        proveedor.setProcodigo(rss.getInt("Procodigo"));
                        proveedor.setPronombre(rss.getString("Pronombre"));
                        proveedor.setProdireccion(rss.getString("Prodireccion"));
                        proveedor.setProtelefono(rss.getString("Protelefono"));
                        proveedor.setProestado(rss.getString("Proestado"));
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
                        ProveedorModelo proveedor = new ProveedorModelo();
                        proveedor.setProcodigo(rss.getInt("Procodigo"));
                        proveedor.setPronombre(rss.getString("Pronombre"));
                        proveedor.setProdireccion(rss.getString("Prodireccion"));
                        proveedor.setProtelefono(rss.getString("Protelefono"));
                        proveedor.setProestado(rss.getString("Proestado"));
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
    
    
    public static String Mantenimientoproveedores(String accion, ProveedorModelo ProveedorModelo)
    { 
        String estado = "";
        Connection con = null;     
        try
        {
            String query;
            con = Conexion.getConexion(con);
           
            query = "{CALL MantenimientoProveedor(?,?,?,?,?,?,?)}";
            CallableStatement cs = con.prepareCall(query);
            cs.setString            (1, accion);     
            cs.setInt               (2, ProveedorModelo.getProcodigo()); 
            cs.setString            (3, ProveedorModelo.getPronombre());
            cs.setString            (4, ProveedorModelo.getProdireccion());
            cs.setString            (5, ProveedorModelo.getProtelefono());
            cs.setString            (6, ProveedorModelo.getProestado()); 
            cs.registerOutParameter (7, Types.VARCHAR);           
            cs.executeUpdate();
            estado = cs.getString(7);
            System.out.println(estado);
            con.close();
        }
        catch (Exception e)
        {
            estado = e.toString();
            System.out.println(estado);
        } 
        return estado;
    }    
}
