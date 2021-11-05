/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexiones;

import Modelos.EmpleadosModelo;
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
public class PuestosConexion {
    public static ArrayList<PuestoModelo> Listadopuestos(String accion) 
    {
        Connection con = null;
        Statement stm;
        ResultSet rss;
        
        ArrayList<PuestoModelo> puestos = new ArrayList<>();
        
        switch(accion)
        {
            case "Activos":
                try
                {
                    con = Conexion.getConexion(con);
                    stm = con.createStatement();
                    
                    String query = "SELECT * From puestos "
                     + "WHERE Pueestado = 'ACT' " 
                     + "ORDER BY Puecodigo ASC";

                    rss = stm.executeQuery(query);

                    while (rss.next()) 
                    {
                        PuestoModelo puesto = new PuestoModelo();
                        puesto.setPuecodigo(rss.getInt("PueCodigo"));
                        puesto.setPuedescripcion(rss.getString("Puedescripcion"));
                        puesto.setPueestado(rss.getString("Pueestado"));;
                        puestos.add(puesto);
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
                    String query = "SELECT * From puestos "
                     + "WHERE Pueestado = 'INA' " 
                     + "ORDER BY Puecodigo ASC";


                    rss = stm.executeQuery(query);

                    while (rss.next()) 
                    {
                        PuestoModelo puesto = new PuestoModelo();
                        puesto.setPuecodigo(rss.getInt("PueCodigo"));
                        puesto.setPuedescripcion(rss.getString("Puedescripcion"));
                        puesto.setPueestado(rss.getString("Pueestado"));;
                        puestos.add(puesto);
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
                    String query = "SELECT * From puestos ";
                    rss = stm.executeQuery(query);
                    while (rss.next()) 
                    {
                        PuestoModelo puesto = new PuestoModelo();
                        puesto.setPuecodigo(rss.getInt("PueCodigo"));
                        puesto.setPuedescripcion(rss.getString("Puedescripcion"));
                        puesto.setPueestado(rss.getString("Pueestado"));;
                        puestos.add(puesto);
                    }
                    con.close();
                } 
                catch (SQLException e)
                {
                    JOptionPane.showMessageDialog(null,e);
                } 
            break;                
        }

        return puestos;
    }
    public static String Mantenimientopuestos(String accion, PuestoModelo PuestoModelo)
    { 
        String estado = "";
        Connection con = null;
        
        try
        {
            String query;
            con = Conexion.getConexion(con);
           
            query = "{CALL MantenimientoPuestos(?,?,?,?,?)}";
            CallableStatement cs = con.prepareCall(query);
            cs.setString            (1, accion);     
            System.out.println(accion);
            cs.setInt               (2, PuestoModelo.getPuecodigo()); 
            cs.setString            (3, PuestoModelo.getPuedescripcion());
            cs.setString            (4, PuestoModelo.getPueestado());
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
